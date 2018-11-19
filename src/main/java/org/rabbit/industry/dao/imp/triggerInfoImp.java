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
    public int addTriggerInfo(triggerinfo t) {
        int row = 0;

        try{
            //8-30 触发源问题,去重复
            if(selectTriggerCountBySeid(t.getSei_id(),t.getLi_id()) <=0) {
                String sql = "insert into triggerinfo(li_id,tri_valuetype,tri_limit,tri_value,sei_id) values(?,?,?,?,?)";
                row = jdbc.update(sql, new Object[]{t.getLi_id(), t.getTri_valuetype(), t.getTri_limit(), t.getTri_value(), t.getSei_id()});
            }
        } catch (Exception e)
        {
//            e.printStackTrace();

        }
        return row;
    }

    @Override
    public List<triggerinfo> findTriggerByProject(int pid) {

        List<triggerinfo> list = new ArrayList<>();
        try {
            String sql = "select * from triggerinfo where ";
            list = jdbc.query(sql, new Object[]{pid}, new BeanPropertyRowMapper(triggerinfo.class));
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public List<triggerinfo> findTriggerByLogic(String id) {
        List<triggerinfo> list = new ArrayList<>();
        try {
            String sql = "select * from triggerinfo where li_id = ?";
            list = jdbc.query(sql, new Object[]{id}, new BeanPropertyRowMapper(triggerinfo.class));
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public triggerinfo findTriggerById(int id) {
        try {
            String sql = "select * from triggerinfo where tri_seq = ?";
            return (triggerinfo) jdbc.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(triggerinfo.class));

        } catch (Exception e) {
        }

        return null;
    }

    @Override
    public int updateTrigger(triggerinfo t) {
        int row = 0;
        try {
            String sql = "update triggerinfo set ";
            row = jdbc.update(sql, new Object[]{});

        } catch (Exception e) {
        }

        return row;
    }

    @Override
    public triggerinfo findTriggerBySid(String sid,String lid) {
        try {
            String sql = "select * from triggerinfo where sei_id = ? and li_id = ?";
            return (triggerinfo) jdbc.queryForObject(sql, new Object[]{sid,lid}, new BeanPropertyRowMapper(triggerinfo.class));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int selectTriggerCountBySeid(String sid,String lid) {
        int row = 0;
        try
        {
            String sql = "select count(*) from triggerinfo where sei_id = ? and li_id = ?";
            row = jdbc.queryForObject(sql,Integer.class,new Object[]{sid,lid});
        }
        catch (Exception e){}
        return row;
    }
}
