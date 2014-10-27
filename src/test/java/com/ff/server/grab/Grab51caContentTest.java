
package com.ff.server.grab;

import org.apache.http.client.HttpClient;
import org.junit.Test;

public class Grab51caContentTest {

    GrabContentFactory grabContentFactory = new GrabContentFactory();
    
    @Test
    public void case1(){
        
        String url = "http://www.51.ca/service/showitem.php?s=af8a2fbe913d1ba240e7f00243ea943a&itemid=59346";
        HttpClient httpClient = HttpClientFactory.getCloseableHttpClient();
        
        grabContentFactory.get51CaContent(url, httpClient);
    }
}

