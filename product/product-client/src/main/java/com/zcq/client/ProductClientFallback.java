package com.zcq.client;

import com.zcq.common.DecreaseStockInput;
import com.zcq.common.ProductInfoOutput;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Maybeeeee
 * @date 2019-09-18 15:00
 */
@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public String productMsg() {
        return null;
    }

    @Override
    public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
        return null;
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

    }
}
