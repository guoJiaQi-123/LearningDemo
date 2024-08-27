package com.tyut.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version v1.0
 * @author OldGj 2024/8/21
 * @apiNote 统一结果返回集
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class R implements Serializable {

    // 响应码
    private int code;
    // 描述
    private String message;
    // 数据
    private Object data;

    public static R ok() {
        return new R(200, "success", null);
    }

    public static R ok(Object data) {
        return new R(200, "success", data);
    }

    public static R error() {
        return new R(500, "error", null);
    }

    public static R error(String message) {
        return new R(500, message, null);
    }
}
