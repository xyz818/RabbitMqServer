package org.rabbit.topicmq;

import org.rabbit.datamsg.JsonMessage;
import org.rabbit.datamsg.JsonModel;
import org.rabbit.industry.service.proDeviceServ;
import org.rabbit.mqtt.MqttMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/*
 * 如果是tcp链接,转发通过Ｍｑｔｔ转发
 *
 *
 * */
@Component
@RabbitListener(queues = "topic.html")
public class TopicRecToHtml {
    @Autowired
    private proDeviceServ pds;
    @Autowired
    MqttMessage mqttMessage;

    @RabbitHandler
    public void process(String msg) {
        try {
//        System.out.println("数据发送给页面--------------------------");
            JsonModel jm = JsonMessage.JsonToModel(msg);//json格式信息转换
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式信息
            //获取设备号
            String deviceId = jm.getDeviceId();
//        System.out.println("deviceId:"+deviceId);
            //根据设备号查询项目名称
            int proId = pds.selProjectIdByDeviceID(deviceId);
//        System.out.println("项目id:"+proId);
            if (proId > 0) {

                mqttMessage.sendMsg("/uptohtml/" + proId, msg);
//            System.out.println("数据发送给页面结束------------------------------");
            }
        }
        catch (Exception e)
        {
        }
    }

}
