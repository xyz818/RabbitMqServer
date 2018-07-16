package org.rabbit.industry.model;
//传感器功能关联信息表sensorfunc
public class sensorfunc {
    private String sei_id;

    private String sti_id;//传感器类型id

    private String sti_name;
    private String fui_name;
    private String sf_imgurl;

    public String getSei_id() {
        return sei_id;
    }

    public void setSei_id(String sei_id) {
        this.sei_id = sei_id;
    }

    public String getSti_name() {
        return sti_name;
    }

    public void setSti_name(String sti_name) {
        this.sti_name = sti_name;
    }

    public String getFui_name() {
        return fui_name;
    }

    public void setFui_name(String fui_name) {
        this.fui_name = fui_name;
    }

    public String getSf_imgurl() {
        return sf_imgurl;
    }

    public void setSf_imgurl(String sf_imgurl) {
        this.sf_imgurl = sf_imgurl;
    }

    private String fui_id;//功能id

    public sensorfunc(){}






    public String getSti_id() {
        return sti_id;
    }

    public void setSti_id(String sti_id) {
        this.sti_id = sti_id;
    }

    public String getFui_id() {
        return fui_id;
    }

    public void setFui_id(String fui_id) {
        this.fui_id = fui_id;
    }


}
