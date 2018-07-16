package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.senFuncServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sensorfunc")
public class senFuncController {
    @Autowired
    senFuncServ sfs;
    @ApiOperation(value = "添加传感器与控制类型关联", notes = "添加控制内容")
    @RequestMapping(value = "/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public int addSFtype(@RequestBody String json)
    {
        return sfs.addSFtype(json);
    }

    @ApiOperation(value = "根据传感器id查询关联传感器与功能", notes = "查询关联传感器与功能")
    @RequestMapping(value = "/{sid}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "传感器id", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public String selSensorFunc(@PathVariable(value = "sid") String sid)
    {
        return sfs.selSensorFunc(sid);
    }

    @ApiOperation(value = "根据传感器id,控制类型查询关联传感器与功能", notes = "根据传感器id,控制类型查询关联传感器与功能")
    @RequestMapping(value = "/{sid}/{fid}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "传感器id", required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "fid", value = "控制类型id", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public String selSensorFuncByFid(@PathVariable(value = "sid") String sid,@PathVariable(value = "fid") String fid)
    {
        return sfs.selSensorFuncByFid(sid,fid);
    }





}
