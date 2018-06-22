package org.rabbit.topicmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.link")
public class TopicRecLink {
    @RabbitHandler
    public void process(String msg) {

        System.out.println("topic.link  : " + "正在处理联动信息");
    }
}
