package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.logicInfoDao;
import org.rabbit.industry.dao.projectInfoDao;
import org.rabbit.industry.model.projectinfo;
import org.rabbit.industry.service.projectInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class projectInfoServImp implements projectInfoServ {
    @Autowired
    projectInfoDao pid;

    @Autowired
    logicInfoDao lid;

    @Override
    public String findProJect() {
        List<projectinfo> list = pid.findProJect();
        JSONArray js = new JSONArray();
        for (projectinfo p : list) {
            js.add(JSONObject.fromObject(p));
        }
        return js.toString();
    }

    @Override
    public String findProjectByAccount(String id) {
        List<projectinfo> list = pid.findProjectByAccount(id);
        JSONArray js = new JSONArray();
        for (projectinfo p : list) {

            js.add(JSONObject.fromObject(p));
        }
        return js.toString();
    }

    @Override
    public boolean addProject(String json) {
        JSONObject j = JSONObject.fromObject(json);
        projectinfo p = (projectinfo) JSONObject.toBean(j, projectinfo.class);
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = timeFormat.format(new Date());
        p.setPi_time(time);
        if (pid.addProject(p) > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateProject(String json) {
        JSONObject j = JSONObject.fromObject(json);
        projectinfo p = (projectinfo) JSONObject.toBean(j, projectinfo.class);
        if (pid.updateProject(p) > 0)
            return true;
        return false;
    }

    @Override
    public boolean delProject(int p) {
        if (pid.delProject(p) > 0) {
           lid.deleteLogicByProject(p);//删除逻辑ｉｄ号
            return true;

        }
        return false;
    }

    @Override
    public String findProject(int id) {
        projectinfo p = pid.findProject(id);
        return JSONObject.fromObject(p).toString();
    }

    @Override
    public boolean updateProjectStatus(String json) {
        JSONObject js = JSONObject.fromObject(json);
        projectinfo p = (projectinfo) JSONObject.toBean(js,projectinfo.class);
        if(pid.updateProjectStatus(p) > 0)
            return true;
        return false;
    }
}
