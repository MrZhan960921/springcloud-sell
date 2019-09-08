package com.zcq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Maybeeeee
 * @date 2019-09-08 02:25
 */
@SpringBootApplication
@EnableEurekaClient
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run( ProductApplication.class, args );
    }

}
