package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.funcInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/funcinfo")
public class funcInfoController {
    @Autowired
    funcInfoServ fis;

    @ApiOperation(value = "查询所有控制类型", notes = "控制类型")
    @RequestMapping(value = "/", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String findFuncType() {
        return fis.findFuncType();
    }

    @ApiOperation(value = "添加控制类型", notes = "添加控制内容")
    @RequestMapping(value = "/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public int addFuncType(@RequestBody String json) {

        return fis.addFuncType(json);
    }


    @ApiOperation(value = "根据传感器stid查询功能信息", notes = "根据传感器stid查询功能信息")
    @RequestMapping(value = "/{stid}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stid", value = "传感器类型id", required = true, dataType = "String",paramType = "path")
    })
    @ResponseBody
    public String findFuncInfoByStid(@PathVariable(value = "stid") String stid) {
        return fis.findFuncInfoByStid(stid);
    }
}
