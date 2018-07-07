package org.rabbit.industry.controller;

import org.rabbit.industry.service.logicInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/logicinfo")
public class logicInfoController  {
    @Autowired
    logicInfoServ lis;

    public String findLogicByProject(int pid)
    {
        return lis.findLogicByProject(pid);
    }



    public String findLogicById(String id)
    {
        return lis.findLogicById(id);
    }


    public boolean addLogic(String json)
    {

        return lis.addLogic(json);
    }


    public boolean updateStatus(String json)
    {
        return lis.updateLogicStatus(json);
    }


    public boolean deleteLogic(String id)
    {
        return lis.deleteLogic(id);
    }



}
