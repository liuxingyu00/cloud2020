package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回类
 *
 * @Author wz
 * @Date 2022/8/28 15:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private int code;
    private String message;
    private T data;

    public CommonResult(int code, String message) {
        this(code, message, null);
    }

}
