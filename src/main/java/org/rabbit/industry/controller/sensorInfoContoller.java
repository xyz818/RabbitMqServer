package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.senInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sensorinfo")
public class sensorInfoContoller {

    @Autowired
    senInfoServ sis;

    @ApiOperation(value = "根据设备号查询所有传感器", notes = "传感器列表json")
    @RequestMapping(value = "/{devId}", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "devId", value = "是否可控制", required = true, dataType = "String", paramType = "path")
    })
    public String findSensorByDevice(@PathVariable(value = "devId")String devId)
    {
        return sis.findSensorByDevice(devId);
    }


}
