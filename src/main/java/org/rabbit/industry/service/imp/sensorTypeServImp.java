package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.sensorTypeDao;
import org.rabbit.industry.model.sensorTypeInfo;
import org.rabbit.industry.service.sensorTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sensorTypeServImp implements sensorTypeServ {
    @Autowired
    sensorTypeDao std;

    /*
    *
    * 根据list格式化成json数组
    * */
    private String formatToJSON(List<sensorTypeInfo> list)
    {
        JSONArray js = new JSONArray();
        for(sensorTypeInfo s:list)
        {
//            JSONObject j = new JSONObject();
//            System.out.println(s.getSti_id()+","+s.getSti_name());

            js.add(JSONObject.fromObject(s));
        }
        return js.toString();
    }

    private sensorTypeInfo fomatToList(String Json)
    {

        JSONObject j = JSONObject.fromObject(Json);
        if(j.has("sti_id")) {
           sensorTypeInfo s = (sensorTypeInfo) JSONObject.toBean(j,sensorTypeInfo.class);
            return s;
        }

        return null;



    }


    @Override
    public String findSensorType() {
        List<sensorTypeInfo> list = std.findSensorType();
        return formatToJSON(list);
    }

    @Override
    public String findSensorTypeByControl(int control) {
        List<sensorTypeInfo> list = std.findSensorTypeByControl(control);
       return formatToJSON(list);
    }

    @Override
    public int addSensorType(String json) {
        int row = 0;
        sensorTypeInfo s = fomatToList(json);
        if(s!=null)
            row =std.addSensorType(s);
        return row;
    }

    @Override
    public String selSenTypeByTid(String tid,int control) {
        List<sensorTypeInfo> list = std.selSenTypeByTid(tid,control);
        return formatToJSON(list);
    }

}
