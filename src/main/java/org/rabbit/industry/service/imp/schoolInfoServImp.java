package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.schoolInfoDao;
import org.rabbit.industry.model.schoolinfo;
import org.rabbit.industry.service.schoolInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class schoolInfoServImp implements schoolInfoServ {

    @Autowired
    schoolInfoDao sid;

    @Override
    public boolean addSchoolInfo(String json) {
        JSONObject js = JSONObject.fromObject(json);
        schoolinfo s = (schoolinfo) JSONObject.toBean(js,schoolinfo.class);
        if(sid.addSchool(s)> 0)
            return true;
        return false;
    }

    @Override
    public boolean delScholl(String json) {
        JSONObject j= JSONObject.fromObject(json);
        schoolinfo s = (schoolinfo) JSONObject.toBean(j,schoolinfo.class);
        if(sid.delScholl(s) > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateSchool(String json) {
        JSONObject j= JSONObject.fromObject(json);
        schoolinfo s = (schoolinfo) JSONObject.toBean(j,schoolinfo.class);
        if(sid.updateSchool(s) > 0)
            return true;
        return false;
    }

    @Override
    public String findSchool() {
        JSONArray js = new JSONArray();
        List<schoolinfo> list  = sid.findSchool();
        for(schoolinfo s:list)
        {
            js.add(JSONObject.fromObject(s));
        }
        return js.toString();
    }

    @Override
    public String findSchoolById(String id) {
        schoolinfo s = sid.findSchoolById(id);
        return  JSONObject.fromObject(s).toString();
    }
}
