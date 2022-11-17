package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Payment 实体类
 *
 * @Author wz
 * @Date 2022/8/28 15:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private static final long serialVersionUID = -3152084572264175328L;

    private Long id;
    private String serial;

}
