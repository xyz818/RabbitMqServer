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


    /**
     * @brief 根据传感器id号查询对应的传感器信息
     * @param id  传感器id号
     * @return sensorinfo 传感器类
     * */
    sensorinfo findSensorById(String id);


    /**
     * @brief 根据设备id和是否可控制查询传感器
     * @param control 是否可控制
     * @param devId  设备id号
     * @return  相关传感器列表
     *
     * */
    List<sensorinfo> findSensorByControl(String devId,int control);

    /**
     * @brief 添加传感器
     * @param s  传感器类
     * @return 数据库影响的行数
     * */
    int addSensor(sensorinfo s);


    /**
     * @brief 更新传感器信息
     * @param s  传感器对象
     * @return 数据库影响的行数
     * */
    int updateSensor(sensorinfo s);

    /**
     * @brief 删除传感器
     * @param s  传感器类
     * @return 数据库影响的行数
     *
     * */
    int deleteSensor(String id);


    /**
     * @param pid 项目id号
     * @author　xuyongzhe
     * @brief 根据项目查询id
     **/
    List<sensorinfo> findSensorByProject(int pid);


}
