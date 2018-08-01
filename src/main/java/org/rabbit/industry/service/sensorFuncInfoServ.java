package org.rabbit.industry.service;

public interface sensorFuncInfoServ {
    boolean addSensorFuncInfo(String json);
    boolean delSensorFuncInfo(String json);
    boolean updateSensorFuncInfo(String json);
    String selectFuncCode(String sid,String stid,String fuid);
    String selectFuncBySid(String sid);
}
