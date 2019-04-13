package com.zh.learn.wx.http;

import java.util.Map;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-14
 */
public interface WebHttpService {


    HttpResponseMeta httpGet(String url, Map<String, String> headers, Map<String, Object> params);

    HttpResponseMeta httpPost(String url, Map<String, String> headers, Map<String, Object> params);

    HttpResponseMeta httpPost(String url, Map<String, String> headers, String body);

}
