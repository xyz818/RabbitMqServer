package org.rabbit.industry.service;

public interface senFuncServ {
    boolean addSFtype(String json);
    String selSensorFunc(String sid);
    String selSensorFuncByFid(String sid,String fid);
}
