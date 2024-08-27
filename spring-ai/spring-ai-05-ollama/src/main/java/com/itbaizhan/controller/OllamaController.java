package com.itbaizhan.controller;

/**
 * @version v1.0
 * @author OldGj 2024/5/5
 * @apiNote TODO(一句话给出该类描述)
 */

import jakarta.annotation.Resource;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {

    @Resource
    private OllamaChatClient ollamaChatClient;

    @GetMapping("/ai/ollama")
    public String ollama(@RequestParam(value = "msg") String msg) {
        String call = ollamaChatClient.call(msg);
        System.out.println(call);
        return call;
    }

    @GetMapping("/ai/toAi")
    public String test() {
        return "redirect:http://localhost:32770";
    }

}
