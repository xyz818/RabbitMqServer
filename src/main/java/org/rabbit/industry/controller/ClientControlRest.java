package org.rabbit.industry.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.rabbit.mqtt.MqttMessage;
import org.rabbit.topicmq.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClientControlRest {

    /**
     * topic exchange类型rabbitmq测试
     */
    @Autowired
    private TopicSender topicSender;

    @Autowired
    private MqttMessage mqttMessage;

    @ApiOperation(value = "页面控制传感器", notes = "页面控制传感器")
    @RequestMapping(value = "/cmds", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "数据json", required = true, dataType = "String")
    })
    @ResponseBody
    public boolean cmdSend(@RequestBody  String json) {
        System.out.println("开始发送");
//        topicSender.send("topic.sql","nihao");
//        MqttServerContext.getGateWay().sendToMqtt("nihao rabbit mq","/downstream/hello");
        try {
            System.out.println(json);
            JSONObject js = JSONObject.fromObject(json);
            if (js.has("connecttype")) {
                if (js.getString("connecttype").equals("MQTT")) {   //如果链接方式为ｍｑｔｔ方式,采用一下发送方式
                    System.out.println("connecttype");
                    if (js.has("deviceId")) {
                        System.out.println("deviceId");
                        mqttMessage.sendMsg("/downstream/" + js.getString("deviceId"), json);
                        return true;
                    }
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
