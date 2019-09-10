package com.zcq.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受mq消息
 *
 * @author Maybeeeee
 * @date 2019-09-10 21:31
 */
@Slf4j
@Component
public class MqReceiver {

    // 自动创建队列
    //@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    // 自动创建队列和交换机并绑定

    /**
     * 数码供应商接受消息
     *
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void processComputer(String message) {
        log.info("computer MqReceiver:{}", message);
    }

    /**
     * 水果供应商接受消息
     *
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void processFruit(String message) {
        log.info("fruit MqReceiver:{}", message);
    }
}
