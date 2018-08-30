package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.schoolInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
public class schoolController {

    @Autowired
    private schoolInfoServ sis;


    @ApiOperation(value = "查询所有学校", notes = "所有学校")
    @RequestMapping(value = "/schoolinfo", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String findSchool() {
        return sis.findSchool();
    }
    @ApiOperation(value = "根据id查询学校", notes = "根据id查询学校")
    @RequestMapping(value = "/schoolinfo/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学校id", required = true, dataType = "String",paramType = "path")
    })
    public String  findSchoolById(@PathVariable(value = "id") String id)
    {
        return sis.findSchoolById(id);
    }



    @ApiOperation(value = "添加学校信息", notes = "添加学校信息")
    @RequestMapping(value = "/schoolinfo", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "学校信息", required = true, dataType = "String")
    })
    public boolean addSchool(String json)
    {
        return sis.addSchoolInfo(json);
    }


    @ApiOperation(value = "更改学校信息", notes = "更改学校信息")
    @RequestMapping(value = "/schoolinfo", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "学校信息", required = true, dataType = "String")
    })
    public boolean updateSchool(String json)
    {
        return sis.updateSchool(json);

    }





}
