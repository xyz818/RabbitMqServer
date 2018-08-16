package org.rabbit.industry.service.imp;

import net.sf.json.JSONObject;
import org.rabbit.industry.dao.senTranTypeDao;
import org.rabbit.industry.model.sensortrantype;
import org.rabbit.industry.service.senTranTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class senTranTypeServImp implements senTranTypeServ {
    @Autowired
    senTranTypeDao sttd;

    @Override
    public int addSTtype(String json) {
        int row = 0;
        try {
            JSONObject j = JSONObject.fromObject(json);

            if (j.has("sti_id") && j.has("tti_id")) {
                sensortrantype s = new sensortrantype();
                s.setSti_id(j.getString("sti_id"));
                s.setTti_id(j.getString("tti_id"));
                row = sttd.addSTtype(s);
            }
        } catch (Exception e) {
        }
        return row;
    }
}
