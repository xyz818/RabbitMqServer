package org.rabbit.industry.dao;

import org.rabbit.industry.model.controllerinfo;

import java.util.List;

public interface controllerInfoDao {


    /**
     * @param pid 根据项目查询可控制
     * @author　xuyongzhe
     * @brief 根据项目查询传感器
     **/
    List<controllerinfo> findControllerByProject(int pid);

    /**
     * @param id 逻辑号
     * @author　xuyongzhe
     * @brief 根据逻辑号查询可执行
     **/
    List<controllerinfo> findControllerByLogic(String id);

    /**
     * @param
     * @author　xuyongzhe
     * @brief 查询ｉｄ
     **/
    controllerinfo  findControllerById(String id);

    int updateController(controllerinfo c);


    int addControllerInfo(controllerinfo c);

    /**
     * @param  sid 触发类传感器id
     * @author　xuyongzhe
     * @brief 根据触发器传感器id号查询控制类传感器id号
     **/
    List<controllerinfo> findControllerByTrigId(String sid);


}
