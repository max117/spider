
package com.ff.server.grab;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @ClassName: HttpClientFactory 
 * @Description: 客户端工厂类
 * @author fengjiuchen 
 * @date 2014年7月21日 下午3:07:56 
 * @version 1.0
 */
public class HttpClientFactory {

    public static CloseableHttpClient getCloseableHttpClient(){
        
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        
        return httpClient;
    }
}

