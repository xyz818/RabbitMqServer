package org.rabbit.industry.service;

public interface senFuncServ {
    int addSFtype(String json);
    String selSensorFunc(String sid);
    String selSensorFuncByFid(String sid,String fid);
}
