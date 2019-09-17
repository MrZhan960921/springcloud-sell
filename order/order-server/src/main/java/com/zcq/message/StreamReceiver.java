package com.zcq.message;

import com.zcq.model.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * stream消息接受
 *
 * @author Maybeeeee
 * @date 2019-09-10 22:16
 */
@Component
@Slf4j
public class StreamReceiver {

    /**
     * 接受orderDTO对象,并回送一个消息
     * @param message
     */
    @StreamListener(StreamInput.INPUT)
    @SendTo(StreamInput.INPUT2)
    public String process(OrderDTO message) {
        log.info("StreamReceiver:{}", message);
        return "reseived.";
    }

    @StreamListener(StreamInput.INPUT2)
    public void process2(String message) {
        log.info("StreamReceiver2:{}", message);
    }
}
