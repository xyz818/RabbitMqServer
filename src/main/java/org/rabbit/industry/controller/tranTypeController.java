package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.tranTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class tranTypeController {

    @Autowired
    tranTypeServ tts;



    @ApiOperation(value = "查询所有传输类型", notes = "所有传输类型")
    @RequestMapping(value = "/trantypeinfo", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String findTranType()
    {

       return tts.findTranType();

    }

    @ApiOperation(value = "添加传输类型", notes = "添加内容")
    @RequestMapping(value = "/trantypeinfo", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public int addTranType(@RequestBody String json)
    {
        return  tts.addTranType(json);
    }




    @ApiOperation(value = "根据传感器类型查询传输类型", notes = "根据传感器类型查询传输类型")
    @RequestMapping(value = "/trantypeinfo/{stid}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stid", value = "传感器传输类型", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public String findTranTypeByStid(@PathVariable(value = "stid") String stid)
    {

        return tts.findTranTypeByStid(stid);

    }



}
