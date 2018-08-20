package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.devSenDao;
import org.rabbit.industry.dao.historyDao;
import org.rabbit.industry.model.historyrecord;
import org.rabbit.industry.service.historyServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class HistoryServImp implements historyServ {

    @Autowired
    private historyDao hd;

    @Autowired
    private devSenDao dsd;

    @Override
    public boolean saveHistory(historyrecord hi) {
        if (dsd.selSeqByDevSenId(hi.getDi_id(), hi.getSei_id()) > 0)
            if (hd.saveHistory(hi) > 0)
                return true;
        return false;
    }

    @Override
    public String findHistroyByTime(String json) {

        JSONArray js = new JSONArray();
        try {
            JSONObject j = JSONObject.fromObject(json);
            List<historyrecord> list = hd.findHistroyInfo(j.getInt("pi_seq"),
                    j.getString("sei_id"), j.getString("startTime"), j.getString("endTime"));
            for (historyrecord h : list) {
                //h.getHr_time()
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                System.out.println(sdf.format(h.getHr_time()));
//                h.setHr_time(Timestamp.valueOf(sdf.format(h.getHr_time())));
                js.add(JSONObject.fromObject(h));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return js.toString();
    }
}
