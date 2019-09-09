package com.zcq.enums;

/**
 * 商品上下架状态
 * @author Maybeeeee
 * @date 2019-09-08 03:01
 */
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架");

    public Integer code;

    public String messgae;

    ProductStatusEnum(Integer code, String messgae) {
        this.code = code;
        this.messgae = messgae;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessgae() {
        return messgae;
    }
}
