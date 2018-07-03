package org.rabbit.industry.dao;

import org.rabbit.industry.model.sensorinfo;

import java.util.List;

public interface sensorInfoDao {
    /**
     * @brief 根据设备号查询所有的传感器信息
     * @param id 设备号
     * @return 所有的传感器信息列表
     * */
    List<sensorinfo> findSensorByDevice(String id);
}
