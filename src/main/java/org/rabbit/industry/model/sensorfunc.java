package org.rabbit.industry.model;
//传感器功能关联信息表sensorfunc
public class sensorfunc {
    private int sf_seq;//自增id
    private String sti_id;//传感器类型id
    private String fui_id;//功能id
    private String sf_param;//保留字段
    public sensorfunc(){}

    public sensorfunc(int sf_seq, String sti_id, String fui_id, String sf_param) {
        this.sf_seq = sf_seq;
        this.sti_id = sti_id;
        this.fui_id = fui_id;
        this.sf_param = sf_param;
    }


    public int getSf_seq() {
        return sf_seq;
    }

    public void setSf_seq(int sf_seq) {
        this.sf_seq = sf_seq;
    }

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

    public String getSf_param() {
        return sf_param;
    }

    public void setSf_param(String sf_param) {
        this.sf_param = sf_param;
    }
}
