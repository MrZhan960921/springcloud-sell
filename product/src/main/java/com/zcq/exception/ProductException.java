package com.zcq.exception;


import com.zcq.enums.ResultEnum;

/**
 * @author Maybeeeee
 * @date 2019-09-08 02:59
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
