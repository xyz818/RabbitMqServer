package org.rabbit.industry.model;

public class projectdevice {

    private int pd_seq; //自增id
    private int pi_seq;//项目id
    private String di_id;//设备id
    private String pd_param;

    public projectdevice() {
    }

    public projectdevice(int pd_seq, int pi_seq, String di_id, String pd_param) {
        this.pd_seq = pd_seq;
        this.pi_seq = pi_seq;
        this.di_id = di_id;
        this.pd_param = pd_param;
    }

    public int getPd_seq() {
        return pd_seq;
    }

    public void setPd_seq(int pd_seq) {
        this.pd_seq = pd_seq;
    }

    public int getPi_seq() {
        return pi_seq;
    }

    public void setPi_seq(int pi_seq) {
        this.pi_seq = pi_seq;
    }

    public String getDi_id() {
        return di_id;
    }

    public void setDi_id(String di_id) {
        this.di_id = di_id;
    }

    public String getPd_param() {
        return pd_param;
    }

    public void setPd_param(String pd_param) {
        this.pd_param = pd_param;
    }
}
