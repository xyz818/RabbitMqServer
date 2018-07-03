package org.rabbit.industry.model;
//funcinfo表
public class funcinfo {
    private String fui_id;//功能ｉｄ
    private String fui_name;//功能名称
    private String fui_param;//保留字段


    public funcinfo(String fui_id, String fui_name, String fui_param) {
        this.fui_id = fui_id;
        this.fui_name = fui_name;
        this.fui_param = fui_param;
    }
    public funcinfo(){}
    public String getFui_id() {

        return fui_id;
    }

    public void setFui_id(String fui_id) {
        this.fui_id = fui_id;
    }

    public String getFui_name() {
        return fui_name;
    }

    public void setFui_name(String fui_name) {
        this.fui_name = fui_name;
    }

    public String getFui_param() {
        return fui_param;
    }

    public void setFui_param(String fui_param) {
        this.fui_param = fui_param;
    }
}
