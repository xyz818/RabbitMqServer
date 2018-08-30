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
    public boolean addSTtype(String json) {
        try {
            JSONObject j = JSONObject.fromObject(json);
            sensortrantype s = (sensortrantype) JSONObject.toBean(j, sensortrantype.class);
            if (sttd.selSTCount(s) == 0) {
                if (sttd.addSTtype(s) > 0)
                    return true;
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return false;
    }
}
