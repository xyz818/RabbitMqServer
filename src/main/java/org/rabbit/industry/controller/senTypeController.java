package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.sensorTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sensortypeinfo")
public class senTypeController {

    @Autowired
    sensorTypeServ sts;

    //    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
//            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
//    })
    @ApiOperation(value = "查询所有传感器类型", notes = "所有传感器")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String findSensorType() {
        return sts.findSensorType();

    }

    @ApiOperation(value = "根据控制类型查询传感器类型", notes = "可选传感器")
    @RequestMapping(value = "/{control}", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "control", value = "是否可控制", required = true, dataType = "int", paramType = "path")
    })
    public String findSensorTypeByControl(@PathVariable(value = "control") int control) {
        return sts.findSensorTypeByControl(control);
    }

    @ApiOperation(value = "添加传感器类型数据", notes = "添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "对象json包数据", required = true, dataType = "String")
    })
    public int addSensorType(@RequestBody String json) {
        return sts.addSensorType(json);

    }

}
