
package com.ff.server.grab;

import java.util.TreeMap;

import org.junit.Test;

public class GrabUrlFactoryTest {

    @Test
    public void findAllUrls(){
        
        GrabUrlFactory grabUrlFactory = new GrabUrlFactory();
        
        String site = "http://mil.huanqiu.com/";
        grabUrlFactory.findAllUrls(site).entrySet().forEach(kv->{System.out.println(kv.getKey()+"\t"+kv.getValue());});
    }
    
    @Test
    public void grabUrl (){
        
        GrabUrlFactory grabUrlFactory = new GrabUrlFactory();
        String catUrl = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=71";
        
        TreeMap<String, Object> pageUrlMap = grabUrlFactory.grab51caUrlsByCategory(catUrl);
        System.out.println(pageUrlMap.size());
    }
}

