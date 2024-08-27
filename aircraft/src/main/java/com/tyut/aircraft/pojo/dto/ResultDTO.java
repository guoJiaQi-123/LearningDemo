package com.tyut.aircraft.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 * @author OldGj 2024/6/24
 * @apiNote TODO(一句话给出该类描述)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultDTO {

    private Integer persistTime;
    private String result;

}
