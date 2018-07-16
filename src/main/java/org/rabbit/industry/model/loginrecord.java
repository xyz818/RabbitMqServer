package org.rabbit.industry.model;

import java.sql.Timestamp;

public class loginrecord {
    private  int lr_seq;    //自增Ｉｄ
    private String aci_id;  //用户id
    private String lr_time; //时间
    private String lr_ip;  //登录ip地址

    public loginrecord() {
    }


    public int getLr_seq() {
        return lr_seq;
    }

    public void setLr_seq(int lr_seq) {
        this.lr_seq = lr_seq;
    }

    public String getAci_id() {
        return aci_id;
    }

    public void setAci_id(String aci_id) {
        this.aci_id = aci_id;
    }

    public String getLr_time() {
        return lr_time;
    }

    public void setLr_time(String lr_time) {
        this.lr_time = lr_time;
    }

    public String getLr_ip() {
        return lr_ip;
    }

    public void setLr_ip(String lr_ip) {
        this.lr_ip = lr_ip;
    }
}
