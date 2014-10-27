
package com.ff.temp;

import java.util.List;

public class DistrictProvinceBean {

    private String text;
    private String id;
    private List<DistrictCityBean> children;
    
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<DistrictCityBean> getChildren() {
        return children;
    }
    public void setChildren(List<DistrictCityBean> children) {
        this.children = children;
    }
}

