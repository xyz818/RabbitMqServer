package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.senFuncInfoDao;
import org.rabbit.industry.model.sensorfuncinfo;
import org.rabbit.industry.service.sensorFuncInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class senorFuncInfoServImp implements sensorFuncInfoServ {

    @Autowired
    senFuncInfoDao sfid;

    @Override
    public boolean addSensorFuncInfo(String json) {
        JSONObject js = JSONObject.fromObject(json);
        sensorfuncinfo s = (sensorfuncinfo) JSONObject.toBean(js,sensorfuncinfo.class);
        if(sfid.addSensFuncInfo(s )> 0)
            return true;

        return false;
    }

    @Override
    public boolean delSensorFuncInfo(String json) {
        JSONObject js = JSONObject.fromObject(json);
        sensorfuncinfo s = (sensorfuncinfo) JSONObject.toBean(js,sensorfuncinfo.class);
        if(sfid.deleteSenFuncInfo(s )> 0)
            return true;
        return false;
    }

    @Override
    public boolean updateSensorFuncInfo(String json) {
        JSONObject js = JSONObject.fromObject(json);
        sensorfuncinfo s = (sensorfuncinfo) JSONObject.toBean(js,sensorfuncinfo.class);
        if(sfid.updateSenFuncInfo(s )> 0)
            return true;
        return false;
    }

    @Override
    public String selectFuncCode(String sid, String stid, String fuid) {
        sensorfuncinfo s = sfid.selFuncCode(sid,stid,fuid);
        if(s!=null)
            return s.getSfi_code();
        return "";
    }

    @Override
    public String selectFuncBySid(String sid) {
        JSONArray js = new JSONArray();
        List<sensorfuncinfo>  list = sfid.selFuncBySid(sid);
        for(sensorfuncinfo s: list)
        {
            js.add(JSONObject.fromObject(s));
        }
        return js.toString();
    }
}
