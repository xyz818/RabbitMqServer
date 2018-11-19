package org.rabbit.industry.service;

public interface triggerInfoServ {

    String findTriggerInfoByProject(int pid);


    boolean addTrigger(String json);
    String findTriggerByLogic(String lid);


    String findTriggerById(int id);

    /**
     * @param json
     * @author　xuyongzhe
     * @brief 更新触发器
     **/
    boolean updateTrigger(String json);

    String findTriggerBySid(String sid,String lid);

}
