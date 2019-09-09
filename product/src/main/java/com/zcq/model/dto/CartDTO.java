package com.zcq.model.dto;

import lombok.Data;

/**
 * 购物车
 *
 * @author Maybeeeee
 * @date 2019-09-09 21:15
 */
@Data
public class CartDTO {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;


}
