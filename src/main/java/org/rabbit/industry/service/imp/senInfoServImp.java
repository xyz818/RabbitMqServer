package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.sensorInfoDao;
import org.rabbit.industry.model.sensorinfo;
import org.rabbit.industry.service.senInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class senInfoServImp implements senInfoServ {
    @Autowired
    sensorInfoDao sid;

    @Override
    public String findSensorByDevice(String id) {
        List<sensorinfo> list = sid.findSensorByDevice(id);
        JSONArray js = new JSONArray();
        for (sensorinfo s : list) {
            js.add(formatToObject(s));
        }

        return js.toString();
    }

    /**
     * @brief 传感器类转json对象
     */
    private JSONObject formatToObject(sensorinfo s) {
        JSONObject j = new JSONObject();
        j.put("sei_seq", s.getSei_seq());
        j.put("sei_id", s.getSei_id());
        j.put("sti_id", s.getSti_id());
        j.put("tti_id", s.getTti_id());
        j.put("sei_value", s.getSei_value());
        j.put("sei_mac", s.getSei_mac());
        j.put("sti_name", s.getSti_name());
        j.put("tti_name", s.getTti_name());

        return j;
    }

    /**
     * @brief json数据转传感器对象
     */
    private sensorinfo formatToSensorInfo(String json) {
        try {
            JSONObject j = JSONObject.fromObject(json);
            if (j.has("sei_id") && j.has("sti_id") && j.has("tti_id")) {
                sensorinfo s = new sensorinfo();
                s.setSei_id(j.getString("sei_id"));
                s.setSti_id(j.getString("sti_id"));
                s.setTti_id(j.getString("tti_id"));
                if (j.has("sei_mac"))
                    s.setSei_mac(j.getString("sei_mac"));
                if (j.has("sei_value"))
                    s.setSei_value(j.getString("sei_value"));
                return s;
            }

        } catch (Exception e) {
        }
        return null;


    }


    @Override
    public String findSensorById(String id) {
        JSONObject j = new JSONObject();
        try {
            sensorinfo s = sid.findSensorById(id);
            if (s != null)
                j = formatToObject(s);
        } catch (Exception e) {
        }
        return j.toString();
    }

    @Override
    public String findSensorByControl(String json) {
        JSONArray js = new JSONArray();
        try {
            JSONObject j = JSONObject.fromObject(json);
            //判断是否含有该有的json字段信息
            if (j.has("di_id") && j.has("sti_control")) {
                List<sensorinfo> list = sid.findSensorByControl(j.getString("di_id"), j.getInt("sti_control"));
                for (sensorinfo s : list) {
                    js.add(formatToObject(s));
                }
            }
        } catch (Exception e) {
        }
        return js.toString();
    }

    @Override
    public int addSensor(String json) {
        int row = 0;
        try {
            sensorinfo s = formatToSensorInfo(json);  //json转sensorinfo对象
            if (s != null)
                row = sid.addSensor(s);
        } catch (Exception e) {
        }
        return row;
    }

    @Override
    public boolean updateSensor(String json) {
        try {
            sensorinfo s = formatToSensorInfo(json);//json转sensorinfo对象
            if (s != null)
                if (sid.updateSensor(s) > 0)
                    return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean deleteSensor(String id) {

        try
        {
          if(sid.deleteSensor(id) > 0)
              return true;
        }
        catch (Exception e)
        {}
        return false;
    }
}
