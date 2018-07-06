package org.rabbit.industry.model;

import com.sun.corba.se.impl.util.PackagePrefixChecker;

import java.sql.Timestamp;

public class projectinfo {
    private String pti_id;  //项目类型
    private int pi_seq;
    private String pi_name;  //项目名称
    private Timestamp pi_time;//创建时间
    private int pi_status;//状态
    private String aci_id;//账户id



    public projectinfo(){}



    public String getPti_id() {
        return pti_id;
    }

    public void setPti_id(String pti_id) {
        this.pti_id = pti_id;
    }

    public int getPi_seq() {
        return pi_seq;
    }

    public void setPi_seq(int pi_seq) {
        this.pi_seq = pi_seq;
    }

    public String getPi_name() {
        return pi_name;
    }

    public void setPi_name(String pi_name) {
        this.pi_name = pi_name;
    }

    public Timestamp getPi_time() {
        return pi_time;
    }

    public void setPi_time(Timestamp pi_time) {
        this.pi_time = pi_time;
    }

    public int getPi_status() {
        return pi_status;
    }

    public void setPi_status(int pi_status) {
        this.pi_status = pi_status;
    }

    public String getAci_id() {
        return aci_id;
    }

    public void setAci_id(String aci_id) {
        this.aci_id = aci_id;
    }


}
