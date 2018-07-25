package org.rabbit.industry.service;

public interface controllerInfoServ {


    String findControllerByProject(int pid);




    String findControllerByLogic(String lid);




    String findControllerById(String id);




    boolean updateController(String json);

    /**
     * @param  id 触发id
     * @author　xuyongzhe
     * @brief 查询控制器id
     **/
    String findControllerByTrigId(String id);


}
