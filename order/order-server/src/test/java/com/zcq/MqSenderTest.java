package com.zcq;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * mq消息发送端
 *
 * @author Maybeeeee
 * @date 2019-09-10 21:37
 */
@Component
public class MqSenderTest extends OrderApplicationTests {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue", "now" + new Date());
    }

    @Test
    public void sendOrder() {
        amqpTemplate.convertAndSend("myOrder", "computer", "now" + new Date());
    }
}
