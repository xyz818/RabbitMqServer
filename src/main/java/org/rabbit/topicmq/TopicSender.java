package org.rabbit.topicmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send(String topic,String msg1) {
//        String msg1 = "I am topic.mesaage msg======";
        System.out.println("sender :rabbitmq数据已经发送给队列 ");
        this.rabbitTemplate.convertAndSend("exchange", topic, msg1);
//        String msg2 = "I am topic.mesaages msg########";
//        System.out.println("sender2 : " + msg2);
//        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg2);
    }

}