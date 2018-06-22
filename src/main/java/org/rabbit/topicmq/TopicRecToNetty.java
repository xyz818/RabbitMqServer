package org.rabbit.topicmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.netty")
public class TopicRecToNetty {

    @RabbitHandler
    public void process(String msg) {

        System.out.println("topic.netty  : 正在处理来自手机端信息" );
    }



}
