package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.rabbit.industry.service.projectTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value = "/projecttype")
public class projectTypeController {

    @Autowired
    projectTypeServ pts;


    @ApiOperation(value = "查询所有的项目类型", notes = "查询所有的项目类型")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findProjectType()
    {
        return pts.findPorjectType();
    }

    @ApiOperation(value = "添加项目类型", notes = "添加项目类型")
    @RequestMapping(value = "/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean addProjectType(@RequestBody String json)
    {
        return pts.addProjectType(json);
    }


}
