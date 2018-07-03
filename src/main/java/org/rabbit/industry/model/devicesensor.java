package org.rabbit.industry.model;

public class devicesensor {

    private int ds_seq;//自增号
    private String di_id;//设备id
    private String sei_id;//传感器id
    private String ds_param;//保留字段

    public devicesensor() {
    }

    public devicesensor(int ds_seq, String di_id, String sei_id, String ds_param) {
        this.ds_seq = ds_seq;
        this.di_id = di_id;
        this.sei_id = sei_id;
        this.ds_param = ds_param;
    }

    public int getDs_seq() {
        return ds_seq;
    }

    public void setDs_seq(int ds_seq) {
        this.ds_seq = ds_seq;
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

    public String getDs_param() {
        return ds_param;
    }

    public void setDs_param(String ds_param) {
        this.ds_param = ds_param;
    }
}
