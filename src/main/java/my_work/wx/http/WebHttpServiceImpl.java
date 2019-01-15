package my_work.wx.http;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-14
 */
public class WebHttpServiceImpl implements WebHttpService {

    public static String DEFAULT_ENCODING = "utf-8";

    public static final Logger myLog = LoggerFactory.getLogger(WebHttpServiceImpl.class);

    @Override
    public HttpResponseMeta httpGet(String url, Map<String, String> headers, Map<String, Object> params) {

        String host = StringUtils.EMPTY;
        HttpGet get = null;

        try {
            get = getUri(url, params);
            if (get == null || get.getURI() == null) {
                throw new Exception("HttpGet is null");
            }
            host = get.getURI().getHost();
            if (StringUtils.isBlank(host)) {
                throw new Exception("host string is null");
            }
        } catch (Exception e) {
            myLog.error("", e);
            return null;
        }

        HttpResponseMeta response = null;

        try {
            myLog.info((String.format("request= url: %s, headers: %s, params: %s,", url, headers, params)));
            response = httpGet(url, headers, params, get);
            //返回结果
            myLog.info(("response= " + (response == null && null != response.getResponseAsString() ? "" : response.getResponseAsString().replaceAll("\n", "#"))));
        } catch (java.net.SocketException e) {
            // 服务端异常断开socket，连接断开后的读和写操作引起的
            myLog.error("", e);
        } catch (java.net.SocketTimeoutException e) {
            // 获取服务端数据超时，2s内没有获取到数据
            myLog.error("", e);
        } catch (org.apache.http.conn.ConnectTimeoutException e) {
            // 等待与服务器建立连接超时
            myLog.error("", e);
        } catch (Throwable e) {
            myLog.error("", e);
        }

        return response;
    }

    /**
     * 为了获取uri
     *
     * @param url
     * @return
     */
    public static HttpPost getUri(String url) {
        String newUrl = parseURL(url);
        HttpPost post = new HttpPost(newUrl);
        return post;
    }

    @Override
    public HttpResponseMeta httpPost(String url, Map<String, String> headers, Map<String, Object> params) {
        String host = "";
        HttpPost post = null;
        try {
            post = getUri(url);
            if (post == null || post.getURI() == null) {
                myLog.warn(("HttpPost is null= " + url));
                return null;
            }
            host = post.getURI().getHost();
            if (StringUtils.isBlank(host)) {
                myLog.warn("host string is null");
                return null;
            }
        } catch (Exception e) {
            myLog.error("", e);
            return null;
        }

        boolean isNeedRelease = false;
        HttpResponseMeta response = null;
        try {
            myLog.info(String.format("request= url: %s, headers: %s, params: %s,", url, headers, params));
            response = httpPost(url, headers, params, post, SocketTimeout.timeout_2_s);
            myLog.info("response= " + (response == null ? "" : response.getResponseAsString()));
        } catch (java.net.SocketException e) {
            // 服务端异常断开socket，连接断开后的读和写操作引起的
            myLog.error("", e);
        } catch (java.net.SocketTimeoutException e) {
            // 获取服务端数据超时，2s内没有获取到数据
            myLog.error("", e);
        } catch (org.apache.http.conn.ConnectTimeoutException e) {
            // 等待与服务器建立连接超时
            myLog.error("", e);
        } catch (Throwable e) {
            myLog.error("", e);
        }
        return response;
    }

    @Override
    public HttpResponseMeta httpPost(String url, Map<String, String> headers, String body) {
        HttpPost post = null;
        String host = "";
        try {
            post = getUri(url);
            if (post == null || post.getURI() == null) {
                myLog.warn("2HttpPost is null= " + url);
                return null;
            }
            host = post.getURI().getHost();
            if (StringUtils.isBlank(host)) {
                myLog.warn("2host string is null");
                return null;
            }
        } catch (Exception e) {
            myLog.error("", e);
            return null;
        }

        boolean isNeedRelease = false;
        HttpResponseMeta response = null;
        try {
            myLog.info(String.format("request= url: %s, headers: %s, body: %s,", url, headers, body));
            response = httpPost(url, headers, body, post, SocketTimeout.timeout_5_s);
            myLog.info("response= " + (response == null && null != response.getResponseAsString() ? "" : response.getResponseAsString().replaceAll("\n", "#")));
        } catch (java.net.SocketException e) {
            // 服务端异常断开socket，连接断开后的读和写操作引起的
            myLog.error("", e);
        } catch (java.net.SocketTimeoutException e) {
            // 获取服务端数据超时，2s内没有获取到数据
            myLog.error("", e);
        } catch (org.apache.http.conn.ConnectTimeoutException e) {
            // 等待与服务器建立连接超时
            myLog.error("", e);
        } catch (Throwable e) {
            myLog.error("", e);
        }
        return response;
    }

    /**
     * 获取uri
     *
     * @param url
     * @param params
     * @return
     */
    public static HttpGet getUri(String url, Map<String, Object> params) {

        String newUrl = parseURL(url);
        if (newUrl == null) {
            return null;
        }
        if (params != null) {
            newUrl = newUrl + "?" + encodeParams(params);
        }

        HttpGet get = new HttpGet(newUrl);
        return get;
    }

    public static String parseURL(String url) {

        if (StringUtils.isNotBlank(url)) {
            if (url.startsWith("http")) {
                return url;
            } else {
                return "http://" + url;
            }
        } else {
            myLog.warn(("url param is null"));
            return null;
        }
    }

