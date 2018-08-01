package org.rabbit.topicmq;


import org.rabbit.datamsg.JsonMessage;
import org.rabbit.datamsg.JsonModel;
import org.rabbit.industry.model.historyrecord;
import org.rabbit.industry.service.historyServ;

import org.rabbit.industry.service.senInfoServ;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RabbitListener(queues = "topic.sql")
public class TopicRecSQL {
    @Autowired
    private historyServ hs;

    @Autowired
    private senInfoServ sis;  //实时更新传感器表中的数据值

    @RabbitHandler
    public void process(String msg) {
        try {
            System.out.println("topic.sql: 正在写入历史数据库信息0------------------");
            JsonModel jm = JsonMessage.JsonToModel(msg);//json格式信息转换
            if (jm != null) {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式信息
                String time = sf.format(new Date());//获取当天的时间信息

//        String deviceId = jm.getDeviceId();
//        int proId = pds.selProjectIdByDeviceID(deviceId);
//        if(proId>0)
                //判断ｄａｔａ数据中的ｖａｌｕｅ值是否为空，不为空则插入数据
                if (jm.getData().has("value") && !jm.getData().getString("value").equals("")) {
                    //历史记录信息组包
                    historyrecord hr = new historyrecord(jm.getDeviceId(), jm.getSensorId(), Timestamp.valueOf(time), jm.getData().getString("value"));
                    //保存历史记录信息
                    if (hs.saveHistory(hr)) {
                        System.out.println("历史数据库更新成功");
                        if (sis.updateSensorValue(jm.getData().getString("value"), jm.getSensorId()))
                            System.out.println("传感器数据库更新成功");
                    }
//        mqttMessage.sendMsg("/downstream/hello","recive from cloud");
                    System.out.println("结束写入数据库流程----------------------------------");
                    System.out.println("\n");
                }
            }
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("无效的数据流");
        }
    }

}