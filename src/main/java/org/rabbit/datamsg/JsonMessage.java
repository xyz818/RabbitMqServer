package org.rabbit.datamsg;


import net.sf.json.JSONObject;

public class JsonMessage {
    /*
    * json数据转javabean对象
    * */
    public static JsonModel JsonToModel(String json) {
        JsonModel jsonModel = null;
        try {

            JSONObject js = JSONObject.fromObject(json);
            if(js.has("deviceId") && js.has("sensorId") && js.has("key"))
            {
                jsonModel = new JsonModel();
                jsonModel.setKey(js.getString("key"));
                jsonModel.setDeviceId(js.getString("deviceId"));
                jsonModel.setSensorId(js.getString("sensorId"));

                if(js.has("code"))
                    jsonModel.setCode(js.getString("code"));
                if(js.has("data"))
                    jsonModel.setData(js.getJSONObject("data"));
                if(js.has("connecttype"))
                    jsonModel.setConnecttype(js.getString("connecttype"));
                if(js.has("trantype"))
                    jsonModel.setTrantype(js.getString("trantype"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonModel;


    }


}
