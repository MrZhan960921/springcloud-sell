package com.zcq.controller;

import com.zcq.client.ProductClient;
import com.zcq.common.DecreaseStockInput;
import com.zcq.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Maybeeeee
 * @date 2019-09-09 00:06
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }

    @PostMapping("/getProductList")
    public String getProductList() {
        List<ProductInfoOutput> productInfoOutputList = productClient.listForOrder(Arrays.asList("164103465734242707"));
        return "ok";
    }

    @PostMapping("/decreaseStock")
    public String decreaseStock() {
        productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("157875227953464068", 2)));
        return "ok";
    }
}
