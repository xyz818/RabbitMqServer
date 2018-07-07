package org.rabbit.industry.dao;

import org.rabbit.industry.model.deviceinfo;

import java.util.List;

public interface deviceInfoDao {
    /**
     * @brief
     * @param
     * **/
    List<deviceinfo> findDeivceByProject(int pid);

    /**
     * @param did
     * @author　xuyongzhe
     * @brief 根据设备id查询信息
     **/
    deviceinfo findDeviceById(String did);

    /**
     * @param　d 设备信息
     * @author　xuyongzhe
     * @brief 添加用户信息
     **/
    int addDevice(deviceinfo d);

    /**
     * @param d 设备信息
     * @author　xuyongzhe
     * @brief　更新设备信息
     **/
    int updateDevice(deviceinfo d);

    /**
     * @param did　设备id号
     * @author　xuyongzhe
     * @brief　删除设备信息
     **/
    int deleteDevice(String did);


}
