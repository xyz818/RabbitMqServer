package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.senFuncServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public int addSFtype(@RequestBody String json)
    {
        return sfs.addSFtype(json);
    }

}
