package com.zcq.enums;

import lombok.Getter;

/**
 * @author Maybeeeee
 * @date 2019-09-08 22:03
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
