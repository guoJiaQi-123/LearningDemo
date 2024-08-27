package com.tyut.springai04tts.controller;

import com.tyut.springai04tts.util.FileUtils;
import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiAudioSpeechClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/5/4
 * @apiNote 文本转语言
 */
@RestController
public class TtsController {

    @Resource
    private OpenAiAudioSpeechClient openAiAudioSpeechClient;

    @GetMapping("/ai/tts")
    public String tts() {
        String text = "春在人心间，奋斗天地间。北京开辟量子、生命科学、6G等新领域新赛道，天津着力促进科技创新、产业焕新、城市更新，安徽计划加快建设量子信息、聚变能源、深空探测等科创高地……今年以来，各地区各部门围绕新质生产力因地制宜绘制“线路图”，扎实推进经济高质量发展。";
        byte[] bytes = openAiAudioSpeechClient.call(text);
        FileUtils.save2File("D:\\服务\\test.mp3",bytes);
        return "ok";
    }
}
