package com.ff.server.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.ff.bean.Custom;

public class CustomDao {
    
    JdbcTemplate jdbcTemplate = DbClientFactory.getTemplate();
    String sql1 = "SELECT * FROM tb_custom LIMIT ?";
    String sql2 = "SELECT * FROM tb_custom t WHERE t.id= ?";

    /**
     * @Title: findAllcustom 
     * @Description: 查询所有用户
     * @date 2014年7月22日 上午11:36:31 
     * @return List<Custom> 
     * @throws
     */
    @SuppressWarnings("unchecked")
    public List<Custom> findAllcustom() {
        
        List<Custom> customList = jdbcTemplate.query(
                sql1, 
                new Object[]{10}, 
                new RowMapper() {
                    public Custom mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Custom custom = new Custom();
                        custom.setId(rs.getLong("id"));
                        custom.setCustom_name(rs.getString("custom_name"));
                        custom.setCustom_address(rs.getString("custom_address"));
                        custom.setCustom_tel(rs.getString("custom_tel"));
                        custom.setCreate_date(rs.getTimestamp("create_date"));
                        return custom;
                    }
                });
        
        return customList;
    }
    
    /**
     * @Title: getCustomById 
     * @Description: 根据ID查询用户
     * @param id
     * @date 2014年7月22日 上午11:36:51 
     * @return Custom 
     * @throws
     */
    public Custom getCustomById(Long id){
        
        Object custom = jdbcTemplate.queryForObject(sql2, new Object[]{id}, ParameterizedBeanPropertyRowMapper.newInstance(Custom.class));
        
        return (Custom)custom;
    }
}








