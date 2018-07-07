package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.projectTypeDao;
import org.rabbit.industry.model.projecttype;
import org.rabbit.industry.service.projectTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class projectTypeServImp implements projectTypeServ {
    @Autowired
    projectTypeDao ptd;
    @Override
    public String findPorjectType() {

        JSONArray js = new JSONArray();
        try
        {
            List<projecttype> list = ptd.findProjectType();
            for(projecttype p:list)
                js.add(JSONObject.fromObject(p));
        }catch (Exception e)
        {

        }
        return js.toString();
    }

    @Override
    public boolean addProjectType(String json) {
        JSONObject js = JSONObject.fromObject(json);
        projecttype p = (projecttype) JSONObject.toBean(js,projecttype.class);
        if(ptd.addProjectType(p) > 0)
            return true;
        return false;
    }
}
