package org.rabbit.industry.service.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.funcInfoDao;
import org.rabbit.industry.model.funcinfo;
import org.rabbit.industry.service.funcInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class funcInfoServImp implements funcInfoServ {
    @Autowired
    funcInfoDao fid;

    @Override
    public String findFuncType() {
        List<funcinfo> list = fid.findFuncType();
        JSONArray js = new JSONArray();
        for(funcinfo f:list)
        {
            js.add(JSONObject.fromObject(f));

        }
        return js.toString();
    }

    @Override
    public int addFuncType(String json) {
        int row = 0;
        try
        {
            JSONObject j = JSONObject.fromObject(json);
            funcinfo f = (funcinfo) JSONObject.toBean(j,funcinfo.class);
            row = fid.addFuncType(f);
        }catch (Exception e)
        {

        }
        return row;
    }
}
