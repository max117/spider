
package com.ff.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.ff.param.CommonParam;
import com.ff.server.grab.HttpClientFactory;

/**
 * @ClassName: GrabPagingUtil 
 * @Description: 抓取分页处理类
 * @author fengjiuchen 
 * @date 2014年8月1日 下午5:01:42 
 * @version 1.0
 */
public class GrabPagingUtil {

    public static List<String> grab51caPageUrls(String catUrl){
        
        CloseableHttpClient httpClient = HttpClientFactory.getCloseableHttpClient();
        HttpGet httpget = new HttpGet(catUrl);
        CloseableHttpResponse response;
        List<String> catUrls = new ArrayList<String>();
        
        try {
            response = httpClient.execute(httpget, new BasicHttpContext());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 注意此处的编码，否则会出现乱码
                String html = EntityUtils.toString(entity, CommonParam.CHARSET_51CA);
                Document doc = Jsoup.parse(html);
                // 判断是否有分页
                if(doc.select("div.itemListNav").select(".bottomNav>div.left").hasText()){
                    // 获取总条数，用于计算分页
                    Integer count = Integer.parseInt(doc.select("div#itemListLeft>div>div>b").last().text());
                    Float pageNum = 30.0F;
                    for(int i=1; i<=(int)Math.ceil(count/pageNum); i++){
                        catUrls.add(catUrl+"&perpage=30&pagenumber="+i);
                    }
                } else {
                    catUrls.add(catUrl);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return catUrls;
    }
}

