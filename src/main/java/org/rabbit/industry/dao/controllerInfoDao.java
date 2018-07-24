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

    controllerinfo  findControllerById(String id);

    int updateController(controllerinfo c);


}
