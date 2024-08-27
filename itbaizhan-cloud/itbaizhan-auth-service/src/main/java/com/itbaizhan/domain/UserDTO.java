package com.itbaizhan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

/**
 * @version v1.0
 * @author OldGj 2024/4/28
 * @apiNote 用户类 - 测试登录
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    // 用户名
    private String username;
    // 密码
    private String password;
}
