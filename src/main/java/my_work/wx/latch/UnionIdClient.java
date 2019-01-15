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
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static my_work.wx.constant.WebConstant.ACCESS_TOKEN_PARAM_KEY;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-14
 */
public class UnionIdClient {

    public static final Logger myLog = LoggerFactory.getLogger(UnionIdClient.class);

    public static final String filePath = "/Users/kevin/Desktop/all_openid_filter.txt";

    public static final String filePath2 = "/Users/kevin/Desktop/all_openid_unionid.txt";

    public static final int allUser = 2_239_050;

    public static final int maxGroup = 22_391;

    public static final int groupLength = 100;

    public static AtomicInteger seq = new AtomicInteger();

    public static Map<Integer, List<String>> groups = Maps.newLinkedHashMap();

    public static List<String> allOpenids = Lists.newArrayList();

    public static List<List<String>> allPartitions = Lists.newArrayList();

    public static void main(String[] args) throws InterruptedException {

        long st = System.currentTimeMillis();

        allOpenids = readOpenidFromDisk(filePath);
        if (CollectionUtils.isEmpty(allOpenids) || allOpenids.size() != allUser) {
            System.exit(0);
        }

        allPartitions = ListUtils.partition(allOpenids, groupLength);

        for (int i = 0; i < allPartitions.size(); i++) {
            if (!groups.containsKey(i)) {
                groups.put(i, allPartitions.get(i));
            }
        }


        String accessToken = "17_uA-rpEM-kUfvxtHHN_XHBJQeFq8Buc2rXpcUVvDEKcvqf4bt4qYafiSN6L2xvoUEAjNtv1rJbtl5_v6HEca1NI-rCpsL_CwtnFWLvqs3U6B0VKpNKHuJdu1lhysgkv-A3KesVY2u2nLWfMW6UDYfAEACLG";

        final ExecutorService executorService = Executors.newFixedThreadPool(200);

        final WebHttpService webHttpService = new WebHttpServiceImpl();


//        List<String> list = groups.get(0);
//
//        UnionIdBatch batch = new UnionIdBatch(0, list);
//
//        UnionIdStep step = new UnionIdStep(2, batch);

//        GetUnionIdTask getUnionIdTask = new GetUnionIdTask(step, accessToken);
//
//        Future<List<UnionIdData>> future = executorService.submit(getUnionIdTask);
//
//        List<UnionIdData> unionIdDataList = null;
//        try {
//            unionIdDataList = future.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        if (null != unionIdDataList) {
//            WriteUnionIdTask writeUnionIdTask = new WriteUnionIdTask(unionIdDataList, step, filePath2);
//            executorService.execute(writeUnionIdTask);
//        }

//        CompletableFuture.supplyAsync(
//
//                () -> {
//                    return getUidWork(step, webHttpService, accessToken);
//                }, executorService)
//                .whenComplete((v, t) -> {
//
//                            if (t != null) {
//                                myLog.info("error={}", t.getCause());
//                                throw new RuntimeException(t);
//                            }
//
//                            myLog.info("step get union id work done. batch id = " + step.getBatch().getId());
//
//                            CompletableFuture.runAsync(new WriteUnionIdTask(v, step, filePath2), executorService)
//                                    .whenComplete((v1, t1) -> {
//                                        if (t1 != null) {
//                                            myLog.info("error={}", t1.getCause());
//                                            throw new RuntimeException(t1);
//                                        }
//                                        myLog.info("step write work done. batch id = " + step.getBatch().getId());
//                                    });
//                        }
//
//                );

        for (Map.Entry<Integer, List<String>> entry : groups.entrySet()) {

            int id = entry.getKey();

            List<String> partition = entry.getValue();

            final UnionIdBatch batch = new UnionIdBatch(id, partition);

            final UnionIdStep step = new UnionIdStep(2, batch);

            CompletableFuture.supplyAsync(

                    () -> {
                        return getUidWork(step, webHttpService, accessToken);
                    }, executorService)
                    .whenComplete((v, t) -> {

                                if (t != null) {
                                    myLog.info("error={}", t.getCause());
                                    throw new RuntimeException(t);
                                }

                                myLog.info("step get union id work done. batch id = " + step.getBatch().getId());

                                CompletableFuture.runAsync(new WriteUnionIdTask(v, step, filePath2), executorService)
                                        .whenComplete((v1, t1) -> {

                                            if (t1 != null) {
                                                myLog.info("error={}", t1.getCause());
                                                throw new RuntimeException(t1);
                                            }


                                            myLog.info("step write work done. batch id = " + step.getBatch().getId());
                                        });

                            }

                    );
        }

        long end = System.currentTimeMillis();

        myLog.info("submit all tasks cost time: " + (end - st) / 1000);

        Thread.currentThread().join();


    }

    // first load all openids
    public static List<String> readOpenidFromDisk(String filePath) {

        if (StringUtils.isBlank(filePath)) {
            return null;
        }

        ArrayList<String> list = Lists.newArrayList();

        File file = new File(filePath);
        try {
            for (String readLine : FileUtils.readLines(file, Charset.forName("UTF-8"))) {
                readLine = readLine.replaceAll("\n", "");
                list.add(readLine);
            }
            myLog.info("====" + (allUser == list.size()));
            myLog.info("read form disk over. all openid count = " + list.size());
            return list;
        } catch (IOException e) {
            myLog.error("error", e);
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    public static List<UnionIdData> getUidWork(UnionIdStep step, WebHttpService webHttpService, String accessToken) {

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
                                    } else {

                                        unionIdData.setUnionId(null).setOpenid((String) per.get("openid")).setSubscribe(0);

                                    }

//                                    myLog.info("unionIdData done. data = " + unionIdData.toString());
                                    ret.add(unionIdData);
                                }
                            }
                        }

                    }


                    step.done(ret);

                    return ret;

                } else {
                    myLog.error("jsonObject error. jsonObject={}, params={}", jsonObject.toJSONString(), JSON.toJSONString(params));
                    throw new RuntimeException("jsonObject error. jsonObject=" + jsonObject.toJSONString());
                }
            } catch (Exception e) {
                myLog.error(("parseObject error. Response={}, params={}"), httpResponseMeta.getResponseAsString(), JSON.toJSONString(params));
                throw new RuntimeException("parseObject error. Response={" + httpResponseMeta.getResponseAsString());
            }
        } else {
            myLog.error(("httpGet error. httpResponseMeta={}, params={}"), JSON.toJSONString(httpResponseMeta), JSON.toJSONString(params));
            throw new RuntimeException("httpGet error. httpResponseMeta=" + JSON.toJSONString(httpResponseMeta));

        }

    }
}
