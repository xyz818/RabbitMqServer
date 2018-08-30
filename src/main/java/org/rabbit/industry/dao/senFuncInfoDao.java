package org.rabbit.industry.dao;

import org.rabbit.industry.model.sensorfuncinfo;

import java.util.List;

public interface senFuncInfoDao {
    int addSensFuncInfo(sensorfuncinfo s);

    int updateSenFuncInfo(sensorfuncinfo s);

    int deleteSenFuncInfo(sensorfuncinfo s);

    List<sensorfuncinfo> selFuncBySid(String sid);


    List<sensorfuncinfo> seleFuncs(String seid);

    sensorfuncinfo selFuncCode(String sid,String stid,String fid);


    int selCount(sensorfuncinfo s);


}
