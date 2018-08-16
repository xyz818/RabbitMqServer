package org.rabbit.industry.dao;

import org.rabbit.industry.model.sensorfuncinfo;

import java.util.List;

public interface senFuncInfoDao {
    int addSensFuncInfo(sensorfuncinfo s);

    int updateSenFuncInfo(sensorfuncinfo s);

    int deleteSenFuncInfo(sensorfuncinfo s);

    List<sensorfuncinfo> selFuncBySid(String sid);


    List<sensorfuncinfo> seleFuncs(String stid);

    sensorfuncinfo selFuncCode(String sid,String fid,String stid);


    int selCount(sensorfuncinfo s);


}
