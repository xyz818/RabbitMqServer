package org.rabbit.industry.service.imp;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.rabbit.industry.dao.accountDao;
import org.rabbit.industry.model.accountinfo;
import org.rabbit.industry.service.accountServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class accountServImp implements accountServ {
    @Autowired
    accountDao ad;

    @Override
    public boolean verifyLogin(String json) {
        try {
            JSONObject j = JSONObject.fromObject(json);
            if (j.has("aci_id") && j.has("aci_pwd"))
                if (ad.verify(j.getString("aci_id"), j.getString("aci_pwd")) > 0)//判断数据库中行数是否大于０
                    return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean updateAccount(String json) {
        try {
            JSONObject j = JSONObject.fromObject(json);
            if (j.has("aci_id") && j.has("aci_code") && j.has("aci_phone")) {
                accountinfo a = (accountinfo) JSONObject.toBean(j, accountinfo.class);
                if (ad.updateAccount(a) > 0)
                    return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean updatePwsd(String json) {
        try {
            JSONObject j = JSONObject.fromObject(json);
            if (j.has("aci_id") && j.has("aci_pwd")) {
                accountinfo a = (accountinfo) JSONObject.toBean(j, accountinfo.class);
                if (ad.updatePwsd(a) > 0)
                    return true;
            }
        } catch (Exception e) {

        }


        return false;
    }


    @Override
    public String findAccount() {
        List<accountinfo> list = ad.findAccount();
        JSONArray js = new JSONArray();
        for (accountinfo a : list)   //遍历数据库
            js.add(JSONObject.fromObject(a));
        return js.toString();
    }

    @Override
    public String findAccount(String sid) {
        List<accountinfo> list = ad.findAccount(sid);
        JSONArray js = new JSONArray();
        for (accountinfo a : list)   //遍历数据库
            js.add(JSONObject.fromObject(a));
        return js.toString();
    }

    @Override
    public String findAccountByAid(String aid) {
        accountinfo a = ad.findAccountByAid(aid);

        JSONObject j = JSONObject.fromObject(a);
        return j.toString();
    }

    @Override
    public boolean addAccountInfo(String json) {

        try {
            JSONObject j = JSONObject.fromObject(json);
            accountinfo a = (accountinfo) JSONObject.toBean(j, accountinfo.class);
            if (ad.addAccountInfo(a) > 0)
                return true;

        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public boolean delAccountInfo(String aid) {
        if(ad.delAccountInfo(aid) > 0)
            return true;
        return false;
    }

    /**
     * @param role@author 　xuyongzhe
     * @brief 根据权限查询
     **/
    @Override
    public String findAccountByRole(int role) {
        JSONArray js = new JSONArray();
        List<accountinfo> list = ad.findAccountByRole(role);
        for(accountinfo a : list)
        {
            js.add(JSONObject.fromObject(a));
        }
        return js.toString();
    }

    /**
     * @param scid
     * @param role
     * @author　xuyongzhe
     * @brief 根据权限查询
     **/
    @Override
    public String findAccountByScAndRole(String scid, int role) {
        JSONArray js = new JSONArray();
        List<accountinfo> list = ad.findAccountByScAndRole(scid,role);
        for(accountinfo a : list)
        {
            js.add(JSONObject.fromObject(a));
        }
        return js.toString();
    }
}
