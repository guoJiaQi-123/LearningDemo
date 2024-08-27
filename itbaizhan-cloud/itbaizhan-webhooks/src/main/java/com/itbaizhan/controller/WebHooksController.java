package com.itbaizhan.controller;

import com.itbaizhan.domain.HooksDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/6
 * @apiNote 网络钩子
 */
@RestController
public class WebHooksController {

    @PostMapping("/hooks")
    public void hooks(@RequestBody List<HooksDTO> alarmMessageDtoList){
        StringBuilder builder = new StringBuilder();
        alarmMessageDtoList.forEach(info -> {
            builder.append("\nscopeId:").append(info.getScopeId())
                    .append("\nScope实体:").append(info.getScope())
                    .append("\n告警消息:").append(info.getAlarmMessage())
                    .append("\n告警规则:").append(info.getRuleName())
                    .append("\n\n------------------------\n\n");
        });
    }

}
