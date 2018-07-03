package org.rabbit.industry.dao;

import org.rabbit.industry.model.sensortrantype;

public interface senTranTypeDao {
    /**
     * @brief 添加传感器与传输类型关联列表
     * @param s  传感器关联类
     * @return 数据库影响的行数
     * */
    int addSTtype(sensortrantype s);
}
