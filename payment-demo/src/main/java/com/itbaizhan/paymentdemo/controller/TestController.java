package com.itbaizhan.paymentdemo.controller;

import com.itbaizhan.paymentdemo.config.WxPayConfig;
import com.itbaizhan.paymentdemo.config.ZfbPayConfig;
import com.itbaizhan.paymentdemo.ov.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 测试启动类
 */
@RestController
public class TestController {

    private final WxPayConfig wxPayConfig; // 微信配置文件

    private final ZfbPayConfig zfbPayConfig;

    @Autowired
    public TestController(WxPayConfig wxPayConfig, ZfbPayConfig zfbPayConfig) {
        this.wxPayConfig = wxPayConfig;
        this.zfbPayConfig = zfbPayConfig;
    }

    @GetMapping("/hello")
    public BaseResult<String> test() {
        return BaseResult.ok("你好");
    }

    /**
     * 读取微信配置文件
     * @return
     */
    @GetMapping("/getWXConfig")
    public BaseResult<String> getWXConfig() {
        String mchId = wxPayConfig.getMchId();
        return BaseResult.ok(mchId);
    }

    /**
     * 读取支付宝配置文件
     * @return
     */
    @GetMapping("/getZfcConfig")
    public BaseResult<String> getZfbConfig() {
        String appId = zfbPayConfig.getAppId();
        return BaseResult.ok(appId);
    }

}
