
package com.ff.bean;

import java.util.Date;

public class Custom {

    private Long id;
    private String custom_name;
    private String custom_address;
    private String custom_tel;
    private Date create_date;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCustom_name() {
        return custom_name;
    }
    public void setCustom_name(String custom_name) {
        this.custom_name = custom_name;
    }
    public String getCustom_address() {
        return custom_address;
    }
    public void setCustom_address(String custom_address) {
        this.custom_address = custom_address;
    }
    public String getCustom_tel() {
        return custom_tel;
    }
    public void setCustom_tel(String custom_tel) {
        this.custom_tel = custom_tel;
    }
    public Date getCreate_date() {
        return create_date;
    }
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}

