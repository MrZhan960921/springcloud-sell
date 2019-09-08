package com.zcq.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

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

}
