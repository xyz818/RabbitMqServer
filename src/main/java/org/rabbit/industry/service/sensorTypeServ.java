package org.rabbit.industry.service;

public interface sensorTypeServ {
     String findSensorType();
     String findSensorTypeByControl(int control);
     int addSensorType(String json);
}
