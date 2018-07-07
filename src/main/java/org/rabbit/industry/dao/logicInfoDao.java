package org.rabbit.industry.dao;

import org.rabbit.industry.model.logicinfo;

import java.util.List;

public interface logicInfoDao {
    /**
     * @param pid 项目id
     * @author　xuyongzhe
     * @brief 根据项目查询策略信息
     **/
    List<logicinfo> findLogicByProject(int pid);

    /**
     * @param id 逻辑id
     * @author　xuyongzhe
     * @brief 根据id查询策略
     **/
    logicinfo findLogicById(String id);

    /**
     * @param l logicinfo类
     * @author　xuyongzhe
     * @brief 添加
     **/
    int addLogic(logicinfo l);

    /**
     * @param l  logic类
     * @author　xuyongzhe
     * @brief   更新信息
     **/
    int updateLogicStatus(logicinfo l);

    /**
     * @param id logic　id号
     * @author　xuyongzhe
     * @brief  删除信息
     **/
    int deleteLogic(String id);


}
