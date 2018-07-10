package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.senInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class sensorInfoContoller {

    @Autowired
    senInfoServ sis;

    @ApiOperation(value = "根据设备号查询所有传感器", notes = "传感器列表json")
    @RequestMapping(value = "/{devId}/sensorinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "devId", value = "设备id号", required = true, dataType = "String", paramType = "path")
    })
    @ResponseBody
    public String findSensorByDevice(@PathVariable(value = "devId") String devId) {
        return sis.findSensorByDevice(devId);
    }

    @ApiOperation(value = "根据传感器id号查询传感器", notes = "传感器json")
    @RequestMapping(value = "/sensorinfo/{Id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Id", value = "传感器id号", required = true, dataType = "String", paramType = "path")
    })
    @ResponseBody
    public String findSensorById(@PathVariable(value = "Id") String id) {
        return sis.findSensorById(id);
    }

    @ApiOperation(value = "根据设备号和控制类型查询传感器", notes = "传感器json数组")
    @RequestMapping(value = "/sensorinfo/devIdOnControl", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "设备与控制json包", required = true, dataType = "String")
    })
    @ResponseBody
    public String findSensorByControl(@RequestBody String json) {
        return sis.findSensorByControl(json);
    }

    @ApiOperation(value = "添加传感器数据", notes = "传感器json数组")
    @RequestMapping(value = "/sensorinfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "传感器数据包", required = true, dataType = "String")
    })
    @ResponseBody
    public int addSensor(@RequestBody String json) {
        return sis.addSensor(json);
    }

    @ApiOperation(value = "更新传感器数据", notes = "传感器json数组")
    @RequestMapping(value = "/sensorinfo", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "传感器数据包", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean updateSensor(String json) {
        return sis.updateSensor(json);
    }


    @ApiOperation(value = "删除传感器数据", notes = "传感器json数组")
    @RequestMapping(value = "/sensorinfo/{id}", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "传感器id号", required = true, dataType = "String",paramType = "path")
    })
    public boolean deleteSensorInfo(@PathVariable(value = "id") String id) {
        return sis.deleteSensor(id);
    }


}
