package org.rabbit.industry.service;

import org.rabbit.industry.model.deviceinfo;

import java.util.List;

public interface deviceInfoServ {
    /**
     * @brief
     * @param
     * **/
    String findDeivceByProject(int pid);

    /**
     * @param did
     * @author　xuyongzhe
     * @brief 根据设备id查询信息
     **/
    String findDeviceById(String did);

    /**
     * @param  json 设备信息
     * @author　xuyongzhe
     * @brief 添加用户信息
     **/
    boolean addDevice(String json);

    /**
     * @param  json 设备信息
     * @author　xuyongzhe
     * @brief　更新设备信息
     **/
    boolean updateDevice(String json);

    /**
     * @param did　设备id号
     * @author　xuyongzhe
     * @brief　删除设备信息
     **/
    boolean deleteDevice(String did);





}
