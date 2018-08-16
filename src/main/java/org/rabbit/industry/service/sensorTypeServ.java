package org.rabbit.industry.service;

public interface sensorTypeServ {
     String findSensorType();
     String findSensorTypeByControl(int control);
     int addSensorType(String json);
     String selSenTypeByTid(String tid,int control);
     String findSensorTypeById(String id);
}
