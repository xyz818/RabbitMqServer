package org.rabbit.topicmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/*
* 如果是tcp链接,转发通过Ｍｑｔｔ转发
*
*
* */
@Component
@RabbitListener(queues = "topic.html")
public class TopicRecToHtml {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("topic.html  : 正在上传html信息" );
    }

}
