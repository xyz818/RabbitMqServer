package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.rabbit.industry.service.sensorFuncInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class sensorFuncInfoController {
    @Autowired
    sensorFuncInfoServ sfis;

    @ApiOperation(value = "添加传感器与功能码", notes = "添加传感器与功能码")
    @RequestMapping(value = "/sensorfuncinfo", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean addSensorFuncInfo(@RequestBody String json)
    {
        return sfis.addSensorFuncInfo(json);
    }


    @ApiOperation(value = "更新传感器与功能码", notes = "更新传感器与功能码")
    @RequestMapping(value = "/sensorfuncinfo", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean updateSensorFuncInfo(@RequestBody String json)
    {
        return sfis.updateSensorFuncInfo(json);
    }



    @ApiOperation(value = "删除传感器与功能码", notes = "删除传感器与功能码")
    @RequestMapping(value = "/sensorfuncinfo", method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean delSensorFuncInfo(@RequestBody String json)
    {
        return sfis.delSensorFuncInfo(json);
    }


    @ApiOperation(value = "查询功能码", notes = "查询功能码")
    @RequestMapping(value = "/sensorfuncinfo/code", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public String selectFuncCode(@RequestBody String json)
    {
        JSONObject js = JSONObject.fromObject(json);
        return sfis.selectFuncCode(js.getString("sei_id"),js.getString("sti_id"),js.getString("fui_id"));
    }

}
