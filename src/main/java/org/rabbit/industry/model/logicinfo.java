package org.rabbit.industry.model;

public class logicinfo {
    private String li_id;
    private String li_name;

    public logicinfo() {
    }

    public String getLi_id() {
        return li_id;
    }

    public void setLi_id(String li_id) {
        this.li_id = li_id;
    }

    public String getLi_name() {
        return li_name;
    }

    public void setLi_name(String li_name) {
        this.li_name = li_name;
    }

    public int getLi_status() {
        return li_status;
    }

    public void setLi_status(int li_status) {
        this.li_status = li_status;
    }

    private int li_status;

    private int pi_seq;

    public String getPi_name() {
        return pi_name;
    }

    public void setPi_name(String pi_name) {
        this.pi_name = pi_name;
    }

    private String pi_name;

    public int getPi_seq() {
        return pi_seq;
    }

    public void setPi_seq(int pi_seq) {
        this.pi_seq = pi_seq;
    }
}
