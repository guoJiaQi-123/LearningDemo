package com.tyut.aircraft.pojo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * @version v1.0
 * @author OldGj 2024/6/21
 * @apiNote 用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    @TableId
    private Integer id; // id
    private String username; // 用户名（昵称）
    private String password; // 密码
    private String email; // 邮箱
    private String phoneNum; // 手机号
    private String sex; //性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday; //生日
    private boolean active; //是否激活
    private String activeCode;//激活码
    // 游戏总局数
    private Integer generalNum;

}
