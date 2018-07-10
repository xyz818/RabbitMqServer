package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.controllerInfoDao;
import org.rabbit.industry.model.controllerinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class controllerInfoImp implements controllerInfoDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<controllerinfo> findControllerByProject(int pid) {
        return null;
    }

    @Override
    public List<controllerinfo> findControllerByLogic(String id) {
        return null;
    }

    @Override
    public controllerinfo findControllerById(String id) {
        return null;
    }

    @Override
    public int updateController(controllerinfo c) {
        return 0;
    }
}
