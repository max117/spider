package com.ff.server.grab;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.ff.bean.GrabContentBean;
import com.ff.bean.NbInfoBean;
import com.ff.param.CommonParam;
import com.ff.utils.HtmlRegexpUtil;

public class GrabContentFactory {
    
    Map<String, String> areaTagsMap = new HashMap<String, String>();
    
    /**
     * @Title: get51CaContent 
     * @Description: 抓取51ca网页内容
     * @param url
     * @param httpClient 
     * @date 2014年7月31日 下午5:35:34 
     * @return void 
     * @throws
     */
    public GrabContentBean get51CaContent(String url, HttpClient httpClient) {

        GrabContentBean grabContent51Ca = new GrabContentBean();
        
        try {
            HttpGet httpget = new HttpGet(url);
            RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(60000).setSocketTimeout(10000).build();
            httpget.setConfig(config);
            CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(httpget, new BasicHttpContext());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 注意此处的编码，否则会出现乱码
                String html = EntityUtils.toString(entity, CommonParam.CHARSET_51CA);
                Document doc = Jsoup.parse(html);
                // 抽取信息
                doc.select("table#PostBox>tbody>tr>td").parallelStream().forEach(element -> {
                    if(element.select("span").size() > 0){
                        String title = element.select("span").first().text();
                        element.select("span").first().remove();
                        switch (title){
                        case("【所属黄页】") : grabContent51Ca.setService_category(element.text()); break;
                        case("【更新时间】") : grabContent51Ca.setService_update_time(element.text()); break;
                        case("【服务价格】") : grabContent51Ca.setService_price(element.text()); break;
                        case("【联系人】") : grabContent51Ca.setService_contact(element.text()); break;
                        case("【联系电话】") : grabContent51Ca.setService_tel(null == grabContent51Ca.getService_tel() ? element.text() + ";" : grabContent51Ca.getService_tel() + element.text() + ";"); break;
                        case("【电子邮件】") : grabContent51Ca.setService_mail(element.select("a").attr("href").replaceFirst("mailto:", "")); break;
                        case("【其他电话】") : grabContent51Ca.setService_tel(null == grabContent51Ca.getService_tel() ? element.text() + ";" : grabContent51Ca.getService_tel() + element.text() + ";"); break;
                        case("【服务地区】") : grabContent51Ca.setService_area(element.text()); break;
                        case("【地图信息】") : grabContent51Ca.setService_map(element.select("a").attr("href")); break;
                        case("【具体位置】") : grabContent51Ca.setService_address(element.text()); break;
                        }
                    }
                });
                grabContent51Ca.setService_content(doc.select("div#FontPlus").select("p").removeAttr("class").removeAttr("style").outerHtml().replaceAll("<(?!/?(?i)(p)).*?>",""));
                grabContent51Ca.setService_title(doc.select("div#TitleBox").text());
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return grabContent51Ca;
    }
    
    
    public GrabContentBean get51CaContent(String url) {

        HttpClient httpClient = HttpClientFactory.getCloseableHttpClient();
        GrabContentBean grabContent51Ca = new GrabContentBean();
        
        try {
            HttpGet httpget = new HttpGet(url);
            RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(60000).setSocketTimeout(10000).build();
            httpget.setConfig(config);
            CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(httpget, new BasicHttpContext());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 注意此处的编码，否则会出现乱码
                String html = EntityUtils.toString(entity, CommonParam.CHARSET_51CA);
                Document doc = Jsoup.parse(html);
                // 抽取信息
                doc.select("table#PostBox>tbody>tr>td").parallelStream().forEach(element -> {
                    if(element.select("span").size() > 0){
                        String title = element.select("span").first().text();
                        element.select("span").first().remove();
                        switch (title){
                        case("【所属黄页】") : grabContent51Ca.setService_category(element.text()); break;
                        case("【更新时间】") : grabContent51Ca.setService_update_time(element.text()); break;
                        case("【服务价格】") : grabContent51Ca.setService_price(element.text()); break;
                        case("【联系人】") : grabContent51Ca.setService_contact(element.text()); break;
                        case("【联系电话】") : grabContent51Ca.setService_tel(null == grabContent51Ca.getService_tel() ? element.text() + ";" : grabContent51Ca.getService_tel() + element.text() + ";"); break;
                        case("【电子邮件】") : grabContent51Ca.setService_mail(element.select("a").attr("href").replaceFirst("mailto:", "")); break;
                        case("【其他电话】") : grabContent51Ca.setService_tel(null == grabContent51Ca.getService_tel() ? element.text() + ";" : grabContent51Ca.getService_tel() + element.text() + ";"); break;
                        case("【服务地区】") : grabContent51Ca.setService_area(element.text()); break;
                        case("【地图信息】") : grabContent51Ca.setService_map(element.select("a").attr("href")); break;
                        case("【具体位置】") : grabContent51Ca.setService_address(element.text()); break;
                        }
                    }
                });
                grabContent51Ca.setService_content(doc.select("div#FontPlus").select("p").removeAttr("class").removeAttr("style").outerHtml().replaceAll("<(?!/?(?i)(p)).*?>",""));
                grabContent51Ca.setService_title(doc.select("div#TitleBox").text());
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return grabContent51Ca;
    }
    
    /**
     * @Title: get51Ca2Content 
     * @Description: 对应nb_info表新的结构
     * @param url
     * @date 2014年10月27日 下午2:16:02 
     * @return NbInfoBean 
     * @throws
     */
    public NbInfoBean get51Ca2Content(String url) {

        initAreaTags();
        HttpClient httpClient = HttpClientFactory.getCloseableHttpClient();
        NbInfoBean nbInfo = new NbInfoBean();
        
        try {
            HttpGet httpget = new HttpGet(url);
            RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(60000).setSocketTimeout(10000).build();
            httpget.setConfig(config);
            CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(httpget, new BasicHttpContext());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 注意此处的编码，否则会出现乱码
                String html = EntityUtils.toString(entity, CommonParam.CHARSET_51CA);
                Document doc = Jsoup.parse(html);
                // 抽取信息
                doc.select("table#PostBox>tbody>tr>td").parallelStream().forEach(element -> {
                    if(element.select("span").size() > 0){
                        String title = element.select("span").first().text();
                        element.select("span").first().remove();
                        switch (title){
                        case("【服务地区】") : nbInfo.setAreaTags(element.text()); break;
                        case("【地图信息】") : nbInfo.setMapGoogle(element.select("a").attr("href")); break;
                        }
                    }
                });
                
                nbInfo.setTitle(doc.select("div#TitleBox").text());
                // 判断地址标签
                if(null != nbInfo.getAreaTags() && nbInfo.getAreaTags().trim().length()>0){
                    // http://maps.google.com/maps?f=q&geocode=&q=M1P+5J4&output=js
                    if(!areaTagsMap.containsKey(nbInfo.getAreaTags())){
                        nbInfo.setAreaTags("1");
                    }
                }
                nbInfo.setSourceUrl(url);
//                // 过滤所有html标签
//                nbInfo.setContent(HtmlRegexpUtil.filterHtml(doc.select("div#FontPlus").html()));
                // 保留P标签
                String content = doc.select("div#FontPlus").select("p").removeAttr("class").removeAttr("style").outerHtml().replaceAll("<(?!/?(?i)(p)).*?>","");
                nbInfo.setContent(content);
                nbInfo.setSummary(HtmlRegexpUtil.filterHtml(content).length()>200?HtmlRegexpUtil.filterHtml(content).substring(0,200):HtmlRegexpUtil.filterHtml(content).substring(0,HtmlRegexpUtil.filterHtml(content).length()));

                nbInfo.setSnapContent(doc.select("div#FontPlus").html());
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nbInfo;
    }
    
    /**
     * @Title: initAreaTags 
     * @Description: 初始化地区标签
     * @date 2014年10月28日 下午7:32:27 
     * @return void 
     * @throws
     */
    public void initAreaTags(){
        
        areaTagsMap.put("多伦多", "Toronto city");
        areaTagsMap.put("马克汉姆", "Markham");
        areaTagsMap.put("旺市", "Vaughan");
        areaTagsMap.put("列治文山", "Richmond hill");
        areaTagsMap.put("密西沙加", "Mississauga");
        areaTagsMap.put("皮克林", "Pickering");
        areaTagsMap.put("汉密尔顿", "Hamilton");
        areaTagsMap.put("尼亚加拉", "Niagara");
        areaTagsMap.put("北约克", "North York");
        areaTagsMap.put("士嘉堡", "Scarborough");
        areaTagsMap.put("东约克", "East York");
        areaTagsMap.put("约克", "York");
        areaTagsMap.put("怡陶碧谷", "Etobicoke");
        areaTagsMap.put("汤山", "Thornhill");
    }
}
