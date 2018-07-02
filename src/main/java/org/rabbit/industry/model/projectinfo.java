package org.rabbit.industry.model;

import com.sun.corba.se.impl.util.PackagePrefixChecker;

import java.sql.Timestamp;

public class projectinfo {
    private String id;  //项目类型

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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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

    private String name;  //项目名称
    private Timestamp time;//创建时间
    private int status;//状态
    private String acId;//账户id



    public projectinfo(){}

    public projectinfo(String id, String name, Timestamp time, int status, String acId) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.status = status;
        this.acId = acId;
    }
}
