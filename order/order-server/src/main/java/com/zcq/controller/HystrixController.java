package com.zcq.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author Maybeeeee
 * @date 2019-09-18 13:45
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {


    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            //设置服务降级超时时间
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //设置熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //断路器最小请求
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //最小时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //错误百分比
    })
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

    /**
     * 默认的服务降级
     *
     * @return
     */
    private String defaultFallback() {
        return "默认提示:太拥挤了，请稍候再试~~";
    }
}
