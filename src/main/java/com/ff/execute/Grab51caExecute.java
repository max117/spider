
package com.ff.execute;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ff.bean.GrabContentBean;
import com.ff.server.db.GrabContentDao;
import com.ff.server.grab.GrabContentFactory;
import com.ff.server.grab.GrabContentService;
import com.ff.server.grab.GrabUrlFactory;
import com.google.common.collect.Lists;

public class Grab51caExecute {
    
    public void grab51caSingleThread(){
        
//        String service_type = "免费公益";
//        String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=71";
//        String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=31";
//        String service_caturl_3 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=105";
//        String service_caturl_4 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=69";
//        String service_caturl_5 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=116";
//        String service_caturl_6 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=21";

//        String service_type = "生活服务";
//        String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=77";
//        String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=3";
//        String service_caturl_3 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=12";
//        String service_caturl_4 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=5";
//        String service_caturl_5 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=101";
//        String service_caturl_6 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=65";
//        String service_caturl_7 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=141";
//        String service_caturl_8 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=85";
//        String service_caturl_9 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=60";
//        String service_caturl_10 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=119";
//        String service_caturl_11 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=125";
//        String service_caturl_12 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=145";
//        String service_caturl_13 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=140";
//        String service_caturl_14 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=63";
        
//        String service_type = "搬运接送";
//        String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=2";
//        String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=37";
//        String service_caturl_3 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=33";
        
//        String service_type = "教育培训";
//        String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=6";
//        String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=121";
//        String service_caturl_3 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=114";
//        String service_caturl_4 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=137";
//        String service_caturl_5 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=115";
//        String service_caturl_6 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=36";
//        String service_caturl_7 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=128";
//        String service_caturl_8 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=138";
        
//        String service_type = "汽车相关";
//        String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=27";
//        String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=34";
//        String service_caturl_3 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=26";
//        String service_caturl_4 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=96";
//        String service_caturl_5 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=97";
//        String service_caturl_6 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=39";
//        String service_caturl_7 = "http://www.51.ca/service/servicedisplay.php?s=7072d0036dd5ab325d11452c730ad1f9&serviceid=133";
        
//        String service_type = "房屋相关";
//        String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=15";
//        String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=66";
//        String service_caturl_3 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=41";
//        String service_caturl_4 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=123";
//        String service_caturl_5 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=122";
//        String service_caturl_6 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=13";
//        String service_caturl_7 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=62";
//        String service_caturl_8 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=15";
//        String service_caturl_9 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=135";
//        String service_caturl_10 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=131";
//        String service_caturl_11 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=117";
//        String service_caturl_12 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=113";
//        String service_caturl_13 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=147";
//        String service_caturl_14 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=144";
//        String service_caturl_15 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=107";
//        String service_caturl_16 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=136";
//        String service_caturl_17 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=143";
//        String service_caturl_18 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=108";
//        String service_caturl_19 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=142";
//        String service_caturl_20 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=16";
//        String service_caturl_21 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=118";
//        String service_caturl_22 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=124";
//        String service_caturl_23 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=111";
//        String service_caturl_24 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=59";
//        String service_caturl_25 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=146";
//        String service_caturl_26 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=109";
//        String service_caturl_27 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=83";
//        String service_caturl_28 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=56";
//        String service_caturl_29 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=75";
//        String service_caturl_30 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=112";
//        String service_caturl_31 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=132";
        
//        String service_type = "财会法律";
//        String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=9";
//        String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=98";
//        String service_caturl_3 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=50";
//        String service_caturl_4 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=74";
//        String service_caturl_5 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=8";
//        String service_caturl_6 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=90";
//        String service_caturl_7 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=24";
//        String service_caturl_8 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=11";
//        String service_caturl_9 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=130";
        
//        String service_type = "医疗保健";
//        String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=10";
//        String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=38";
//        String service_caturl_3 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=106";
//        String service_caturl_4 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=91";
//        String service_caturl_5 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=126";
//        String service_caturl_6 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=100";
//        String service_caturl_7 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=30";
//        String service_caturl_8 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=99";
//        String service_caturl_9 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=104";
        
//        String service_type = "网络电脑";
//        String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=22";
//        String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=89";
//        String service_caturl_3 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=70";
//        String service_caturl_4 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=58";
//        String service_caturl_5 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=67";
//        String service_caturl_6 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=127";
        
        String service_type = "生意服务";
        String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=18";
        String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=79";
        String service_caturl_3 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=80";
        String service_caturl_4 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=78";
        String service_caturl_5 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=76";
        String service_caturl_6 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=81";
        String service_caturl_7 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=110";
        String service_caturl_8 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=129";
        String service_caturl_9 = "http://www.51.ca/service/servicedisplay.php?s=0ad13af9da2c63c11fcdf7372125a7c4&serviceid=139";
        
        GrabUrlFactory grabUrlFactory = new GrabUrlFactory();
        GrabContentFactory grabContentFactory = new GrabContentFactory();
        List<GrabContentBean> grabContentList = Lists.newArrayList();
        GrabContentDao grabContentDao = new GrabContentDao();
        ArrayList<String> caturlList = Lists.newArrayList(
                service_caturl_1,
                service_caturl_2,
                service_caturl_3,
                service_caturl_4,
                service_caturl_5,
                service_caturl_6,
                service_caturl_7,
                service_caturl_8,
                service_caturl_9
                );
        
        // 将抓取到的数据转为Bean
        caturlList.parallelStream().forEach(catUrl->{
            grabUrlFactory.grab51caUrlsByCategory(catUrl).forEach((k,v)->{
                GrabContentBean grabContent = grabContentFactory.get51CaContent(k);
                grabContent.setService_language(v.toString());
                grabContent.setService_type(service_type);
                grabContent.setUpdated_time(new Date());
                grabContentList.add(grabContent);
                });
            });
        
        System.out.println("共抽取数据："+grabContentList.size());
        Integer count = grabContentDao.addGrabContent(grabContentList);
        System.out.println("共插入数据："+count);
    }
    
    
    
    public void grab51caMultiThread(){
        
//        String service_type = "免费公益";
        String service_caturl_1 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=71";
        String service_caturl_2 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=31";
        String service_caturl_3 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=105";
        String service_caturl_4 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=69";
        String service_caturl_5 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=116";
        String service_caturl_6 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=21";

        GrabUrlFactory grabUrlFactory = new GrabUrlFactory();
        GrabContentDao grabContentDao = new GrabContentDao();
        ArrayList<String> caturlList = Lists.newArrayList(service_caturl_1,service_caturl_2,service_caturl_3,service_caturl_4,service_caturl_5,service_caturl_6);
        
        ArrayList<String> contenturlList = Lists.newArrayList();
        
        // 将抓取到的数据转为Bean
        caturlList.parallelStream().forEach(catUrl->{
            grabUrlFactory.grab51caUrlsByCategory(catUrl).forEach((k,v)->{
                contenturlList.add(k);
                });
            });
        
        GrabContentService grabContentService = new GrabContentService();
        
        List<GrabContentBean> list = grabContentService.grabExecution(contenturlList, 10);
        
        System.out.println("共抽取数据："+list.size());
        Integer count = grabContentDao.addGrabContent(list);
        System.out.println("共插入数据："+count);
    }

    public static void main(String[] args){
        
        Long start = System.currentTimeMillis();
        new Grab51caExecute().grab51caSingleThread();
        System.out.println("共耗时："+(System.currentTimeMillis()-start));
        
    }
}

