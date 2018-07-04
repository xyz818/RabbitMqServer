package org.rabbit.topicmq;

import org.rabbit.datamsg.JsonMessage;
import org.rabbit.datamsg.JsonModel;
import org.rabbit.industry.service.proDeviceServ;
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

    @RabbitHandler
    public void process(String msg) {
        JsonModel jm = JsonMessage.JsonToModel(msg);//json格式信息转换
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式信息
        String deviceId = jm.getDeviceId();
        int proId = pds.selProjectIdByDeviceID(deviceId);
        if (proId > 0)
            System.out.println("topic.html  : 正在上传html信息");
    }

}
