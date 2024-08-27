package com.itbaizhan.springbootdemo4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrintLogController {
    private final static Logger logger = LoggerFactory.getLogger(PrintLogController.class);

    @RequestMapping("/printLog")
    @ResponseBody
    public String printLog(){
        logger.info("郭家旗打印日志！调用printLog方法！");
        return "hello log";
    }
}
