package org.rabbit.mqtt;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MyGateWay
{
    //发送消息管道
    void  sendToMqtt(String data,@Header(MqttHeaders.TOPIC)String topic);
}

