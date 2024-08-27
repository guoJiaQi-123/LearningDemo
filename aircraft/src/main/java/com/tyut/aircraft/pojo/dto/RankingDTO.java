package com.tyut.aircraft.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 * @author OldGj 2024/6/25
 * @apiNote TODO(一句话给出该类描述)
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RankingDTO {

    private String index;
    private String diff;

}
