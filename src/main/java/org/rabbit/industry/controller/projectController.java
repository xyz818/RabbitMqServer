package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.projectInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class projectController {
    @Autowired
    projectInfoServ pis;

    @ApiOperation(value = "查询所有项目信息", notes = "查询所有项目信息")
    @RequestMapping(value = "/projectinfo", method = RequestMethod.GET)
    @ResponseBody
    public String findProject()
    {
        return pis.findProJect();
    }

    @ApiOperation(value = "根据账户信息查询项目", notes = "根据账户信息查询项目")
    @RequestMapping(value = "/{aid}/projectinfo", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "项目id号", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public String findProjectByAccount(@PathVariable(value = "aid") String id)
    {
        return pis.findProjectByAccount(id);
    }

    @ApiOperation(value = "查询所有项目信息", notes = "查询所有项目信息")
    @RequestMapping(value = "/projectinfo/{pid}", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "项目id号", required = true, dataType = "int",paramType = "path")
    })
    @ResponseBody
    public String findProjectById(@PathVariable(value = "pid") int id)
    {
        return pis.findProject(id);
    }

    @ApiOperation(value = "添加项目", notes = "添加项目")
    @RequestMapping(value = "/projectinfo", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "json数据信息", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean addProject(@RequestBody String json)
    {
        return pis.addProject(json);
    }

    @ApiOperation(value = "更新项目", notes = "更新项目")
    @RequestMapping(value = "/projectinfo", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "json数据信息", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean updateProject(@RequestBody String json)
    {
        return pis.updateProject(json);
    }


    @ApiOperation(value = "删除项目", notes = "删除项目")
    @RequestMapping(value = "/projectinfo/{pid}", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "p", value = "项目id", required = true, dataType = "int")
    })
    @ResponseBody
    public boolean delProject(@PathVariable(value = "pid") int p)
    {
        return pis.delProject(p);
    }


    @ApiOperation(value = "更新项目状态信息", notes = "更新项目状态信息")
    @RequestMapping(value = "/projectinfo/status", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "json数据集", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean updateProjectStatus(@RequestBody String json)
    {
        return pis.updateProjectStatus(json);
    }



}
