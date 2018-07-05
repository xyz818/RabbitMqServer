package org.rabbit.industry.dao;

import org.rabbit.industry.model.devicesensor;
import org.rabbit.industry.model.sensorinfo;

import java.util.List;

public interface devSenDao{
    /**
     * @brief保存联动信息
     * @param dId  设备id号
     * @param sId 传感器id号
     *
     * */
    int saveDevSenor(String dId,String sId);

    /**
     * @brief 删除信息
     * @param sId 　传感器id号
     * */
    int delDevSenor(String sId);

    /**
     * @brief 查询传感与设备关联信息
     * */
    int selSeqByDevSenId(String did,String sId);

}
