package org.rabbit.industry.model;

public class userinfo {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwsd() {
        return pwsd;
    }

    public void setPwsd(String pwsd) {
        this.pwsd = pwsd;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public userinfo()
    {

    }
    public userinfo(String id,String name,String pwsd,String ip)
    {
        this.id = id;
        this.name = name;
        this.pwsd = pwsd;
        this.ip = ip;
    }

    private String id;
    private String name;
    private String pwsd;
    private String ip;
}
