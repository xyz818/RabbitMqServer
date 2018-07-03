package org.rabbit.industry.model;

public class sensorinfo {
    private int sei_seq;
    private String sei_id;//节点id
    private String sti_id;//类型id
    private String tti_id;//传输id
    private String sei_value;//当前值
    private String sei_mac;//mac地址
    private String sti_name;//传感器名称

    public String getSti_name() {
        return sti_name;
    }

    public void setSti_name(String sti_name) {
        this.sti_name = sti_name;
    }

    public String getTti_name() {
        return tti_name;
    }

    public void setTti_name(String tti_name) {
        this.tti_name = tti_name;
    }

    private String tti_name;//传输类型
    private String sei_param;
    public sensorinfo() {
    }

    public sensorinfo(int sei_seq, String sei_id, String sti_id, String tti_id, String sei_value, String sei_mac, String sti_name, String tti_name, String sei_param) {
        this.sei_seq = sei_seq;
        this.sei_id = sei_id;
        this.sti_id = sti_id;
        this.tti_id = tti_id;
        this.sei_value = sei_value;
        this.sei_mac = sei_mac;
        this.sti_name = sti_name;
        this.tti_name = tti_name;
        this.sei_param = sei_param;
    }

    public int getSei_seq() {
        return sei_seq;
    }

    public void setSei_seq(int sei_seq) {
        this.sei_seq = sei_seq;
    }

    public String getSei_id() {
        return sei_id;
    }

    public void setSei_id(String sei_id) {
        this.sei_id = sei_id;
    }

    public String getSti_id() {
        return sti_id;
    }

    public void setSti_id(String sti_id) {
        this.sti_id = sti_id;
    }

    public String getTti_id() {
        return tti_id;
    }

    public void setTti_id(String tti_id) {
        this.tti_id = tti_id;
    }

    public String getSei_value() {
        return sei_value;
    }

    public void setSei_value(String sei_value) {
        this.sei_value = sei_value;
    }

    public String getSei_mac() {
        return sei_mac;
    }

    public void setSei_mac(String sei_mac) {
        this.sei_mac = sei_mac;
    }

    public String getSei_param() {
        return sei_param;
    }

    public void setSei_param(String sei_param) {
        this.sei_param = sei_param;
    }
}
