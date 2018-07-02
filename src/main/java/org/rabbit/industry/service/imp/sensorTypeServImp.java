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
            JSONObject j = new JSONObject();
            System.out.println(s.getSti_id()+","+s.getSti_name());
            j.put("sti_id",s.getSti_id());
            j.put("sti_name",s.getSti_name());
            j.put("sti_unit",s.getSti_unit());
            j.put("sti_control",s.getSti_control());
            js.add(j);
        }
        return js.toString();
    }

    private sensorTypeInfo fomatToList(String Json)
    {
        sensorTypeInfo s = new sensorTypeInfo();
        JSONObject j = JSONObject.fromObject(Json);
        if(j.has("sti_id")) {
            s.setSti_id(j.getString("sti_id"));
            if(j.has("sti_name"))
                s.setSti_name(j.getString("sti_name"));
            if(j.has("sti_control"))
                s.setSti_control((short) j.getInt("sti_control"));
            if(j.has("sti_unit"))
                s.setSti_unit(j.getString("sti_unit"));

        }
        else
            return null;
        return s;



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

}
