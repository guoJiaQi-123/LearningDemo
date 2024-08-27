package com.tyut.springai01chat.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @version v1.0
 * @author OldGj 2024/5/2
 * @apiNote openai测试
 */
@RestController
public class ChatController {
    @Resource
    private OpenAiChatClient openAiChatClient;

    /**
     * 调用openai的接口
     * @param msg 问的问题
     * @return ai的回答
     */
    @GetMapping("/ai/chat")
    public String chat(@RequestParam(value = "msg") String msg) {
        return openAiChatClient.call(msg);
    }

    /**
     * 调用openai的接口
     * @param msg 问的问题
     * @return ai的回答
     */
    @GetMapping("/ai/chat2")
    public String chat2(@RequestParam(value = "msg") String msg) {
        ChatResponse chatResponse = openAiChatClient.call(new Prompt(msg));
        return chatResponse.getResult().getOutput().getContent();
    }

    /**
     * 调用openai的接口
     * @param msg 问的问题
     * @return ai的回答
     */
    @GetMapping("/ai/chat3")
    public String chat3(@RequestParam(value = "msg") String msg) {
        ChatResponse response = openAiChatClient.call(
                new Prompt(
                        msg,
                        OpenAiChatOptions.builder()
                                //.withModel("gpt-4-32k")
                                .withTemperature(0.4f) //温度越高，回答得比较有创新性，但是准确率会下降，温度越低，回答的准确率会更好
                                .build()
                ));
        return response.getResult().getOutput().getContent();
    }

    /**
     * 调用openai的接口
     * @param msg 问的问题
     * @return ai的回答
     */
    @GetMapping("/ai/chat4")
    public Object chat4(@RequestParam(value = "msg") String msg) {
        Flux<ChatResponse> flux = openAiChatClient.stream(
                new Prompt(
                        msg
                ));
        flux.toStream().forEach(chatResponse -> {
            System.out.println(chatResponse.getResult().getOutput().getContent());
        });
        return flux.collectList();
    }
}
