package org.rabbit.industry.dao;

import org.rabbit.industry.model.sensorfunc;

import java.util.List;

public interface senFuncDao {
    /**
     * @brief 添加传感器功能关联信息
     * @param s 传感器关联类
     * @return 数据库返回的影响行数
     *
     * */
    int addSFtype(sensorfunc s);


    List<sensorfunc> selSensorFunc(String sid);


    sensorfunc selSensorFuncByFuncId(String sid,String fid);



}
