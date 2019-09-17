package com.zcq.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 消息生产
 * @author Maybeeeee
 * @date 2019-09-10 23:50
 */
public interface StreamOutput {

    String OUTPUT = "output";

    @Output(OUTPUT)
    MessageChannel output();
}
