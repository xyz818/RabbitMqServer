package org.rabbit.industry.service;

public interface controllerInfoServ {


    String findControllerByProject(int pid);




    String findControllerByLogic(String lid);




    String findControllerById(String id);




    boolean updateController(String json);




}
