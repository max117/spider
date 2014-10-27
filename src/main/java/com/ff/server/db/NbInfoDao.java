
package com.ff.server.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ff.bean.NbInfoBean;

public class NbInfoDao {

    JdbcTemplate jdbcTemplate = DbClientFactory.getTemplate();

    String sqlBathInsert = "INSERT INTO nb_info (Title, Summary, Content, SnapContent, SourceUrl, Snaptime, CatalogTags, AreaTags, MapGoogle) VALUES (?,?,?,?,?,NOW(),?,?,?)";

    public Integer addNbInfo(List<NbInfoBean> nbInfoList){
        
        Integer count = jdbcTemplate.batchUpdate(sqlBathInsert, new BatchPreparedStatementSetter() {
            
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, nbInfoList.get(i).getTitle());
                ps.setString(2,nbInfoList.get(i).getSummary());
                ps.setString(3,nbInfoList.get(i).getContent());
                ps.setString(4,nbInfoList.get(i).getSnapContent());
                ps.setString(5,nbInfoList.get(i).getSourceUrl());
                ps.setString(6,nbInfoList.get(i).getCatalogTags());
                ps.setString(7,nbInfoList.get(i).getAreaTags());
                ps.setString(8,nbInfoList.get(i).getMapGoogle());
                }
            
            public int getBatchSize(){
                return nbInfoList.size();
                }
            
            }).length;
        
        return count;
    }
}

