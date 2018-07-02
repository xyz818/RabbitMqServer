package org.rabbit.industry.model;

public class sensorinfo {
    private String id;//节点id
    private String tId;//类型id
    private String tranId;//传输id
    private String value;//当前值
    private String mac;//mac地址

    public sensorinfo() {
    }

    public sensorinfo(String id, String tId, String tranId, String value, String mac) {
        this.id = id;
        this.tId = tId;
        this.tranId = tranId;
        this.value = value;
        this.mac = mac;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
