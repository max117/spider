
package com.ff.server.utils;

import java.util.List;

import org.junit.Test;

import com.ff.utils.GrabPagingUtil;

public class GrabPagingUtilTest {

    GrabPagingUtil grabPagingUtil = new GrabPagingUtil();
    String catUrl1 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=31";
    String catUrl2 = "http://www.51.ca/service/servicedisplay.php?s=6abf7e013c86f6230af48f54c15c8006&serviceid=105";
    
    @Test
    public void grab51caPageUrls(){
        
        List<String> urlList = grabPagingUtil.grab51caPageUrls(catUrl2);
        
    }
}

