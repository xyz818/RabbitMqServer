package org.rabbit.industry.dao;

import org.rabbit.industry.model.triggerinfo;

import java.util.List;

public interface triggerInfoDao {


    List<triggerinfo>  findTriggerByProject(int pid);

    List<triggerinfo> findTriggerByLogic(String id);

    triggerinfo findTriggerById(int id);

    int updateTrigger(triggerinfo t);


}
