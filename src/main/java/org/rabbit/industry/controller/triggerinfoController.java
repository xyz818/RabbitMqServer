package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.triggerInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class triggerinfoController {

    @Autowired
    triggerInfoServ tis;

    @ApiOperation(value = "根据项目查询触发器", notes = "根据项目查询触发器")
    @RequestMapping(value = "/{pid}/logic/triggerinfo", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "项目id", required = true, dataType = "int",paramType = "path")
    })
    @ResponseBody
    public String findTriggerByProject(@PathVariable(value = "pid") int pid)
    {
        return tis.findTriggerInfoByProject( pid);
    }


    @ApiOperation(value = "根据逻辑查询触发器", notes = "根据逻辑查询触发器")
    @RequestMapping(value = "/project/{lid}/triggerinfo", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lid", value = "项目id", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public String findTriggerByLogic(@PathVariable(value = "lid") String lid)
    {
        return tis.findTriggerByLogic(lid);

    }

    @ApiOperation(value = "根据id查询触发器", notes = "根据id查询触发器")
    @RequestMapping(value = "/triggerinfo/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目id", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public String findTriggerById(@PathVariable(value = "id") int id)
    {
        return tis.findTriggerById(id);

    }


    @ApiOperation(value = "修改触发器", notes = "修改触发器")
    @RequestMapping(value = "/triggerinfo", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "json数据", required = true, dataType = "int")
    })
    @ResponseBody
    public boolean updateTrigger(@RequestBody String json)
    {
        return tis.updateTrigger(json);
    }



}
