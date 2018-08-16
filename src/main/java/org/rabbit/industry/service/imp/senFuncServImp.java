package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.senFuncDao;
import org.rabbit.industry.model.sensorfunc;
import org.rabbit.industry.service.senFuncServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class senFuncServImp implements senFuncServ {
    @Autowired
    senFuncDao sfd;

    @Override
    public boolean addSFtype(String json) {

        JSONObject js = JSONObject.fromObject(json);
        sensorfunc s = (sensorfunc) JSONObject.toBean(js,sensorfunc.class);
        if(sfd.addSFtype(s) > 0)
            return true;
        return false;
    }

    @Override
    public String selSensorFunc(String sid) {
        List<sensorfunc> list = sfd.selSensorFunc(sid);

        JSONArray j = new JSONArray();
        for(sensorfunc s : list)
            j.add(JSONObject.fromObject(s));
        return j.toString();
    }

    @Override
    public String selSensorFuncByFid(String sid, String fid) {
        sensorfunc s = sfd.selSensorFuncByFuncId(sid,fid);
        return JSONObject.fromObject(s).toString();
    }
}
