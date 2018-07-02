package org.rabbit.industry.service.imp;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.tranTypeDao;
import org.rabbit.industry.model.tranTypeInfo;
import org.rabbit.industry.service.tranTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tranTypeServImp implements tranTypeServ {
    @Autowired
    tranTypeDao ttd;

    @Override
    public String findTranType() {
        List<tranTypeInfo> list = ttd.findTranType();
        JSONArray js = new JSONArray();
        for (tranTypeInfo t : list) {
            JSONObject j = new JSONObject();
            j.put("tti_id", t.getTti_id());
            j.put("tti_name", t.getTti_name());
            js.add(j);
        }
        return js.toString();
    }

    @Override
    public int addTranType(String json) {
        int row = 0;
        try {
            tranTypeInfo t = new tranTypeInfo();
            JSONObject j = JSONObject.fromObject(json);
            if (j.has("tti_id")) {
                t.setTti_id(j.getString("tti_id"));
                if (j.has("tti_name"))
                    t.setTti_name(j.getString("tti_name"));

            }
            row = ttd.addTranType(t);

        } catch (Exception e) {
        }

        return row;
    }
}
