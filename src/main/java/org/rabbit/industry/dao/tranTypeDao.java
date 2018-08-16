package org.rabbit.industry.dao;

import org.rabbit.industry.model.tranTypeInfo;

import java.util.List;

public interface tranTypeDao {
    /**
     * @brief 查询所有的传输类型
     * @return  列表形式返回
     *
     * */
    List<tranTypeInfo> findTranType();


    /**
     * @brief 添加传输类型信息
     * @param t  传输信息类
     * @return  数据库影响的行数
     * */
    int addTranType(tranTypeInfo t);

    /**
     * @param
     * @author　xuyongzhe
     * @brief 根据传感器类型id查询传输类型
     **/
    List<tranTypeInfo> findTranTypeByStid(String stid);
}
