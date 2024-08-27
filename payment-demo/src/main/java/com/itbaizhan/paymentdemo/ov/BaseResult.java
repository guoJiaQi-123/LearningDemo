package com.itbaizhan.paymentdemo.ov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 封装统一结果集
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResult<T> {

    /**
     * 状态码(成功:200 失败:其他)
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     *  构建成功结果
     */
    public static <T> BaseResult<T> ok() {
        return new BaseResult<>(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMessage(), null);
    }

    /**
     *  构建成功结果 带数据
     */
    public static <T> BaseResult<T> ok(T data) {
        return new BaseResult<>(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 构建失败结果
     */
    public static <T> BaseResult<T> error(CodeEnum codeEnum) {
        return new BaseResult<>(codeEnum.getCode(), codeEnum.getMessage(), null);
    }

}
