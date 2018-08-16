package org.rabbit.industry.dao;

import org.rabbit.industry.model.funcinfo;

import java.util.List;

public interface funcInfoDao {
    /**
     * @Brief 查询所有的功能列表
     * @return 所有功能信息列表
     * */
    List<funcinfo> findFuncType();

    /**
     * @brief 添加功能信息
     * @param func 功能类
     * @return int　数据库更新返回行数
     *
     * */
    int addFuncType(funcinfo func);

    /**
     * @param value 数据值
     * @author　xuyongzhe
     * @brief  根据名称查询ｉｄ
     **/
    String  selFuncByName(String value);


    List<funcinfo> findFuncInfoByStid(String stid);


}
