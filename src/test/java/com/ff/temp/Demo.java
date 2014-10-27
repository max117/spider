
package com.ff.temp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Demo {

    @Test
    public void case1(){
        
        Float threadNum = 2.0F;
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        
        Integer page = (int) Math.ceil(list.size()/threadNum);
        for(int i=0; i<threadNum; i++){
            
            Integer start = page*i;
            Integer end = (i+1)*page>list.size()?list.size():(i+1)*page;
            
            if(start>end) break;
            
            List<String> subList = list.subList(start, end);
            subList.forEach(System.out::println);
        }

    }
    
    @Test
    public void case2(){
        
        Integer count = 195;
        Float page = 5.0F;
        
        System.out.println((int) Math.ceil(count/page));
        
//        for(int i=0;)
    }
}

