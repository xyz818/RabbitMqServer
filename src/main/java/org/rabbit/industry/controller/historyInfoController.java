package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.industry.service.historyServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class historyInfoController {

    @Autowired
    historyServ hs;




    @ApiOperation(value = "根据设备号和控制类型查询传感器", notes = "传感器json数组")
    @RequestMapping(value = "/historyrecord/time", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "json包", required = true, dataType = "String")
    })
    @ResponseBody
    public String findHistroyByTime(@RequestBody String json) {

         return    hs.findHistroyByTime(json);
    }


}
