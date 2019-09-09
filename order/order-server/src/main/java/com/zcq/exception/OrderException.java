package com.zcq.exception;


import com.zcq.enums.ResultEnum;

/**
 * @author Maybeeeee
 * @date 2019-09-08 22:03
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
