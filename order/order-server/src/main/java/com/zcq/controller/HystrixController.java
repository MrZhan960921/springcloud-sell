package com.zcq.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author Maybeeeee
 * @date 2019-09-18 13:45
 */
@RestController
public class HystrixController {

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/getProductInfoList")
    public String getProductInfoList() {
        //调用商品服务
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:9001/product/listForOrder",
                Arrays.asList("157875196366160022"),
                String.class);
    }

    private String fallback() {
        return "太拥挤了，请稍候再试~~";
    }
}
