package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.deviceInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deviceinfo")
public class deviceInifoController {
    @Autowired
    deviceInfoServ dis;
    @ApiOperation(value = "根据项目查询设备", notes = "根据项目查询设备")
    @RequestMapping(value = "/{pid}/devices", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "项目id", required = true, dataType = "int",paramType = "path")
    })
    @ResponseBody
    public String findDeviceByProject(@PathVariable(value = "pid") int pid)
    {
        return dis.findDeivceByProject(pid);
    }


    @ApiOperation(value = "查询设备信息", notes = "查询设备信息")
    @RequestMapping(value = "/devices/{did}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "did", value = "设备id", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public String findDeviceById(@PathVariable(value = "did") String did)
    {
        return dis.findDeviceById(did);
    }


    @ApiOperation(value = "添加设备", notes = "添加设备")
    @RequestMapping(value = "/device", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean addDevice(String json)
    {
        return dis.addDevice(json);
    }


    @ApiOperation(value = "更新设备", notes = "更新设备")
    @RequestMapping(value = "/device", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean updateDevice(String json)
    {
        return dis.updateDevice(json);
    }


    @ApiOperation(value = "删除设备", notes = "删除设备")
    @RequestMapping(value = "/devices/{did}", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "设备id", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public boolean delDevice(@PathVariable(value = "id") String id)
    {
        return dis.deleteDevice(id);
    }




}
