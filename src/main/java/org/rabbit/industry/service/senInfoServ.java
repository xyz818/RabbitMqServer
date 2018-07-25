package org.rabbit.industry.service;

public interface senInfoServ {
    String findSensorByDevice(String id);
    String findSensorById(String id);
    String findSensorByControl(String json);
    int addSensor(String json);
    boolean updateSensor(String json);
    boolean deleteSensor(String id);

    String findSensorByProject(int pid);

    /**
     * @param value 数值
     * @author　xuyongzhe
     * @brief 更新传感器信息数据值
     **/
    boolean updateSensorValue(String value,String id);
}
