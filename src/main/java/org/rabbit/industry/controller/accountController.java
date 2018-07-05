package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.rabbit.industry.model.accountinfo;
import org.rabbit.industry.service.imp.accountServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/accountinfo")
public class accountController {

    @Autowired
    accountServImp asi;

    @ApiOperation(value = "账户验证登录", notes = "账户验证登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean verifyLogin(String json)
    {
        return asi.verifyLogin(json);
    }

    @ApiOperation(value = "根据用户id更新信息", notes = "根据用户id更新信息")
    @RequestMapping(value = "/info", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean updateAccount(@RequestBody String json)
    {
        return asi.updateAccount(json);
    }



    @ApiOperation(value = "修改用户信息密码", notes = "修改用户信息密码")
    @RequestMapping(value = "/pwsd", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean updatePwsd(@RequestBody String json)
    {

        return asi.updateAccount(json);
    }


}
