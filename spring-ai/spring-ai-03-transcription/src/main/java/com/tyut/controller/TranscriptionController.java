package com.tyut.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiAudioTranscriptionClient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/5/4
 * @apiNote 语音转文本测试
 */
@RestController
public class TranscriptionController {

    @Resource
    private OpenAiAudioTranscriptionClient transcriptionClient;

    @GetMapping("/ai/transcription")
    public Object transcription() {
        org.springframework.core.io.Resource resource = new ClassPathResource("jfk.flac");
        String string = transcriptionClient.call(resource);
        System.out.println(string);
        return string;
    }
}
