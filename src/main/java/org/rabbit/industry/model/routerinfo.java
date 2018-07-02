package org.rabbit.industry.model;

public class routerinfo {
    private String id; //网关id号
    private int status;//当前状态
    private String acId;//用户id
    private String scId;//学校id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAcId() {
        return acId;
    }

    public void setAcId(String acId) {
        this.acId = acId;
    }

    public String getScId() {
        return scId;
    }

    public void setScId(String scId) {
        this.scId = scId;
    }

    public routerinfo(){}
    public routerinfo(String id,String acId,String scId,int status)
    {
        this.id = id;
        this.acId = acId;
        this.scId = scId;
        this.status = status;

    }

}
