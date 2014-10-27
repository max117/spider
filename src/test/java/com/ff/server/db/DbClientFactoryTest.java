
package com.ff.server.db;

import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ff.bean.Custom;

public class DbClientFactoryTest {

    @Test
    public void getTemplate(){
        
        JdbcTemplate jdbcTemplate = DbClientFactory.getTemplate();
        
        System.out.println(jdbcTemplate);
    }
    
    @Test
    public void findAllcustom(){
        
        CustomDao customDao = new CustomDao();
        List<Custom> customList = customDao.findAllcustom();
        
        customList.forEach(n->System.out.println(n.getCustom_name()));
    }
    
    @Test
    public void getCustomById(){
        
        CustomDao customDao = new CustomDao();
        Custom custom = customDao.getCustomById(1L);
        
        System.out.println(custom.getCustom_name());
    }
}

