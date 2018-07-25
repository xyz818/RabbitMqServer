package org.rabbit.topicmq;

import net.sf.json.JSONObject;
import org.rabbit.datamsg.JsonMessage;
import org.rabbit.datamsg.JsonModel;
import org.rabbit.industry.service.controllerInfoServ;
import org.rabbit.industry.service.senInfoServ;
import org.rabbit.industry.service.triggerInfoServ;
import org.rabbit.mqtt.MqttMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.link")
public class TopicRecLink {

    @Autowired
    private senInfoServ sis;

    @Autowired
    private triggerInfoServ tis;

    @Autowired
    private controllerInfoServ cis;

    @Autowired
    MqttMessage mqttMessage;


    @RabbitHandler
    public void process(String msg) {
        JsonModel jm = JsonMessage.JsonToModel(msg);//json格式信息转换
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式信息
        String sensorId = jm.getSensorId();  //采集类传感器
        String deviceId = jm.getDeviceId();
        String cjson = cis.findControllerByTrigId(sensorId); //获取执行传感器

        if (!cjson.equals("null")) {
            JSONObject cjs = JSONObject.fromObject(cjson);
            jm.setSensorId(cjs.getString("sei_id"));
            String sensor = sis.findSensorById(cjs.getString("sei_id"));
            JSONObject sjs = JSONObject.fromObject(sensor);
            //判断当前逻辑是否开启
            if (cjs.getInt("li_status") == 1) {
                //判断当前传感器的状态是否和数据库中要控制的状态一致,如果一致,不需要发送命令,不一致,发送命令
                if (!sjs.getString("sei_value").equals(cjs.getString("coi_value"))) {
                    String tjson = tis.findTriggerBySid(sensorId);
                    JSONObject tjs = JSONObject.fromObject(tjson);
                    boolean isOK = false;
                    float realValue = Float.parseFloat(jm.getData().getString("value"));
                    float sqlValue = Float.parseFloat(tjs.getString("tri_value"));
                    switch (tjs.getInt("tri_limit")) {
                        case 0: //>
                            if (realValue > sqlValue)
                                isOK = true;
                            break;
                        case 1://=
                            if (realValue == sqlValue)
                                isOK = true;
                            break;
                        case 2://<
                            if (realValue < sqlValue)
                                isOK = true;
                            break;
                    }
                    if (isOK) {
                        JSONObject data = new JSONObject();
                        data.put("func", cjs.getString("coi_value"));
                        jm.setData(data);
                        if (jm.getConnecttype().equals("MQTT")) {
                            mqttMessage.sendMsg("/downstream/" + deviceId, JSONObject.fromObject(jm).toString());
                        }
                    }
                }
            }
        }

        System.out.println("topic.link  : " + "正在处理联动信息");
    }
}