    /**
     * 将params map类型的参数转换为key=value&key2=value2
     *
     * @param params
     * @return
     */
    public static String encodeParams(Map<String, Object> params) {

        StringBuilder sb = new StringBuilder();

        if (params != null) {
            Set<String> keys = params.keySet();
            int first = 0;
            for (String key : keys) {
                Object value = params.get(key);
                if (first > 0) {
                    sb.append("&");
                }
                first++;
                sb.append(key);
                sb.append("=");
                String v = String.valueOf(value);
                try {
                    String encodeValue = URLEncoder.encode(v, DEFAULT_ENCODING);
                    sb.append(encodeValue);
                } catch (UnsupportedEncodingException e) {
                    myLog.error("", e);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 发送get请求--params是map
     *
     * @param url
     * @param headers
     * @param params
     * @return
     */
    public static HttpResponseMeta httpGet(String url, Map<String, String> headers, Map<String, Object> params, HttpGet get) throws Exception {

        setHeaders(get, headers);

        CloseableHttpClient client = ClientPool.getInstance(SocketTimeout.timeout_2_s);

        CloseableHttpResponse response = null;
        try {
            response = client.execute(get);
            return getResponse(url, response);
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }


    /**
     * 设置请求头
     *
     * @param request
     * @param headers
     */
    private static void setHeaders(HttpRequestBase request, Map<String, String> headers) {
        if (request != null && headers != null) {
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                String value = headers.get(key);
                request.setHeader(key, value);
            }
        }
    }

    /**
     * 将HttpResponse转换为HttpResponseMeta
     *
     * @param response
     * @return
     * @throws Exception
     */
    private static HttpResponseMeta getResponse(String url, HttpResponse response) throws Exception {

        if (response == null) {
            myLog.warn(("response is null"));
            throw new Exception("response is null");
        }
        StatusLine line = response.getStatusLine();
        if (line == null) {
            myLog.warn(("status is null"));
            throw new Exception("status is null");
        }
        HttpResponseMeta responseMeta = new HttpResponseMeta();
        responseMeta.setResponse(new byte[0]);
        int code = line.getStatusCode();
        responseMeta.setCode(code);
        myLog.info(("responseMeta status= " + responseMeta.getCode() + " url = " + url));
        if (code == 200) {
            InputStream inputStream = null;
            try {
                inputStream = response.getEntity().getContent();
                if (inputStream != null) {
                    byte[] bs = IOUtils.toByteArray(inputStream);
                    responseMeta.setResponse(bs);
                    Header contentType = response.getEntity().getContentType();
                    if (contentType != null) {
                        responseMeta.setContentType(contentType.getValue());
                        responseMeta.setEncode(getEncoding(contentType.getValue()));
                    }
                }
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }
        return responseMeta;
    }

    /**
     * 获取编码类型
     *
     * @param contentType
     * @return
     */
    private static String getEncoding(String contentType) {
        if (contentType != null) {
            String[] strs = contentType.split(";");
            if (strs != null && strs.length > 1) {
                String charSet = strs[1].trim();
                String[] charSetKeyValues = charSet.split("=");
                if (charSetKeyValues.length == 2 && charSetKeyValues[0].equalsIgnoreCase("charset")) {
                    return charSetKeyValues[1];
                }
            }
        }
        return DEFAULT_ENCODING;
    }

    /**
     * 发送post请求--params是map
     *
     * @param url
     * @param headers
     * @param params
     * @return
     * @throws Exception
     */
    public static HttpResponseMeta httpPost(String url, Map<String, String> headers, Map<String, Object> params, HttpPost post, SocketTimeout socketTimeout) throws Exception {

        setHeaders(post, headers);
        CloseableHttpClient client = ClientPool.getInstance(socketTimeout);
        CloseableHttpResponse response = null;
        try {
            if (params != null) {
                List<NameValuePair> list = new LinkedList<NameValuePair>();
                Set<String> keys = params.keySet();
                for (String key : keys) {
                    list.add(new BasicNameValuePair(key, String.valueOf(params.get(key))));
                }
                HttpEntity entity = new UrlEncodedFormEntity(list, getContentTypeCharset(headers));
                post.setEntity(entity);
            }
            response = client.execute(post);
            return getResponse(url, response);
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }

    /**
     * 获取Content-Type中指定的charset
     *
     * @param headers
     * @return Charset
     * <p>
     * header.put("Content-Type", "application/x-www-form-urlencoded;charset=gbk");
     */
    private static Charset getContentTypeCharset(Map<String, String> headers) {
        try {
            if (headers != null && headers.containsKey(HttpHeaders.CONTENT_TYPE)) {
                String contentTypeValue = headers.get(HttpHeaders.CONTENT_TYPE);
                if (StringUtils.isNotBlank(contentTypeValue)) {
                    List<NameValuePair> pairs = URLEncodedUtils.parse(contentTypeValue, Charset.defaultCharset());
                    if (pairs != null) {
                        for (NameValuePair pair : pairs) {
                            if (StringUtils.equalsIgnoreCase("charset", pair.getName())) {
                                return Charset.forName(pair.getValue());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            myLog.error("", e);
        }
        return Charset.defaultCharset();
    }

    /**
     * 发送post请求--params是string
     *
     * @param url
     * @param headers
     * @return
     * @throws Exception
     */
    public static HttpResponseMeta httpPost(String url, Map<String, String> headers, String body, HttpPost post, SocketTimeout socketTimeout) throws Exception {
        setHeaders(post, headers);
        CloseableHttpClient client = ClientPool.getInstance(socketTimeout);
        CloseableHttpResponse response = null;
        try {
            if (body != null) {
                StringEntity entity = new StringEntity(body);
                post.setEntity(entity);
            }
            response = client.execute(post);
            return getResponse(url, response);
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }
}
