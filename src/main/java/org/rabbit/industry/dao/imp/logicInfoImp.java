package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.logicInfoDao;
import org.rabbit.industry.model.logicinfo;

import java.util.List;

public class logicInfoImp implements logicInfoDao {
    @Override
    public List<logicinfo> findLogicByProject(int pid) {
        return null;
    }

    @Override
    public logicinfo findLogicById(String id) {
        return null;
    }

    @Override
    public int addLogic(logicinfo l) {
        return 0;
    }

    @Override
    public int updateLogicStatus(logicinfo l) {
        return 0;
    }

    @Override
    public int deleteLogic(String id) {
        return 0;
    }
}
