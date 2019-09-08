package com.zcq.enums;

import lombok.Getter;

/**
 * @author Maybeeeee
 * @date 2019-09-08 22:03
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
