package org.rabbit.datamsg;


import net.sf.json.JSONObject;

public class JsonMessage {
    /*
    * json数据转javabean对象
    * */
    public static JsonModel JsonToModel(String json) {
        JsonModel jsonModel = new JsonModel();
        try {

            JSONObject jsonObject = JSONObject.fromObject(json);
            if (jsonObject.has("fromwhere"))
                jsonModel.setFromWhere(jsonObject.getString("fromwhere"));

            if (jsonObject.has("localid"))
                jsonModel.setLocalId(jsonObject.getString("localid"));

            if (jsonObject.has("targetid"))
                jsonModel.setTargetId(jsonObject.getString("targetid"));

            if (jsonObject.has("value"))
                jsonModel.setValue(jsonObject.getString("value"));

            if (jsonObject.has("nettype"))
                jsonModel.setNetType(jsonObject.getInt("nettype"));

            if (jsonObject.has("sensortype"))
                jsonModel.setSensorType(jsonObject.getInt("sensortype"));

            if (jsonObject.has("transtype"))
                jsonModel.setTranType(jsonObject.getString("transtype"));

            if (jsonObject.has("voltage"))
                jsonModel.setVoltage(jsonObject.getString("voltage"));

            if (jsonObject.has("func"))
                jsonModel.setFunc(jsonObject.getInt("func"));

        } catch (Exception e) {

        }
        return jsonModel;


    }


}
