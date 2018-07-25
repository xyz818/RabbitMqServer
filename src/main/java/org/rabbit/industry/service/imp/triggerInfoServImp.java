package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.triggerInfoDao;
import org.rabbit.industry.model.triggerinfo;
import org.rabbit.industry.service.triggerInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class triggerInfoServImp implements triggerInfoServ {
    @Autowired
    triggerInfoDao tid;

    @Override
    public String findTriggerInfoByProject(int pid) {
        JSONArray js = new JSONArray();
        List<triggerinfo> list = tid.findTriggerByProject(pid);
        for (triggerinfo t : list) {
            js.add(JSONObject.fromObject(t));
        }
        return js.toString();
    }

    @Override
    public String findTriggerByLogic(String lid) {
        JSONArray js = new JSONArray();
        List<triggerinfo> list = tid.findTriggerByLogic(lid);
        for (triggerinfo t : list) {
            js.add(JSONObject.fromObject(t));
        }
        return js.toString();
    }

    @Override
    public String findTriggerById(int id) {

        triggerinfo t = tid.findTriggerById(id);
        return JSONObject.fromObject(t).toString();
    }

    @Override
    public boolean updateTrigger(String json) {
        JSONObject js = JSONObject.fromObject(json);
        triggerinfo t = (triggerinfo) JSONObject.toBean(js, triggerinfo.class);
        if (tid.updateTrigger(t) > 0)
            return true;

        return false;
    }

    @Override
    public String findTriggerBySid(String sid) {
        triggerinfo t = tid.findTriggerBySid(sid);
        return JSONObject.fromObject(t).toString();
    }
}
