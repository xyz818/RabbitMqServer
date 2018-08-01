package org.rabbit.industry.model;

public class sensorfuncinfo {
    private int sfi_seq;  //自增
    private String sei_id;//传感器ｉｄ
    private String sf_seq;//功能id
    private String sfi_code;//功能码
    private String fui_id;
    private String fui_name;
    private String fui_param;

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

    public int getSfi_seq() {
        return sfi_seq;
    }

    public void setSfi_seq(int sfi_seq) {
        this.sfi_seq = sfi_seq;
    }

    public String getSei_id() {
        return sei_id;
    }

    public void setSei_id(String sei_id) {
        this.sei_id = sei_id;
    }

    public String getSf_seq() {
        return sf_seq;
    }

    public void setSf_seq(String sf_seq) {
        this.sf_seq = sf_seq;
    }

    public String getSfi_code() {
        return sfi_code;
    }

    public void setSfi_code(String sfi_code) {
        this.sfi_code = sfi_code;
    }

    public sensorfuncinfo() {
    }
}
