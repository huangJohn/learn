package com.zh.learn.alipay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayOpenPublicFollowBatchqueryRequest;
import com.alipay.api.response.AlipayOpenPublicFollowBatchqueryResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/9/18
 */
public class FansFetchWork {

    public static final String appId = "2015120100895099";
    public static final String alipayRequestUrl = "https://openapi.alipay.com/gateway.do";
    public static final String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCrVMSUkxUilQFIY9stQZbOJT5PGrNiXaX3jn6PtAZIHsMRp88E/26Ys8FnoqXIkIk6//0rTIinjOEo/7QQdd1954F6GC1oJXorSrjZCFTTF7RZCmxE8IDZoSEFHBzHcghT/lWdWV2vKmk2AZMkSJxA65rQVzTqVNWt6MQyYcS/f/65hEkWY9GqMJ1Xjkabsr17UGT2VSQh2HF2oNRH+iJO/3Dl3yEub+w9eU8eUVXsXnhZ8TtczriPhjhsrAqGnP9mDJdc0KdhO3cTig8P7Pq0Aerfp8QFK4PehU6lkVZumB6KLiuRu9r7Ed4Qek64Xor0LhTRADK+n8PXH8HH/GOpAgMBAAECggEACW9Ul/31hv7/oBXnpvlaraV9ZevJfxw7HIPbUlyOkAApq9o620KZu40ClItvZ7kV5YrdTTocuGVYrOJP7ywec2WBStD0By0xKhsmTMVZrno6s0CQr8cywUlPQTHIH++Wp9F0s4KNVy0VuCSkDrZ07FpNHzX+Mv1S+w27aC7cH9N8RxAkYeoK2rv45zurI1c4Upt9og/RC1gd4k9hkn933cnC+MW07j3kanTd/3NGKZOQUEGZuAoRjOGwOgFixXiISJrk7eWX5mQos9hYWnzC8Ylz2mbmIN8cASDYsEZDeCAmus+YuYGZ+UIcCFuDabu82LUYN2Au7iKVxJe2DSGWZQKBgQDzUWgnALj3G2aIvvdYeb67uyiqrV3MTV+u0duMGECMNEof7PYcWAHUmxqambWYeBPRM534cV0hgkFRlAbQBfaiLhgB9r+ScQzwHb3UAxnXlP2DNwHGQDsD3ix8Am9ZR3vZM59APsgGc1gYmoN7q5bqKumnIPuyeu27ovUjS7FiqwKBgQC0QtcDFSQGaSLF/KL2bmT1ENHzoZn8mQSN+wHeJiVhPZAp/eX9ZKoykHl8YwmSsRnt4in6zjvsGt8apk9X80HeTuzihL51VpsewhVrlKefzTPU+mG3IrJxFqF405V8vCtRrusqhMu39C1xlX2vkMbgqnx4uEnaQb5ho3+ffWHy+wKBgEUD2TP+63gDyKCO8h+hYK1lF9LZm9pgM/ylP83L7zsVddT6ZJCDkflZCUHCyZR2ssBLEMqwdQcVKCvYfdoxZtR3mI2uDIagFFhjRz3Ep2bTttiqGJHAFD0znpCKLEU5lnJ0Rv51EE1sGBfac+L3N7Yx99ZU76+fWKE5Rqj9RlJDAoGBAIdpOnlvVRuXuO5/pK94KFDL7NuWhsVw8THy3+lQQH42r+hLeYyLJStMymX9Q8C1V2QSpDRq3iqz2Or9Cddovg9QvLRAwY4FnAtUAqFJD06E6K3R1Luszd0UAgJw9ve3ptb6jl/nV919CPItOTg8iplUmKJa1eelwW05U/KsTnsnAoGAamnUATv4udVA96uXZc1+VT/CDOxcOzJdzYAO3WxXO7zOXwKBksY5X4HkRZ3IXLuHA9QtRmsHypuFGxUQ+Nc9rri0ZEsM94Nzkc7zSBsoBOiuEUrsQRpeQtT4hXnl3N6HdMNAgjECQHtCnSU+KzX0cexToo6FI7gl+rLsNr+j+6I=";
    public static final String format = "json";
    public static final String charset = "utf-8";
    public static final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq1TElJMVIpUBSGPbLUGWziU+TxqzYl2l945+j7QGSB7DEafPBP9umLPBZ6KlyJCJOv/9K0yIp4zhKP+0EHXdfeeBehgtaCV6K0q42QhU0xe0WQpsRPCA2aEhBRwcx3IIU/5VnVldryppNgGTJEicQOua0Fc06lTVrejEMmHEv3/+uYRJFmPRqjCdV45Gm7K9e1Bk9lUkIdhxdqDUR/oiTv9w5d8hLm/sPXlPHlFV7F54WfE7XM64j4Y4bKwKhpz/ZgyXXNCnYTt3E4oPD+z6tAHq36fEBSuD3oVOpZFWbpgeii4rkbva+xHeEHpOuF6K9C4U0QAyvp/D1x/Bx/xjqQIDAQAB";
    public static final String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiN8irvyNuInIkj9x8uCsqhaKEwF+5xbtiIL9fjADYm67iA7fRrs1ep//FLgdX/4LQNJ/HLSYrZVv4XtX9y/sSXeXpHTqzqAhUW3SfzmIAHw1kfkaxPkkHBKOCxS1llxOQnMCbyhc0KMgwTyU1lRL/X1GCNa7GYLcQN46GGxaurjpnpar2vytrbL4lsnYX7zkcAowDkkwJQbm6663kTnYpxbPNAGGgCITudk2K96CLXvNQxaHBGQJD9ZccO8vFnU5/VFRg9dvd/wfeDYZ9DcAl+y4erT/IveYSQZFv4gTk7tqMGk6vfmhqDwTWoi2WUYRzziDwWe90JQKZLzkBXTOEwIDAQAB";
    public static final String signType = "RSA2";

