
package com.ff.temp;

import java.util.List;

public class DistrictCityBean {

    private String text;
    private String id;
    private List<DistrictBean> children;
    
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
    public List<DistrictBean> getChildren() {
        return children;
    }
    public void setChildren(List<DistrictBean> children) {
        this.children = children;
    }
}

