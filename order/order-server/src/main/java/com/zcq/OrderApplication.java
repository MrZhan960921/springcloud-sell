package com.zcq;

import com.zcq.message.StreamInput;
import com.zcq.message.StreamOutput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author Maybeeeee
 * @date 2019-09-08 22:03
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableBinding({StreamOutput.class,StreamInput.class})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
