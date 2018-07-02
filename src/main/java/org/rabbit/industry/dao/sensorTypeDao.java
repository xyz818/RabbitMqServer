package org.rabbit.industry.dao;

import org.rabbit.industry.model.sensorTypeInfo;

import java.util.List;

public interface sensorTypeDao {
     List<sensorTypeInfo> findSensorType();
     List<sensorTypeInfo> findSensorTypeByControl(int control);
     int addSensorType(sensorTypeInfo sensorTypeInfo);
}
