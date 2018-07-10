package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.triggerInfoDao;
import org.rabbit.industry.model.triggerinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class triggerInfoImp implements triggerInfoDao {
    @Autowired
    JdbcTemplate jdbc;


    @Override
    public List<triggerinfo> findTriggerByProject(int pid) {

        List<triggerinfo> list = new ArrayList<>();
        try
        {
            String sql = "select * from triggerinfo where ";
            list = jdbc.query(sql,new Object[]{pid},new BeanPropertyRowMapper(triggerinfo.class));
        }catch (Exception e)
        {}
        return list;
    }

    @Override
    public List<triggerinfo> findTriggerByLogic(String id) {
        List<triggerinfo> list = new ArrayList<>();
        try
        {
            String sql = "select * from triggerinfo where li_id = ?";
            list = jdbc.query(sql,new Object[]{id},new BeanPropertyRowMapper(triggerinfo.class));
        }
        catch (Exception e)
        {
        }
        return list;
    }

    @Override
    public triggerinfo findTriggerById(int id) {
        try
        {
            String sql = "select * from triggerinfo where tri_seq = ?";
            return (triggerinfo) jdbc.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper(triggerinfo.class));

        }
        catch (Exception e)
        {}

        return null;
    }

    @Override
    public int updateTrigger(triggerinfo t) {
        int row = 0;
        try
        {
          String sql = "update triggerinfo set ";
          row = jdbc.update(sql,new Object[]{});

        }
        catch (Exception e)
        {}

        return row;
    }
}
