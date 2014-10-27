
package com.ff.server.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.ff.utils.HtmlRegexpUtil;

public class HtmlRegexpUtilTest {

    @Test
    public void case1(){
        
        String str = "<p class=\"ecxMsoNormal\" style=\"color:#444444;font-family:Calibri, sans-serif;font-size:15px;background:white;\">    <span style=\"line-height:17.98666763305664px;font-size:9.5pt;\">Yellowstone National Park- Mt. Rushmore- Las Vegas-Grand Canyon West Rim 10/11 Days</span></p>";
        
        System.out.println(str.replaceAll("<(?!/?(?i)(p)).*?>",""));
    }
    
    @Test
    public void case2(){
        String str="<p style=\"font-size:1.3em;font-weight:bold\">No page with that title exists.</p> ";
        System.out.println(str.replaceAll("/<(?!img).*?>/ig",""));
    }
}

