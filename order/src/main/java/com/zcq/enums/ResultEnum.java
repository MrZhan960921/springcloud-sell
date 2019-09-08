package com.zcq.enums;

import lombok.Getter;

/**
 * @author Maybeeeee
 * @date 2019-09-08 22:03
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空")

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
