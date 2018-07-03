package org.rabbit.industry.model;

public class deviceinfo {
    private int di_seq; //自增id
    private String di_id; //设备id号
    private String di_mac;//设备ｍａｃ地址
    private String di_name;//设备名称
    private String di_key;//传输密钥
    private short di_type;//设备类型
    private short di_conttype;//链接类型
    private short di_status;//当前状态
    private String di_param;
    public deviceinfo() {
    }

    public int getDi_seq() {
        return di_seq;
    }

    public void setDi_seq(int di_seq) {
        this.di_seq = di_seq;
    }

    public String getDi_id() {
        return di_id;
    }

    public void setDi_id(String di_id) {
        this.di_id = di_id;
    }

    public String getDi_mac() {
        return di_mac;
    }

    public void setDi_mac(String di_mac) {
        this.di_mac = di_mac;
    }

    public String getDi_name() {
        return di_name;
    }

    public void setDi_name(String di_name) {
        this.di_name = di_name;
    }

    public String getDi_key() {
        return di_key;
    }

    public void setDi_key(String di_key) {
        this.di_key = di_key;
    }

    public short getDi_type() {
        return di_type;
    }

    public void setDi_type(short di_type) {
        this.di_type = di_type;
    }

    public short getDi_conttype() {
        return di_conttype;
    }

    public void setDi_conttype(short di_conttype) {
        this.di_conttype = di_conttype;
    }

    public short getDi_status() {
        return di_status;
    }

    public void setDi_status(short di_status) {
        this.di_status = di_status;
    }

    public String getDi_param() {
        return di_param;
    }

    public void setDi_param(String di_param) {
        this.di_param = di_param;
    }

    public deviceinfo(int di_seq, String di_id, String di_mac, String di_name, String di_key, short di_type, short di_conttype, short di_status, String di_param) {
        this.di_seq = di_seq;
        this.di_id = di_id;
        this.di_mac = di_mac;
        this.di_name = di_name;
        this.di_key = di_key;
        this.di_type = di_type;
        this.di_conttype = di_conttype;
        this.di_status = di_status;
        this.di_param = di_param;
    }
}
