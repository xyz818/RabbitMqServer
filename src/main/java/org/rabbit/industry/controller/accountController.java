package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rabbit.config.IpUtil;
import org.rabbit.industry.service.imp.accountServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class accountController {

    @Autowired
    accountServImp asi;


    @ApiOperation(value = "账户验证登录", notes = "账户验证登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean verifyLogin(@RequestBody String json) {
        return asi.verifyLogin(json);
    }

    @ApiOperation(value = "根据用户id更新信息", notes = "根据用户id更新信息")
    @RequestMapping(value = "/accountinfo", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean updateAccount(@RequestBody String json) {
        return asi.updateAccount(json);
    }


    @ApiOperation(value = "修改用户信息密码", notes = "修改用户信息密码")
    @RequestMapping(value = "/accountinfo/pwsd", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean updatePwsd(@RequestBody String json) {

        return asi.updateAccount(json);
    }

    @ApiOperation(value = "查询所有的用户", notes = "查询所有的用户")
    @RequestMapping(value = "/accountinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String findAccount() {
        return asi.findAccount();

    }


    @ApiOperation(value = "根据学校id查询所有的用户", notes = "根据学校id查询所有的用户")
    @RequestMapping(value = "/{sid}/accountinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "学校id", required = true, dataType = "String", paramType = "path")
    })
    @ResponseBody
    public String findUserBySchool(@PathVariable(value = "sid") String sid) {
        return asi.findAccount(sid);
    }


    @ApiOperation(value = "根据用户id查询所有的信息", notes = "根据用户id查询所有的信息")
    @RequestMapping(value = "/accountinfo/{uid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", required = true, dataType = "String", paramType = "path")
    })
    @ResponseBody
    public String findUserById(@PathVariable(value = "uid") String uid) {
        return asi.findAccountByAid(uid);
    }

    @ApiOperation(value = "添加用户信息", notes = "添加用户信息")
    @RequestMapping(value = "/accountinfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean addAccount(@RequestBody String json) {
        return asi.addAccountInfo(json);

    }


}
