package org.rabbit.industry.controller;

import org.rabbit.industry.service.userserv;
import org.rabbit.mqtt.MqttMessage;
import org.rabbit.mqtt.MqttServerContext;
import org.rabbit.topicmq.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RabbitTest {

    /**
     * topic exchange类型rabbitmq测试
     */
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private userserv us;
    @Autowired
    private MqttMessage mqttMessage;

    @PostMapping("/sss")
    public void topicTest() {
        System.out.println("开始发送");
//        topicSender.send("topic.sql","nihao");
        MqttServerContext.getGateWay().sendToMqtt("nihao rabbit mq","/downstream/hello");

        int i = us.verify("admin","admin");
        System.out.println(String.valueOf(i));
    }

}
