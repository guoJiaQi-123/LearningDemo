package com.itbaizhan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @version v1.0
 * @author OldGj 2024/4/28
 * @apiNote 统一结果返回集
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseResult {

    private Integer code; // 状态码
    private String message; // 返回信息
    private Object data; // 返回数据

    // 错误结果返回
    public static BaseResult fail(String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(500);
        baseResult.setMessage(message);
        return baseResult;
    }


    //成功结果返回
    public static BaseResult ok(Object data) {
        return new BaseResult(200, "SUCCESS", data);
    }
}
