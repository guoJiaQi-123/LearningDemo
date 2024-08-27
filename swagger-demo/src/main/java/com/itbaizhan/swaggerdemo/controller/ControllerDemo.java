package com.itbaizhan.swaggerdemo.controller;

import com.itbaizhan.swaggerdemo.config.NotIncludeSwagger;
import com.itbaizhan.swaggerdemo.domain.People;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/people")
@Api(tags = {"loginController"}, description = "登录接口")
public class ControllerDemo {


    //@NotIncludeSwagger
    //@ApiIgnore
    @ApiOperation(value = "获取人员信息", notes = "根据人员ID和姓名获取人员信息")
    @RequestMapping(value = "/getPeople", method = RequestMethod.GET)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "人员ID", required = true),
            @ApiImplicitParam(name = "name", value = "人员姓名", required = true)})
    public People getPeople(Long id, String name) {
        People peo = new People();
        peo.setId(id);
        peo.setName(name);
        peo.setAddress("海淀");
        return peo;
    }
}