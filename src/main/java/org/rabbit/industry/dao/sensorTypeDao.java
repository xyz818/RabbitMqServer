package org.rabbit.industry.dao;

import org.rabbit.industry.model.sensorTypeInfo;

import java.util.List;

public interface sensorTypeDao {
     /**
     * @brief　查询所有传感器的类型列表
     * @return list列表
     * */
     List<sensorTypeInfo> findSensorType();
     /**
      * @brief　根据控制类型查询传感器
      * @param control 是否可控制
      * @return list 返回对应的传感器列表
      * */
     List<sensorTypeInfo> findSensorTypeByControl(int control);
     /**
      * @brief 添加传感器列表
      * @param sensorTypeInfo  传感器类型类
      * @return 数据库影响的行数
      *
      * */
     int addSensorType(sensorTypeInfo sensorTypeInfo);


     List<sensorTypeInfo> selSenTypeByTid(String tid);

}
