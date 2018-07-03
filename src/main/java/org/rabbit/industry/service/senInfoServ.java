package org.rabbit.industry.service;

public interface senInfoServ {
    String findSensorByDevice(String id);
    String findSensorById(String id);
    String findSensorByControl(String json);
    int addSensor(String json);
    boolean updateSensor(String json);
    boolean deleteSensor(String id);
}
