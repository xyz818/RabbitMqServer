package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.rabbit.industry.service.controllerInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class controlController {

    @Autowired
    controllerInfoServ cis;



    @ApiOperation(value = "根据项目查询逻辑", notes = "根据项目查询逻辑")
    @RequestMapping(value = "/{pid}/logic/controllerinfo", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "项目id", required = true, dataType = "int",paramType = "path")
    })
    @ResponseBody
    public String findControllerByProject(@PathVariable(value = "pid") int  pid)
    {
        return cis.findControllerByProject(pid);
    }



    @ApiOperation(value = "根据逻辑id查询控制", notes = "根据逻辑id查询控制")
    @RequestMapping(value = "/project/{lid}/controllerinfo", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "逻辑id", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public String findControllerByLogic(@PathVariable(value = "id") String id)
    {

        return cis.findControllerByLogic(id);
    }


    @ApiOperation(value = "根据id查询逻辑", notes = "根据id查询逻辑")
    @RequestMapping(value = "/controllerinfo/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "控制器id", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public String findControllerById(@PathVariable(value = "id") String id)
    {
        return cis.findControllerById(id);

    }

    @ApiOperation(value = "更新逻辑控制信息", notes = "更新逻辑")
    @RequestMapping(value = "/controllerinfo", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "json数据", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean updateController(@RequestBody String json)
    {
        return cis.updateController(json);
    }

}
