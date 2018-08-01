package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.logicInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class logicInfoController {
    @Autowired
    logicInfoServ lis;

    @ApiOperation(value = "根据项目查询逻辑", notes = "根据项目查询逻辑")
    @RequestMapping(value = "/{pid}/logicinfo", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "项目id", required = true, dataType = "int",paramType = "path")
    })
    @ResponseBody
    public String findLogicByProject(@PathVariable() int pid) {
        return lis.findLogicByProject(pid);
    }



    @ApiOperation(value = "根据逻辑id查询逻辑", notes = "根据逻辑id查询逻辑")
    @RequestMapping(value = "/logicinfo/{lid}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lid", value = "逻辑id", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public String findLogicById(@PathVariable(value = "lid") String id) {
        return lis.findLogicById(id);
    }

    @ApiOperation(value = "添加逻辑", notes = "添加逻辑")
    @RequestMapping(value = "/logicinfo", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "json数值", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean addLogic(@RequestBody String json) {

        return lis.addLogic(json);
    }

    @ApiOperation(value = "更新状态信息", notes = "更新状态信息")
    @RequestMapping(value = "/logicinfo/status", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "json数值", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean updateStatus(@RequestBody  String json) {
        return lis.updateLogicStatus(json);
    }

    @ApiOperation(value = "删除逻辑信息", notes = "删除逻辑信息")
    @RequestMapping(value = "/logicinfo/{lid}", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lid", value = "逻辑id号", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public boolean deleteLogic(@PathVariable(value = "lid") String id) {
        return lis.deleteLogic(id);
    }


}
