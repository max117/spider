
package com.ff.temp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.ff.server.db.DbClientFactory;

public class District2Json {
    
    // 查询所有省
    String sql="SELECT t.id, t.parent_id, t.admin_code, t.`name` FROM acl_district_region t WHERE t.parent_id=?";
    JdbcTemplate jdbcTemplate = DbClientFactory.getTemplate();

    @SuppressWarnings({ "unchecked" })
    public void createJson(){
        
        List<DistrictProvinceBean> districtProvinceList = new ArrayList<DistrictProvinceBean>();
        
        // 1.查询所有省
        List<District2> pList = jdbcTemplate.query(
                sql,
                new Object[]{1},
                new RowMapper() {
                    public District2 mapRow(ResultSet rs, int rowNum) throws SQLException {
                        District2 district = new District2();
                        district.setId(rs.getInt("id"));
                        district.setAdmin_code(rs.getString("admin_code"));
                        district.setName(rs.getString("name"));
                        return district;
                    }
                });
        
        for(District2 districtP : pList){
            DistrictProvinceBean districtProvince = new DistrictProvinceBean();
            districtProvince.setId(districtP.getAdmin_code());
            districtProvince.setText(districtP.getName());
            districtProvinceList.add(districtProvince);
            
            // 2.查询所有市
            Integer pid = districtP.getId();
            List<District2> cList = jdbcTemplate.query(
                    sql,
                    new Object[]{pid},
                    new RowMapper() {
                        public District2 mapRow(ResultSet rs, int rowNum) throws SQLException {
                            District2 district = new District2();
                            district.setId(rs.getInt("id"));
                            district.setAdmin_code(rs.getString("admin_code"));
                            district.setName(rs.getString("name"));
                            return district;
                        }
                    });
            
            // 3.查询所有区
            List<DistrictCityBean> districtCityList = new ArrayList<DistrictCityBean>();
            for(District2 districtC : cList){
                DistrictCityBean districtCity = new DistrictCityBean();
                districtCity.setId(districtC.getAdmin_code());
                districtCity.setText(districtC.getName());
                districtCityList.add(districtCity);
                
                Integer cid = districtC.getId();
                List<District2> dList = jdbcTemplate.query(
                        sql,
                        new Object[]{cid},
                        new RowMapper() {
                            public District2 mapRow(ResultSet rs, int rowNum) throws SQLException {
                                District2 district = new District2();
                                district.setId(rs.getInt("id"));
                                district.setAdmin_code(rs.getString("admin_code"));
                                district.setName(rs.getString("name"));
                                return district;
                            }
                        });
                List<DistrictBean> districtList = new ArrayList<DistrictBean>();
                for(District2 districtD : dList){
                    DistrictBean districtBean = new DistrictBean();
                    districtBean.setId(districtD.getAdmin_code());
                    districtBean.setText(districtD.getName());
                    districtList.add(districtBean);
                }
                districtCity.setChildren(districtList);
            }
            districtProvince.setChildren(districtCityList);
        }
        
        CitysBean citys = new CitysBean();
        citys.setCitys(districtProvinceList);
        
        try {
            String str = new ObjectMapper().writeValueAsString(citys);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new District2Json().createJson();
    }
}

