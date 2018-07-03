package org.rabbit.industry.service.imp;

import net.sf.json.JSONObject;
import org.rabbit.industry.dao.senFuncDao;
import org.rabbit.industry.model.sensorfunc;
import org.rabbit.industry.service.senFuncServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class senFuncServImp implements senFuncServ {
    @Autowired
    senFuncDao sfd;

    @Override
    public int addSFtype(String json) {

        int row = 0;
        try {
            JSONObject j = JSONObject.fromObject(json);
            if (j.has("sti_id") && j.has("fui_id")) { //判断是否含有该字段
                sensorfunc sf = new sensorfunc();
                sf.setFui_id(j.getString("fui_id"));
                sf.setSti_id(j.getString("sti_id"));
                row = sfd.addSFtype(sf);
            }
        } catch (Exception e) {
        }
        return row;
    }
}
