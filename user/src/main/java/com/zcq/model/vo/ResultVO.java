package com.zcq.model.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @author Maybeeeee
 * @date 2019-09-08 03:10
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
