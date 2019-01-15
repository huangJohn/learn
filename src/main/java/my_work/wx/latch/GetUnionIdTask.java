package my_work.wx.latch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import my_work.wx.UnionIdData;
import my_work.wx.constant.WebConstant;
import my_work.wx.http.HttpResponseMeta;
import my_work.wx.http.WebHttpService;
import my_work.wx.http.WebHttpServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import static my_work.wx.constant.WebConstant.ACCESS_TOKEN_PARAM_KEY;


/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-14
 */
public class GetUnionIdTask implements Callable<List<UnionIdData>> {

    public static final Logger myLog = LoggerFactory.getLogger(GetUnionIdTask.class);

    private WebHttpService webHttpService;

    private UnionIdStep step;

    private String accessToken;

    public GetUnionIdTask(UnionIdStep step, String accessToken) {

        this.step = step;
        this.accessToken = accessToken;
        this.webHttpService = new WebHttpServiceImpl();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UnionIdData> call() {

        if (CollectionUtils.isEmpty(step.getBatch().getPartitions())) {
            return null;
        }

        List<UnionIdData> ret = Lists.newArrayList();

        LinkedHashMap<String, Object> params = Maps.newLinkedHashMap();

        List<Map<String, Object>> list = Lists.newArrayList();

        for (String openid : step.getBatch().getPartitions()) {

            if (StringUtils.isNotBlank(openid)) {
                LinkedHashMap<String, Object> per = Maps.newLinkedHashMap();
                per.put("openid", openid);
                per.put("lang", "zh_CN");
                list.add(per);
            }
        }

        params.put("user_list", list);

        String body = JSON.toJSONString(params);

        HttpResponseMeta httpResponseMeta = webHttpService.httpPost(WebConstant.GET_UNIONID_URL + "?" + ACCESS_TOKEN_PARAM_KEY + "=" + accessToken, null, body);

        if (null != httpResponseMeta && 200 == httpResponseMeta.getCode() && StringUtils.isNotBlank(httpResponseMeta.getResponseAsString())) {

            try {
                JSONObject jsonObject = JSONObject.parseObject(httpResponseMeta.getResponseAsString());

                //成功
                if (null != jsonObject && null == jsonObject.get("errcode")) {

                    //return data

                    if (jsonObject.get("user_info_list") != null) {

                        List<Map<String, Object>> user_info_list = (List<Map<String, Object>>) jsonObject.get("user_info_list");

                        if (CollectionUtils.isNotEmpty(user_info_list)) {

                            for (Map<String, Object> per : user_info_list) {

                                if (MapUtils.isNotEmpty(per)) {

                                    UnionIdData unionIdData = new UnionIdData();

                                    if (1 == (int) per.get("subscribe")) {


                                        unionIdData.setUnionId((String) per.get("unionid"))
                                                .setOpenid((String) per.get("openid")).setSubscribe(1);
                                    }

                                    if (0 == (int) per.get("subscribe")) {

                                        unionIdData.setUnionId(null).setOpenid((String) per.get("openid")).setSubscribe(0);

                                    }

                                    myLog.info("unionIdData done. data = " + unionIdData.toString());
                                    ret.add(unionIdData);
                                }
                            }
                        }

                    }


                    step.done(ret);

                    return ret;

                } else {
                    myLog.info("jsonObject error. jsonObject=" + jsonObject.toJSONString());
                    throw new RuntimeException("jsonObject error. jsonObject=" + jsonObject.toJSONString());
                }
            } catch (Exception e) {
                myLog.info(("parseObject error. Response={" + httpResponseMeta.getResponseAsString()));
                throw new RuntimeException("parseObject error. Response={" + httpResponseMeta.getResponseAsString());
            }
        } else {
            myLog.info(("httpGet error. httpResponseMeta=" + JSON.toJSONString(httpResponseMeta)));
            throw new RuntimeException("httpGet error. httpResponseMeta=" + JSON.toJSONString(httpResponseMeta));

        }

    }
}
