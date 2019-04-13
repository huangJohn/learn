package com.zh.learn.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.zh.learn.wx.constant.WebConstant;
import com.zh.learn.wx.http.HttpResponseMeta;
import com.zh.learn.wx.http.WebHttpService;
import com.zh.learn.wx.http.WebHttpServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-14
 */
public class OpenIdClient {

    public static final Logger logger = LoggerFactory.getLogger(OpenIdClient.class);

    public static void main(String[] args) {

        String filePath = "/Users/kevin/Desktop/all_openid.txt";
        int totalWriteCount = 0;
        int count = 0;
        WebHttpService webHttpService = new WebHttpServiceImpl();

        String accessToken = "17_CVvrd9hg1WBWEt6zLQCRBPXz1SWMe20DfyoLdUF7I0g_jbURBhs_aNgJLSNHLLSG5sxElKos0fjMVJKI6UN2eQ-AIcHJ4Q1RozTEbT4lhpeEYTZ1QdpLUUuQTX-BO0VzkHay2e0XmmCYFnr9NOSjAJAXYC";

        LinkedHashMap<String, Object> params = Maps.newLinkedHashMap();
        params.put(WebConstant.ACCESS_TOKEN_PARAM_KEY, accessToken);
        OpenidData openidData = get(webHttpService, null, params);

        logger.info("first===" + openidData.getCount());
        int writeCount = write(openidData, filePath);
        logger.info("first>>>" + writeCount);
        count++;

        totalWriteCount = totalWriteCount + writeCount;

        String nextOpenid = openidData.getNextOpenid();

        for (int i = 0; i < 250; i++) {
            LinkedHashMap<String, Object> params1 = Maps.newLinkedHashMap();
            params1.put(WebConstant.ACCESS_TOKEN_PARAM_KEY, accessToken);
            params1.put(WebConstant.NEXT_OPENID_PARAM_KEY, nextOpenid);
            OpenidData openidData1 = get(webHttpService, null, params1);
            if (null != openidData1) {
                int write = write(openidData1, filePath);
                totalWriteCount = totalWriteCount + write;
                count++;
                nextOpenid = openidData1.getNextOpenid();
            }

            if (totalWriteCount % 10000 == 0) {
                logger.info("has get " + totalWriteCount);
            }

        }

        logger.info("=====over=====" + totalWriteCount);


    }

    public static OpenidData get(WebHttpService webHttpService, Map<String, String> header, Map<String, Object> params) {

        HttpResponseMeta httpResponseMeta = webHttpService.httpGet(WebConstant.GET_OPENID_URL, null, params);
        if (null != httpResponseMeta && 200 == httpResponseMeta.getCode() && StringUtils.isNotBlank(httpResponseMeta.getResponseAsString())) {

            try {
                JSONObject jsonObject = JSONObject.parseObject(httpResponseMeta.getResponseAsString());

                //成功
                if (null != jsonObject && null == jsonObject.get("errcode")) {

                    //return data
                    OpenidData openidData = new OpenidData();

                    if (jsonObject.get("total") != null) {
                        openidData.setTotal((int) jsonObject.get("total"));
                    }
                    if (jsonObject.get("count") != null) {
                        openidData.setCount((int) jsonObject.get("count"));
                    }
                    if (jsonObject.get("next_openid") != null) {
                        openidData.setNextOpenid((String) jsonObject.get("next_openid"));
                    }
                    if (jsonObject.get("data") != null) {
                        if (MapUtils.isNotEmpty((Map<String, List<String>>) jsonObject.get("data"))) {
                            if (CollectionUtils.isNotEmpty(((Map<String, List<String>>) jsonObject.get("data")).get("openid"))) {
                                openidData.setOpenidLists(((Map<String, List<String>>) jsonObject.get("data")).get("openid"));
                            }
                        }
                    }
                    return openidData;
                } else {
                    logger.error("jsonObject error. jsonObject={}, params={}", jsonObject.toJSONString(), JSON.toJSONString(params));
                    return null;
                }
            } catch (Exception e) {
                logger.error(("parseObject error. Response={}, params={}"), httpResponseMeta.getResponseAsString(), JSON.toJSONString(params));
                return null;
            }
        } else {
            logger.error(("httpGet error. httpResponseMeta={}, params={}"), JSON.toJSONString(httpResponseMeta), JSON.toJSONString(params));
            return null;
        }
    }

    public static int write(OpenidData openidData, String filePath) {

        int writeCount = 0;
        File file = new File(filePath);
        List<String> openidLists = openidData.getOpenidLists();
        if (CollectionUtils.isNotEmpty(openidLists)) {
            for (String openid : openidLists) {
                if (StringUtils.isNotBlank(openid)) {
                    try {
                        FileUtils.write(file, openid + "\n", Charset.forName("UTF-8"), true);
                        writeCount++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return writeCount;
    }

}
