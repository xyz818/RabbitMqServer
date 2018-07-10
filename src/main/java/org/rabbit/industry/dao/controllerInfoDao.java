package org.rabbit.industry.dao;

import org.rabbit.industry.model.controllerinfo;

import java.util.List;

public interface controllerInfoDao {
    List<controllerinfo> findControllerByProject(int pid);

    List<controllerinfo> findControllerByLogic(String id);

    controllerinfo  findControllerById(String id);

    int updateController(controllerinfo c);


}
