package org.rabbit.topicmq;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.rabbit.datamsg.JsonMessage;
import org.rabbit.datamsg.JsonModel;
import org.rabbit.industry.service.*;
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

    @Autowired
    private funcInfoServ fis;

    @Autowired
    private sensorFuncInfoServ sfis;

    @RabbitHandler
    public void process(String msg) {
        try {
//            System.out.println("处理联动数据中----------------------------------------");
            JsonModel jm = JsonMessage.JsonToModel(msg);//json格式信息转换
            if (jm != null) {//判断数据是否完整，不完整不进行
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式信息
                String sensorId = jm.getSensorId();  //采集类传感器
                String deviceId = jm.getDeviceId();
                String cjson = cis.findControllerByTrigId(sensorId); //获取执行传感器
//                System.out.println("cjson:" + cjson);
                if (!cjson.equals("null")) {
//                    System.out.println("json部位空,进入后台开始");
                    JSONObject cjs = JSONObject.fromObject(cjson);
                    jm.setSensorId(cjs.getString("sei_id"));
                    String sensor = sis.findSensorById(cjs.getString("sei_id"));
                    JSONObject sjs = JSONObject.fromObject(sensor);
                    //判断当前逻辑是否开启
                    if (cjs.getInt("li_status") == 1) {
//                        System.out.println("状态为1进入");
                        //判断当前传感器的状态是否和数据库中要控制的状态一致,如果一致,不需要发送命令,不一致,发送命令
                        if (!sjs.getString("sei_value").equals(cjs.getString("coi_value"))) {
//                            System.out.println("当前的状态不一致");
                            String tjson = tis.findTriggerBySid(sensorId);
                            JSONObject tjs = JSONObject.fromObject(tjson);
                            boolean isOK = false;
                            //查询是否航油ｖａｌｕｅ值和ｖａｌｕｅ值是否部位空
                            if (jm.getData().has("value") && !jm.getData().getString("value").equals("")) {
                                float realValue = Float.parseFloat(jm.getData().getString("value"));//真实value值
                                float sqlValue = Float.parseFloat(tjs.getString("tri_value"));//数据库中的预设值
                                switch (tjs.getInt("tri_limit")) {    //条件查询
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
                                if (isOK) {//条件是否达成
//                                    System.out.println("条件达成发送控制");
                                    JSONObject data = new JSONObject();
                                    String fuid = fis.selFuncByValue(cjs.getString("coi_value"));//查询功能号
                                    //根据传感器的标识码和类型和功能码来查询是否含有功能码
                                    String fcode = sfis.selectFuncCode(jm.getSensorId(), sjs.getString("sti_id"), fuid);
                                    data.put("func", fuid);//控制执行值
                                    if (!fcode.equals("") && !fcode.equals("{}"))//判断码是否为空，若为空，则不进行添加
                                    {
                                        JSONObject jfcode = JSONObject.fromObject(fcode);
                                        data.put("funcCode", jfcode.getString("sfi_code"));
                                    }
                                    jm.setData(data);
                                    String strSensor = sis.findSensorById(jm.getSensorId());   //获取传感器的类
                                    JSONObject sjon = JSONObject.fromObject(strSensor);   //传感器的json包
                                    jm.setCode(sjon.getString("sei_mac"));   //控制器的code码
                                    jm.setTrantype(sjon.getString("tti_id")); //传输类型id
                                    if (jm.getConnecttype().equals("MQTT")) {
//                                        System.out.println("MQTT发送给设备端:" + deviceId);
                                        mqttMessage.sendMsg("/downstream/" + deviceId, JSONObject.fromObject(jm).toString());
                                    }
                                }
                            }
                        }
                    }
                }

//                System.out.println("topic.link  : " + "处理联动信息结束----------------------------");
//                System.out.println("\n");
            }
        } catch (Exception e) {

        }
    }
}
