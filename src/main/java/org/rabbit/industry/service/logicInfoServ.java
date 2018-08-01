package org.rabbit.industry.service;

import org.rabbit.industry.model.logicinfo;

import java.util.List;

public interface logicInfoServ {

    /**
     * @param pid 项目id
     * @author　xuyongzhe
     * @brief 根据项目查询策略信息
     **/
    String findLogicByProject(int pid);

    /**
     * @param id 逻辑id
     * @author　xuyongzhe
     * @brief 根据id查询策略
     **/
    String findLogicById(String id);

    /**
     * @param json logicinfo类json数据
     * @author　xuyongzhe
     * @brief 添加
     **/
    boolean addLogic(String json);

    /**
     * @param json logic类json数据
     * @author　xuyongzhe
     * @brief 更新信息
     **/
    boolean updateLogicStatus(String json);

    /**
     * @param id logic　id号
     * @author　xuyongzhe
     * @brief 删除信息
     **/
    boolean deleteLogic(String id);

    /**
     * @param
     * @author　xuyongzhe
     * @brief 根据项目删除逻辑id号
     **/
    boolean deleteLogicByPid(int pid);

}
