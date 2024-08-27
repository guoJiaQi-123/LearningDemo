package com.tyut.springai02image.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageClient;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.ai.openai.api.OpenAiImageApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/5/3
 * @apiNote 图像生成ai控制层
 */
@RestController
public class ImageController {

    @Resource
    private OpenAiImageClient openAiImageClient;

    @GetMapping("/ai/image")
    public Object image(@RequestParam(value = "msg") String msg) {
        ImageResponse call = openAiImageClient.call(new ImagePrompt(msg));
        return call.getResult().getOutput().getUrl();
    }

    @GetMapping("/ai/image2")
    public Object image2(@RequestParam(value = "msg") String msg) {
        ImageResponse call = openAiImageClient.call(new ImagePrompt(msg,
                // 参数
                OpenAiImageOptions.builder()
                        .withN(1)
                        .withHeight(1024)
                        .withWidth(1024)
                        .withQuality("hd")
                        .build()));
        return call.getResult().getOutput().getUrl();
    }

}
