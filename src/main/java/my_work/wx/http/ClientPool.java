package my_work.wx.http;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

public class ClientPool {

    public static final Logger myLog = LoggerFactory.getLogger(ClientPool.class);

    /**
     * 根据http https 超时时间，给出具体的线程池创建对象,默认2s超时时间
     *
     * @param time
     * @return
     */
    public static CloseableHttpClient getInstance(SocketTimeout time) {
        if (time == null) {
            time = SocketTimeout.timeout_2_s;
        }
        return httpClients[time.value()];
    }

    private static int MAX_TOTAL = 5000;
    private static int MAX_PER_ROUTE = 5000;
    public static int CONNECTION_REQUEST_TIMEOUT_TIME = 2000; // 超时时间500ms
    public static int CONNECTION_TIMEOUT_TIME = 2000; // 超时时间2000ms
    public static int SOCKET_TIMEOUT_TIME_5000ms = SocketTimeout.timeout_5_s.value() * 1000; // 超时时间5000ms
    public static int SOCKET_TIMEOUT_TIME_2000ms = SocketTimeout.timeout_2_s.value() * 1000; // 超时时间2000ms

    private static CloseableHttpClient httpClient_2000ms;
    private static CloseableHttpClient httpClient_5000ms;

    private static CloseableHttpClient httpClients[] = new CloseableHttpClient[6];

    private static PoolingHttpClientConnectionManager connectionManager_2000ms;
    private static PoolingHttpClientConnectionManager connectionManager_5000ms;

    // 初始化5000ms
    static {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            LayeredConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext,
                    new NoopHostnameVerifier());

            connectionManager_5000ms = new PoolingHttpClientConnectionManager(
                    RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("http", PlainConnectionSocketFactory.getSocketFactory())
                            .register("https", sslSocketFactory).build());
            connectionManager_5000ms.setMaxTotal(MAX_TOTAL);
            connectionManager_5000ms.setDefaultMaxPerRoute(MAX_PER_ROUTE);

            RequestConfig requestConfig_5000ms = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                    .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT_TIME)
                    .setSocketTimeout(SOCKET_TIMEOUT_TIME_5000ms).setConnectTimeout(CONNECTION_TIMEOUT_TIME).build();

            HttpClientBuilder clientBuilder_5000ms = HttpClients.custom().setConnectionManager(connectionManager_5000ms)
                    .setKeepAliveStrategy(new MyConnectionKeepAliveStragtegy())
                    .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                    .setDefaultRequestConfig(requestConfig_5000ms).disableCookieManagement();

            httpClient_5000ms = clientBuilder_5000ms.build();
            httpClients[5] = httpClient_5000ms;
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            myLog.error("", e);
            System.exit(-1);
        }

        // close expired and idle connection thread
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        // close expired Connections
                        connectionManager_5000ms.closeExpiredConnections();
                        // close Connections that have been idle for 30 sec
                        connectionManager_5000ms.closeIdleConnections(30, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        myLog.error("", e);
                    }
                }
            }
        }.start();
    }

    // 初始化2000ms
    static {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            LayeredConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext,
                    new NoopHostnameVerifier());

            connectionManager_2000ms = new PoolingHttpClientConnectionManager(
                    RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("http", PlainConnectionSocketFactory.getSocketFactory())
                            .register("https", sslSocketFactory).build());
            connectionManager_2000ms.setMaxTotal(MAX_TOTAL);
            connectionManager_2000ms.setDefaultMaxPerRoute(MAX_PER_ROUTE);

            // 这里需要确认是否可以共用一个connectionManager 一期先
            RequestConfig requestConfig_2000ms = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                    .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT_TIME)
                    .setSocketTimeout(SOCKET_TIMEOUT_TIME_2000ms).setConnectTimeout(CONNECTION_TIMEOUT_TIME).build();
            HttpClientBuilder clientBuilder_2000ms = HttpClients.custom().setConnectionManager(connectionManager_2000ms)
                    .setKeepAliveStrategy(new MyConnectionKeepAliveStragtegy())
                    .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                    .setDefaultRequestConfig(requestConfig_2000ms).disableCookieManagement();
            httpClient_2000ms = clientBuilder_2000ms.build();
            httpClients[2] = httpClient_2000ms;
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            myLog.error("", e);
            System.exit(-1);
        }

        // close expired and idle connection thread
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        // close expired Connections
                        connectionManager_2000ms.closeExpiredConnections();
                        // close Connections that have been idle for 30 sec
                        connectionManager_2000ms.closeIdleConnections(30, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        myLog.error("", e);
                    }
                }
            }

            ;
        }.start();
    }

    private static class MyConnectionKeepAliveStragtegy implements ConnectionKeepAliveStrategy {
        @Override
        public long getKeepAliveDuration(HttpResponse response, HttpContext paramHttpContext) {
            final HeaderElementIterator it = new BasicHeaderElementIterator(
                    response.headerIterator(HTTP.CONN_KEEP_ALIVE));
            while (it.hasNext()) {
                final HeaderElement he = it.nextElement();
                final String param = he.getName();
                final String value = he.getValue();
                if (value != null && param.equalsIgnoreCase("timeout")) {
                    try {
                        return Long.parseLong(value) * 1000;
                    } catch (final NumberFormatException ignore) {
                    }
                }
            }
            // default connection keep alive time
            return 30 * 1000;
        }
    }

}
