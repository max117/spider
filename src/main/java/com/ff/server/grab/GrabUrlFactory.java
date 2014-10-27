
package com.ff.server.grab;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.ff.param.CommonParam;
import com.ff.utils.GrabPagingUtil;
import com.google.common.collect.Maps;

/**
 * @ClassName: GrabUrlFactory 
 * @Description: 抓取所有URL
 * @author fengjiuchen 
 * @date 2014年7月21日 下午2:58:47 
 * @version 1.0
 */
public class GrabUrlFactory {

    /**
     * @Title: findAllUrls 
     * @Description: 抓取某页面上的链接及标题
     * @param site
     * @date 2014年7月21日 下午5:07:18 
     * @return Map<String,String> 
     * @throws
     */
    public Map<String, String> findAllUrls(String site){
        
        CloseableHttpClient httpClient = HttpClientFactory.getCloseableHttpClient();
        HttpGet httpget = new HttpGet(site);
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(60000).setSocketTimeout(10000).build();
        httpget.setConfig(config);
        Map<String, String> urlMaps = Maps.newTreeMap();
        CloseableHttpResponse response;
        try {
            response = httpClient.execute(httpget, new BasicHttpContext());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 注意此处的编码，否则会出现乱码
                String html = EntityUtils.toString(entity, CommonParam.CHARSET_51CA);
                Document doc = Jsoup.parse(html);
                doc.select("div#foucsBox>ul>li>div>a").parallelStream().forEach(url->{urlMaps.put(url.attr("href"), url.text());});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return urlMaps;
    }
    
    /**
     * @Title: grab51caUrlsByCategory 
     * @Description: 抓取某个栏目下的页面Url
     * @param catUrl
     * @date 2014年8月1日 下午4:55:12 
     * @return TreeMap<String,Object> 
     * @throws
     */
    public TreeMap<String, Object> grab51caUrlsByCategory(String catUrl){
        
        CloseableHttpClient httpClient = HttpClientFactory.getCloseableHttpClient();
        TreeMap<String, Object> pageUrls = Maps.newTreeMap();
        
        // 1.分页处理
        List<String> catUrls=GrabPagingUtil.grab51caPageUrls(catUrl);
        
        catUrls.parallelStream().forEach(catPageUrl->{
            HttpGet httpget = new HttpGet(catPageUrl);
            RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(60000).setSocketTimeout(10000).build();
            httpget.setConfig(config);
            try {
                CloseableHttpResponse response = httpClient.execute(httpget, new BasicHttpContext());
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // 注意此处的编码，否则会出现乱码
                    String html = EntityUtils.toString(entity, CommonParam.CHARSET_51CA);
                    Document doc = Jsoup.parse(html);
                    // 2.抽取正文URL
                    Elements urlElements = doc.select("ol#ItemList>li>h3>a[href]");
                    for(int i=0; i<urlElements.size(); i++){
                        String url = CommonParam.PREFIX_51CA + urlElements.get(i).attr("href");
                        String language = doc.select("ol#ItemList>li>div.misc>div.contactname>i").get(i).text();
                        pageUrls.put(url, language);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        return pageUrls;
    }
}

