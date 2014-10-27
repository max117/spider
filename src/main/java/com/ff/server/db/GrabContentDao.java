package com.ff.server.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ff.bean.GrabContentBean;

/**
 * @ClassName: GrabContentDao
 * @Description: 抓取数据处理
 * @author fengjiuchen
 * @date 2014年8月4日 下午2:19:14
 * @version 1.0
 */
public class GrabContentDao {

    JdbcTemplate jdbcTemplate = DbClientFactory.getTemplate();

    String sqlBathInsert = "INSERT INTO tb_service_grab (service_type,service_category,service_title,service_content, service_contact, service_price, service_area, service_tel, service_mail, service_address,service_map, service_language, service_update_time, updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     * @Title: addGrabContent 
     * @Description: 保存数据
     * @param grabContentList
     * @date 2014年8月11日 上午10:16:30 
     * @return Integer 
     * @throws
     */
    public Integer addGrabContent(List<GrabContentBean> grabContentList){
        
        Integer count = jdbcTemplate.batchUpdate(sqlBathInsert, new BatchPreparedStatementSetter() {
            
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, grabContentList.get(i).getService_type());
                ps.setString(2,grabContentList.get(i).getService_category());
                ps.setString(3,grabContentList.get(i).getService_title());
                ps.setString(4,grabContentList.get(i).getService_content());
                ps.setString(5,grabContentList.get(i).getService_contact());
                ps.setString(6,grabContentList.get(i).getService_price());
                ps.setString(7,grabContentList.get(i).getService_area());
                ps.setString(8,grabContentList.get(i).getService_tel());
                ps.setString(9,grabContentList.get(i).getService_mail());
                ps.setString(10,grabContentList.get(i).getService_address());
                ps.setString(11,grabContentList.get(i).getService_map());
                ps.setString(12,grabContentList.get(i).getService_language());
                ps.setString(13,grabContentList.get(i).getService_update_time());
                ps.setTimestamp(14, new Timestamp(System.currentTimeMillis()));
                }
            
            public int getBatchSize(){
                return grabContentList.size();
                }
            
            }).length;
        
        return count;
    }
}
