package com.zcq.client;

import com.zcq.model.dto.CartDTO;
import com.zcq.model.po.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * feign客户端,调用product服务的接口
 *
 * @author Maybeeeee
 * @date 2019-09-09 01:25
 */
@FeignClient(name = "PRODUCT")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);

}
