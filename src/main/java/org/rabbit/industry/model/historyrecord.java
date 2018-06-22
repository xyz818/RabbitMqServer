package org.rabbit.industry.model;

import java.sql.Timestamp;

public class historyrecord {

    private String rid;
    private String sid;
    private Timestamp time;
    private int contype;
    private String value;
    private String voltage;
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getContype() {
        return contype;
    }

    public void setContype(int contype) {
        this.contype = contype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }




    public historyrecord( String rid, String sid, Timestamp time, int contype, String value, String voltage) {
//        this.id = id;
        this.rid = rid;
        this.sid = sid;
        this.time = time;
        this.contype = contype;
        this.value = value;
        this.voltage = voltage;
    }

    public historyrecord(){}



}
