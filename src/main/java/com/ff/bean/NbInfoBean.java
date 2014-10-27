
package com.ff.bean;

import java.sql.Timestamp;

/**
 * @ClassName: NbInfoBean 
 * @Description: 对应nb_info表
 * @author fengjiuchen 
 * @date 2014年10月27日 上午10:50:05 
 * @version 1.0
 */
public class NbInfoBean {

    private Long id;
    private String title;
    private String summary;
    private String content;
    private String snapContent;
    private String sourceUrl;
    private Timestamp snaptime;
    private String catalogTags;
    private String areaTags;
    private String mapGoogle;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getSnapContent() {
        return snapContent;
    }
    public void setSnapContent(String snapContent) {
        this.snapContent = snapContent;
    }
    public String getSourceUrl() {
        return sourceUrl;
    }
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
    public Timestamp getSnaptime() {
        return snaptime;
    }
    public void setSnaptime(Timestamp snaptime) {
        this.snaptime = snaptime;
    }
    public String getCatalogTags() {
        return catalogTags;
    }
    public void setCatalogTags(String catalogTags) {
        this.catalogTags = catalogTags;
    }
    public String getAreaTags() {
        return areaTags;
    }
    public void setAreaTags(String areaTags) {
        this.areaTags = areaTags;
    }
    public String getMapGoogle() {
        return mapGoogle;
    }
    public void setMapGoogle(String mapGoogle) {
        this.mapGoogle = mapGoogle;
    }
}

