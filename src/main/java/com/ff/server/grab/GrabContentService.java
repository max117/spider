package com.ff.server.grab;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;

import com.ff.bean.GrabContentBean;

/**
 * @ClassName: GrabContentService
 * @Description: 抽取内容
 * @author fengjiuchen
 * @date 2014年7月23日 上午10:48:23
 * @version 1.0
 */
public class GrabContentService {

    CloseableHttpClient httpClient = HttpClientFactory.getCloseableHttpClient();

    /**
     * @Title: grabExecution 
     * @Description: 多线程抓取
     * @param urlList   ：提取列表
     * @param threadNum ：线程数
     * @date 2014年7月30日 下午2:13:21 
     * @return void 
     * @throws
     */
    public List<GrabContentBean> grabExecution(List<String> urlList, Integer threadNum) {

        List<GetThread> threads = new ArrayList<GetThread>();
        Integer page = urlList.size() / threadNum;
        for (int i = 0; i < threadNum; i++) {
            Integer start = page * i;
            Integer end = (i + 1) * page > urlList.size() ? urlList.size() : (i + 1) * page;
            if(start > end) break;
            
            threads.add(new GetThread(httpClient, urlList.subList(start, end)));
        }

        threads.forEach(thread -> thread.start());
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        return GetThread.grabContentList;
    }

    /**
     * @ClassName: GetThread 
     * @Description: 抓取线程执行类
     * @author fengjiuchen 
     * @date 2014年7月30日 下午2:16:48 
     * @version 1.0
     */
    static class GetThread extends Thread {

        private final CloseableHttpClient httpClient;
        private final List<String> execList;
        public static List<GrabContentBean> grabContentList = new ArrayList<GrabContentBean>();

        public GetThread(CloseableHttpClient httpClient, List<String> execList) {
            this.httpClient = httpClient;
            this.execList = execList;
        }

        public void run() {
            execList.parallelStream().forEach(url -> {
                GrabContentBean grabContent = new GrabContentFactory().get51CaContent(url, httpClient);
                grabContentList.add(grabContent);
        });
        }
    }
}
