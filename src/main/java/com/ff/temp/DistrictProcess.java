
package com.ff.temp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ff.server.db.DbClientFactory;

public class DistrictProcess {

    JdbcTemplate jdbcTemplate = DbClientFactory.getTemplate();
    String sql1 = "SELECT id,guid,parent_guid FROM acl_district_region_temp";
    String sql2 = "UPDATE acl_district_region_temp SET guid=id, parent_guid=? WHERE parent_guid=?";
    
    @SuppressWarnings("unchecked")
    public void formate(){
        List<District> customList = jdbcTemplate.query(
                sql1,
                new RowMapper() {
                    public District mapRow(ResultSet rs, int rowNum) throws SQLException {
                        District district = new District();
                        district.setId(rs.getInt("id"));
                        district.setGuid(rs.getString("guid"));
                        district.setParent_guid(rs.getString("parent_guid"));
                        return district;
                    }
                });
        
        for(District district : customList){
            
            Integer id = district.getId();
            String guid = district.getGuid();
            
            jdbcTemplate.update(sql2, new Object[]{id, guid});
        }
    }
    
    public static void main(String[] args){
        new DistrictProcess().formate();
    }
}

