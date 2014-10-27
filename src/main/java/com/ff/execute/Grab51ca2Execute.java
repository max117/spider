
package com.ff.execute;

import java.util.ArrayList;
import java.util.List;

import com.ff.bean.NbInfoBean;
import com.ff.server.db.NbInfoDao;
import com.ff.server.grab.GrabContentFactory;
import com.ff.server.grab.GrabUrlFactory;
import com.google.common.collect.Lists;

public class Grab51ca2Execute {

    public void grab51ca2SingleThread(){
        
      String service_type1 = "家庭旅馆";
      String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=e1fca39766bb1b33afbf4ef6c39c9ef2&serviceid=3";
      String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=e1fca39766bb1b33afbf4ef6c39c9ef2&serviceid=112";
      
//      String service_type1 = "接送服务";
//      String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=e1fca39766bb1b33afbf4ef6c39c9ef2&serviceid=2";
//      String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=e1fca39766bb1b33afbf4ef6c39c9ef2&serviceid=33";
//
//      String service_type1 = "旅游保险";
//      String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=e1fca39766bb1b33afbf4ef6c39c9ef2&serviceid=12";
//
//      String service_type1 = "地产中介";
//      String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=e1fca39766bb1b33afbf4ef6c39c9ef2&serviceid=15";
//      String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=e1fca39766bb1b33afbf4ef6c39c9ef2&serviceid=79";

      
      GrabUrlFactory grabUrlFactory = new GrabUrlFactory();
      GrabContentFactory grabContentFactory = new GrabContentFactory();
      List<NbInfoBean> nbInfoList = Lists.newArrayList();
      NbInfoDao nbInfoDao = new NbInfoDao();
      ArrayList<String> caturlList = Lists.newArrayList(
              service_caturl_1,
              service_caturl_2
              );
      
      // 将抓取到的数据转为Bean
      caturlList.parallelStream().forEach(catUrl->{
          grabUrlFactory.grab51caUrlsByCategory(catUrl).forEach((k,v)->{
              NbInfoBean nbInfo = grabContentFactory.get51Ca2Content(k);
              nbInfo.setCatalogTags(service_type1);
              nbInfoList.add(nbInfo);
              });
          });
      
      System.out.println("共抽取数据："+nbInfoList.size());
      Integer count = nbInfoDao.addNbInfo(nbInfoList);
      System.out.println("共插入数据："+count);
  }

  public static void main(String[] args){
      
      Long start = System.currentTimeMillis();
      new Grab51ca2Execute().grab51ca2SingleThread();
      System.out.println("共耗时："+(System.currentTimeMillis()-start));
      
  }
}

