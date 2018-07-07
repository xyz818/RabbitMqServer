package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.deviceInfoDao;
import org.rabbit.industry.model.deviceinfo;
import org.rabbit.industry.service.deviceInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class deviceInfoServImp implements deviceInfoServ {
    @Autowired
    deviceInfoDao dvi;
    @Override
    public String findDeivceByProject(int pid) {
        JSONArray js = new JSONArray();
        try
        {
            List<deviceinfo>  list = dvi.findDeivceByProject(pid);
            for(deviceinfo d : list)
                js.add(JSONObject.fromObject(d));
        }catch (Exception e)
        {}
        return js.toString();
    }

    @Override
    public String findDeviceById(String did) {
        return JSONObject.fromObject(dvi.findDeviceById(did)).toString();
    }

    @Override
    public boolean addDevice(String json) {
        JSONObject j = JSONObject.fromObject(json);
        deviceinfo d = (deviceinfo) JSONObject.toBean(j, deviceinfo.class);
        if( dvi.addDevice(d) > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateDevice(String json) {

        JSONObject j = JSONObject.fromObject(json);
        deviceinfo d = (deviceinfo) JSONObject.toBean(j, deviceinfo.class);
        if( dvi.updateDevice(d) > 0)
            return true;
        return false;
    }

    @Override
    public boolean deleteDevice(String did) {
       if(dvi.deleteDevice(did) > 0)
           return true;
       return false;
    }
}
