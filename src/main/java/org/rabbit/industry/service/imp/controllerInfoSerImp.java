package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.controllerInfoDao;
import org.rabbit.industry.model.controllerinfo;
import org.rabbit.industry.service.controllerInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class controllerInfoSerImp implements controllerInfoServ {

    @Autowired
    controllerInfoDao cid;

    @Override
    public String findControllerByProject(int pid) {
        JSONArray js = new JSONArray();
        List<controllerinfo> list = cid.findControllerByProject(pid);
        for (controllerinfo c : list) {
            js.add(JSONObject.fromObject(c));
        }
        return js.toString();
    }

    @Override
    public String findControllerByLogic(String lid) {


        JSONArray js = new JSONArray();
        List<controllerinfo> list = cid.findControllerByLogic(lid);
        for (controllerinfo c : list) {
            js.add(JSONObject.fromObject(c));
        }
        return js.toString();
    }

    @Override
    public String findControllerById(String id) {

        controllerinfo c = cid.findControllerById(id);

        return JSONObject.fromObject(c).toString();
    }

    @Override
    public boolean updateController(String json) {
        JSONObject js = JSONObject.fromObject(json);
        controllerinfo c = (controllerinfo) JSONObject.toBean(js,controllerinfo.class);
        if(cid.updateController(c) > 0)
            return true;
        return false;
    }
}
