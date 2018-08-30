package org.rabbit.industry.service.imp;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.imp.devSenImp;
import org.rabbit.industry.dao.senFuncInfoDao;
import org.rabbit.industry.dao.sensorInfoDao;
import org.rabbit.industry.model.sensorfuncinfo;
import org.rabbit.industry.model.sensorinfo;
import org.rabbit.industry.service.senInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class senInfoServImp implements senInfoServ {
    @Autowired
    sensorInfoDao sid;

    @Autowired
    devSenImp dsi;

    @Autowired
    senFuncInfoDao sfid;

    @Override
    public String findSensorByDevice(String id) {
        List<sensorinfo> list = sid.findSensorByDevice(id);
        JSONArray js = new JSONArray();
        for (sensorinfo s : list) {
            js.add(JSONObject.fromObject(s));
        }
        return js.toString();
    }


    @Override
    public String findSensorById(String id) {
        JSONObject j = new JSONObject();
        try {
            sensorinfo s = sid.findSensorById(id);
            if (s != null)
                j = JSONObject.fromObject(s);
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
                    js.add(JSONObject.fromObject(s));
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
            JSONObject js = JSONObject.fromObject(json);
            sensorinfo s = (sensorinfo) JSONObject.toBean(js, sensorinfo.class);  //json转sensorinfo对象
            if (s != null)
                if (sid.addSensor(s) > 0)
                    row = dsi.saveDevSenor(s.getDi_id(), s.getSei_id());  //添加到关联表信息
        } catch (Exception e) {
        }
        return row;
    }

    @Override
    public boolean updateSensor(String json) {
        try {
            JSONObject js = JSONObject.fromObject(json);
            sensorinfo s = (sensorinfo) JSONObject.toBean(js, sensorinfo.class);  //json转sensorinfo对象
            if (s != null)
                if (sid.updateSensor(s) > 0)
                    return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean deleteSensor(String id) {
        try {
            if (sid.deleteSensor(id) > 0)
                if (dsi.delDevSenor(id) > 0)
                    return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public String findSensorByProject(int pid) {
        List<sensorinfo> list = sid.findSensorByProject(pid);
        JSONArray js = new JSONArray();
        for (sensorinfo s : list) {
            js.add(JSONObject.fromObject(s));
        }
        return js.toString();
    }

    /**
     * @param value 数值
     * @param id
     * @author　xuyongzhe
     * @brief 更新传感器信息数据值
     **/
    @Override
    public boolean updateSensorValue(String value, String id) {
        if (sid.updateSensorValue(value, id) > 0)
            return true;
        return false;
    }

    @Override
    public String findSensorByDeviceOnAndroid(String did) {
        List<sensorinfo> slist = sid.findSensorByDevice(did);
        JSONArray js = new JSONArray();
        for (sensorinfo s : slist) {
            JSONObject jsen = JSONObject.fromObject(s);//传感器的ｊｓｏｎ数据
            List<sensorfuncinfo> sfList = sfid.selFuncBySid(s.getSei_id());
            JSONArray j = new JSONArray();
            for (sensorfuncinfo f : sfList) {
                JSONObject func = JSONObject.fromObject(f);
                func.remove("sei_id");
                func.remove("sf_seq");
                func.remove("sfi_seq");
                j.add(func);
            }
            jsen.put("funcs", j);
            js.add(jsen);
        }

        return js.toString();
    }

    /**
     * @param id
     * @author 　xuyongzhe
     * @brief 通过传感器ｉｄ查询设备功能
     **/
    @Override
    public String findSensorBySidAndFunc(String id) {


        sensorinfo s = sid.findSensorById(id);
        JSONObject js = JSONObject.fromObject(s);
        if (s != null) {
            JSONArray j = new JSONArray();
            List<sensorfuncinfo> sfList = sfid.seleFuncs(s.getSei_id());

            for (sensorfuncinfo sf : sfList) {
                JSONObject jsonObject = JSONObject.fromObject(sf);
                jsonObject.remove("sei_id");
                jsonObject.remove("sf_seq");
                jsonObject.remove("sfi_seq");
                j.add(jsonObject);
            }
            js.put("funcs", j.toString());

        }
        return js.toString();
    }
}
