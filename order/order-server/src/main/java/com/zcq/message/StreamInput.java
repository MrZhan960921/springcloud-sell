package com.zcq.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息接受
 * @author Maybeeeee
 * @date 2019-09-10 23:49
 */
public interface StreamInput {

    String INPUT = "input";

    String INPUT2 = "input2";

    @Input(INPUT)
    SubscribableChannel input();

    @Input(INPUT2)
    SubscribableChannel input2();
}
