package com.zcq.enums;

import lombok.Getter;

/**
 * @author Maybeeeee
 * @date 2019-09-08 22:03
 */
@Getter
public enum ResultEnum {
    LOGIN_FAIL(1, "登录失败"),
    ROLE_ERROR(2,"角色权限有误")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
