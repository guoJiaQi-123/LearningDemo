package com.tyut.aircraft.pojo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @version v1.0
 * @author OldGj 2024/6/24
 * @apiNote 游戏局数实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {
    @TableId
    private Integer gid;

    private Date createTime;
    private Integer persistTime;
    private String result;
    private Integer ranking;
    private String difficulty;
    // 和用户ID的关联字段
    private String username;
    @TableField(exist = false)
    private String createTimeDTO;
    @TableField(exist = false)
    private String persistTimeDTO;

}
