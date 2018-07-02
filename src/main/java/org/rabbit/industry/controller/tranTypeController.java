package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.tranTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trantypeinfo")
public class tranTypeController {

    @Autowired
    tranTypeServ tts;



    @ApiOperation(value = "查询所有传输类型", notes = "所有传输类型")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String findTranType()
    {

       return tts.findTranType();

    }

    @ApiOperation(value = "添加传输类型", notes = "添加内容")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    public int addTranType(@RequestBody String json)
    {

        return  tts.addTranType(json);
    }


}
