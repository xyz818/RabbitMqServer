package org.rabbit.industry.service.imp;

import io.netty.handler.codec.json.JsonObjectDecoder;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.logicInfoDao;
import org.rabbit.industry.model.logicinfo;
import org.rabbit.industry.service.logicInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class logicInfoServImp implements logicInfoServ {
    @Autowired
    logicInfoDao lid;


    @Override
    public String findLogicByProject(int pid) {
        JSONArray js = new JSONArray();
        try {
            List<logicinfo> list = lid.findLogicByProject(pid);
            for (logicinfo l : list) {
                js.add(JSONObject.fromObject(l));
            }
        } catch (Exception e) {
        }
        return js.toString();
    }

    @Override
    public String findLogicById(String id) {

        logicinfo l = lid.findLogicById(id);
        return JSONObject.fromObject(l).toString();
    }

    @Override
    public boolean addLogic(String json) {
        JSONObject j = JSONObject.fromObject(json);
        logicinfo l = (logicinfo) JSONObject.toBean(j, logicinfo.class);
        if (lid.addLogic(l) > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateLogicStatus(String json) {
        JSONObject j = JSONObject.fromObject(json);
        logicinfo l = (logicinfo) JSONObject.toBean(j, logicinfo.class);
        if (lid.updateLogicStatus(l) > 0)
            return true;
        return false;

    }

    @Override
    public boolean deleteLogic(String id) {
        if (lid.deleteLogic(id) > 0)
            return true;
        return false;
    }

    /**
     * @param pid@author 　xuyongzhe
     * @brief 根据项目删除逻辑id号
     **/
    @Override
    public boolean deleteLogicByPid(int pid) {
        if(lid.deleteLogicByProject(pid) >  0)
            return true;
        return false;
    }
}
