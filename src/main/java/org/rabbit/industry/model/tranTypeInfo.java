package org.rabbit.industry.model;
//传输类型表trantypeinfo
public class tranTypeInfo {
    private String tti_id;//协议ｉｄ
    private String tti_name;//协议名称
    private String tti_param;

    public String getTti_param() {
        return tti_param;
    }

    public void setTti_param(String tti_param) {
        this.tti_param = tti_param;
    }

    public tranTypeInfo(){}

    public tranTypeInfo(String tti_id, String tti_name, String tti_param) {
        this.tti_id = tti_id;
        this.tti_name = tti_name;
        this.tti_param = tti_param;
    }

    public String getTti_id() {
        return tti_id;
    }

    public void setTti_id(String tti_id) {
        this.tti_id = tti_id;
    }

    public String getTti_name() {
        return tti_name;
    }

    public void setTti_name(String tti_name) {
        this.tti_name = tti_name;
    }
}
