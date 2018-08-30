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
            String sql = "select a.li_id,a.li_name,a.li_status,a.pi_seq,b.pi_name from logicinfo a " +
                    "inner  join  projectinfo b on a.pi_seq = b.pi_seq where a.pi_seq = ? ";
            list = jdbc.query(sql, new Object[]{pid}, new BeanPropertyRowMapper(logicinfo.class));
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return list;
    }

    @Override
    public logicinfo findLogicById(String id) {
        try {
            String sql = "select a.li_id,a.li_name,a.li_status,a.pi_seq,b.pi_name from logicinfo a  " +
                    "inner  join  projectinfo b on a.pi_seq = b.pi_seq where a.li_id = ?";
            return (logicinfo) jdbc.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(logicinfo.class));

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
            String sql = "update logicinfo set li_status=? where li_id = ?";
            row = jdbc.update(sql, new Object[]{l.getLi_status(), l.getLi_id()});
        } catch (Exception e) {

        }
        return row;
    }

    @Override
    public int deleteLogic(String id) {
        int row = 0;
        try {
            String sql = "delete from logicinfo where li_id = ?";
            row = jdbc.update(sql, new Object[]{id});
        } catch (Exception e) {
        }
        return row;
    }

    @Override
    public int deleteLogicByProject(int pid) {
        int row = 0;

        try {
            String sql = "delete a,b,c from logicinfo a left join  triggerinfo b on a.li_id = b.li_id left join " +
                    "controllerinfo c on a.li_id = b.li_id where a.pi_seq = ?";
            row = jdbc.update(sql, new Object[]{pid});
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return row;
    }
}
