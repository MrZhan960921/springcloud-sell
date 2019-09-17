package com.zcq.enums;

import lombok.Getter;

/**
 * @author Maybeeeee
 * @date 2019-09-18 00:37
 */
@Getter
public enum RoleEnum {
    BUYER(1, "买家"),

    SELLER(2, "卖家");

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
