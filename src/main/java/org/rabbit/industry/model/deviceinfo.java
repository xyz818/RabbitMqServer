package org.rabbit.industry.model;

public class deviceinfo {
    private String id; //设备id号
    private String mac;//设备ｍａｃ地址
    private String name;//设备名称
    private String key;//传输密钥
    private short type;//设备类型
    private short conType;//链接类型
    private short status;//当前状态

    public deviceinfo() {
    }

    public deviceinfo(String id, String mac, String name, String key, short type, short conType, short status) {
        this.id = id;
        this.mac = mac;
        this.name = name;
        this.key = key;
        this.type = type;
        this.conType = conType;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public short getConType() {
        return conType;
    }

    public void setConType(short conType) {
        this.conType = conType;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
