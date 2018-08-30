package org.rabbit.mqtt;

import org.rabbit.topicmq.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqttMessage {


    @Autowired
    private TopicSender topicSender;


//    private static MqttMessage instance = new MqttMessage();
//
//    public static MqttMessage getInstance() {
//        return instance;
//    }

    /*
     * 接受mqtt消息函数
     * topic 主题
     * message 消息
     * */
    public void recieveMsg(Object topic, Object message) {
        String strTopic = topic.toString();
//        System.out.println(strTopic + ":" + message.toString());

        if (strTopic.indexOf("/upstream") == 0) //来自底层硬件的数据流上传
        {
            //发送给数据库主题处理，写入历史数据库中
            topicSender.send("topic.sql", message.toString());
            //发送给数据库联动处理，处理相关决策信息
            topicSender.send("topic.html", message.toString());

            topicSender.send("topic.link", message.toString());
        } else if (strTopic.indexOf("/downstream") == 0) {//来自上层消息控制
        }

    }

    /*
     * 发送mqtt消息类
     * topic 主题
     * message 消息
     * */
    public boolean sendMsg(String topic, String message) {
        try {
//            System.out.println("消息发送");
            //发送mqtt消息
            MqttServerContext.getGateWay().sendToMqtt(message, topic);
        } catch (Exception e) {
//            System.out.println("error");
            e.printStackTrace();
            return false;
        }
        return true;
    }


}









