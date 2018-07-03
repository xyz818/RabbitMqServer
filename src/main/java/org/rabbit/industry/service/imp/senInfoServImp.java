package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.sensorInfoDao;
import org.rabbit.industry.model.sensorinfo;
import org.rabbit.industry.service.senInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class senInfoServImp implements senInfoServ {
    @Autowired
    sensorInfoDao sid;

    @Override
    public String findSensorByDevice(String id) {
        List<sensorinfo> list = sid.findSensorByDevice(id);
        JSONArray js = new JSONArray();
        for(sensorinfo s:list)
        {
            JSONObject j = new JSONObject();
            j.put("sei_seq",s.getSei_seq());
            j.put("sei_id",s.getSei_id());
            j.put("sti_id",s.getSti_id());
            j.put("tti_id",s.getTti_id());
            j.put("sei_value",s.getSei_value());
            j.put("sei_mac",s.getSei_mac());
            j.put("sti_name",s.getSti_name());
            j.put("tti_name",s.getTti_name());
            js.add(j);
        }

        return js.toString();
    }
}
