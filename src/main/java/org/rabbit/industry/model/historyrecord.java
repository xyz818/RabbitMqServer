package org.rabbit.industry.model;

import java.sql.Timestamp;

public class historyrecord {
    private int hr_seq;
    private String di_id;
    private String sei_id;
    private Timestamp hr_time;
    private String hr_value;
    private int pi_seq;
    private String hr_param;

    public historyrecord( String di_id, String sei_id, Timestamp hr_time, String hr_value) {
//        this.hr_seq = hr_seq;
        this.di_id = di_id;
        this.sei_id = sei_id;
        this.hr_time = hr_time;
        this.hr_value = hr_value;
//        this.pi_seq = pi_seq;
//        this.hr_param = hr_param;
    }

    public historyrecord() {
    }

    public int getHr_seq() {
        return hr_seq;
    }

    public void setHr_seq(int hr_seq) {
        this.hr_seq = hr_seq;
    }

    public String getDi_id() {
        return di_id;
    }

    public void setDi_id(String di_id) {
        this.di_id = di_id;
    }

    public String getSei_id() {
        return sei_id;
    }

    public void setSei_id(String sei_id) {
        this.sei_id = sei_id;
    }

    public Timestamp getHr_time() {
        return hr_time;
    }

    public void setHr_time(Timestamp hr_time) {
        this.hr_time = hr_time;
    }

    public String getHr_value() {
        return hr_value;
    }

    public void setHr_value(String hr_value) {
        this.hr_value = hr_value;
    }

    public int getPi_seq() {
        return pi_seq;
    }

    public void setPi_seq(int pi_seq) {
        this.pi_seq = pi_seq;
    }

    public String getHr_param() {
        return hr_param;
    }

    public void setHr_param(String hr_param) {
        this.hr_param = hr_param;
    }
}