    public static final int MAX_COUNT = 270;


    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir");
        path = path + "/files";
        String fileName = path + "/alipay_userId.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));

        AlipayClient alipayClient = new DefaultAlipayClient(alipayRequestUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
        AlipayOpenPublicFollowBatchqueryRequest request = new AlipayOpenPublicFollowBatchqueryRequest();
        request.setBizContent(null);
        AlipayOpenPublicFollowBatchqueryResponse response = null;
        String nextUserId = null;
        int success = 0;
        try {
            response = alipayClient.execute(request);
            if (response.isSuccess()) {
                System.out.println("调用成功");
                String body = response.getBody();
                JSONObject jsonObject = JSON.parseObject(body);
                Map<String, Object> obj = (Map<String, Object>) jsonObject.get("alipay_open_public_follow_batchquery_response");
                Map<String, Object> data = (Map<String, Object>) obj.get("data");
                List<String> userIdList = (List<String>) data.get("alipay_user_id_list");
                Integer count = Integer.valueOf((String) obj.get("count"));
                success = success + count;
                dumpToDisk(writer, userIdList);
                nextUserId = response.getNextUserId();
            } else {
                System.out.println("调用失败");
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        int count = 0;
        int error = 0;
        for (int i = 0; i < MAX_COUNT; i++) {
            request.setBizContent("{" + "\"next_user_id\":\"" + nextUserId + "\"" + "}");
            try {
                AlipayOpenPublicFollowBatchqueryResponse response1 = alipayClient.execute(request);
                if (response1.isSuccess()) {
                    count++;
                    if (count % 20000 == 0) {
                        System.out.println("调用成功. count=" + count);
                    }
                    String body = response1.getBody();
                    JSONObject jsonObject = JSON.parseObject(body);
                    Map<String, Object> obj = (Map<String, Object>) jsonObject.get("alipay_open_public_follow_batchquery_response");
                    Map<String, Object> data = (Map<String, Object>) obj.get("data");
                    List<String> userIdList = (List<String>) data.get("alipay_user_id_list");
                    Integer count1 = Integer.valueOf((String) obj.get("count"));
                    success = success + count1;
                    dumpToDisk(writer, userIdList);
                    nextUserId = response1.getNextUserId();
                } else {
                    error++;
                    if (error % 500 == 0) {
                        System.out.println("调用失败. error=" + error);
                    }
                }
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
        }

        System.out.println("获取的user id数目=" + success);
        System.out.println("失败数目=" + error);


    }

    public static void dumpToDisk(BufferedWriter writer, List<String> userIdList) throws IOException {

        if (CollectionUtils.isEmpty(userIdList)) {
            return;
        }

        int i = 0;

        for (String userId : userIdList) {
            if (i % 5000 == 0) {
                writer.flush();
            }
            if (StringUtils.isNotBlank(userId.trim())) {
                writer.write(userId.trim());
                writer.newLine();
                i++;
            }
        }
        writer.flush();
    }

}
