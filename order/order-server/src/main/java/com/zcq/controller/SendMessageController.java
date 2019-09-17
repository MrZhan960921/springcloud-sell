package com.zcq.controller;

import com.zcq.message.StreamOutput;
import com.zcq.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Maybeeeee
 * @date 2019-09-10 22:19
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamOutput streamOutput;

    /**
     * 发送OrderDTO对象
     */
    @GetMapping("/sendMessage")
    public void process() {
        String message = "now" + new Date();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamOutput.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
