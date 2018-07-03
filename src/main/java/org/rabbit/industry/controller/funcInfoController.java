package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.funcInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/funcinfo")
public class funcInfoController {
    @Autowired
    funcInfoServ fis;

    @ApiOperation(value = "查询所有控制类型", notes = "控制类型")
    @RequestMapping(value = "/", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String findFuncType() {
        return fis.findFuncType();
    }

    @ApiOperation(value = "添加控制类型", notes = "添加控制内容")
    @RequestMapping(value = "/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    public int addFuncType(@RequestBody String json) {

        return fis.addFuncType(json);
    }


}
