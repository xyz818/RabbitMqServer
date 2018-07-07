package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.logicInfoDao;
import org.rabbit.industry.model.logicinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class logicInfoImp implements logicInfoDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<logicinfo> findLogicByProject(int pid) {
        List<logicinfo> list = new ArrayList<>();

        try {
            String sql = "select  * from logicinfo where pi_seq = ?";
            list = jdbc.query(sql, new Object[]{pid}, new BeanPropertyRowMapper(logicinfo.class));
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public logicinfo findLogicById(String id) {
        try {
            String sql = "";
            logicinfo l = (logicinfo) jdbc.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(logicinfo.class));
            return l;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public int addLogic(logicinfo l) {
        int row = 0;
        try {
            String sql = "insert into logicinfo(li_id,li_name,li_status,pi_seq) values(?,?,?,?)";
            row = jdbc.update(sql, new Object[]{l.getLi_id(), l.getLi_name(), l.getLi_status(), l.getPi_seq()});
        } catch (Exception e) {
        }

        return row;

    }

    @Override
    public int updateLogicStatus(logicinfo l) {
        int row = 0;
        try {
            String sql = "update logicinfo set li_status where li_id = ?";
            row = jdbc.update(sql, new Object[]{l.getLi_status(), l.getLi_id()});
        } catch (Exception e) {

        }
        return row;
    }

    @Override
    public int deleteLogic(String id) {
        int row = 0;
        try
        {
            String sql ="delete from logicinfo where li_id = ?";
            row = jdbc.update(sql,new Object[]{id});
        }
        catch (Exception e)
        {}
        return row;
    }
}
