package org.rabbit.industry.service;

public interface triggerInfoServ {

    String findTriggerInfoByProject(int pid);



    String findTriggerByLogic(String lid);


    String findTriggerById(int id);

    /**
     * @param json
     * @author　xuyongzhe
     * @brief 更新触发器
     **/
    boolean updateTrigger(String json);

}
