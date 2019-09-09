package com.zcq.common;

import lombok.Data;

/**
 * 维护商品模块的扣库存
 * @author Maybeeeee
 * @date 2019-09-08 02:28
 */
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}