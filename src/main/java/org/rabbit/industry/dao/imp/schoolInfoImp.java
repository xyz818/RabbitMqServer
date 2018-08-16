package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.schoolInfoDao;
import org.rabbit.industry.model.schoolinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class schoolInfoImp implements schoolInfoDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int addSchool(schoolinfo s) {
        int row = 0;
        try {
            String sql = "insert into schollinfo values(sci_id,sci_name,sci_city,sci_person,sci_phone,sci_address,sci_brief,sci_param)";
            row = jdbc.update(sql, new Object[]{s.getSci_id(), s.getSci_name(), s.getSci_city(), s.getSci_person(), s.getSci_phone(), s.getSci_address(), s.getSci_brief()});
        } catch (Exception e) {
        }
        return row;
    }

    @Override
    public int delScholl(schoolinfo s) {


        int row = 0;
        try {
            String sql = "delete from schoolinfo where sci_id = ?";
            row = jdbc.update(sql, new Object[]{s.getSci_id()});
        } catch (Exception e) {

        }


        return row;
    }

    @Override
    public int updateSchool(schoolinfo s) {
        int row = 0;
        try {
            String sql = "update schoolinfo set sci_name =? where sci_id = ?";
            row = jdbc.update(sql, new Object[]{s.getSci_name(), s.getSci_id()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<schoolinfo> findSchool() {
        List<schoolinfo> list = new ArrayList<>();
        try {
            String sql = "select * from schoolinfo where ";
            jdbc.query(sql, new BeanPropertyRowMapper(schoolinfo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public schoolinfo findSchoolById(String sid) {
        try {
            String sql = "select * from schoolinfo where sci_id = ?";
            return (schoolinfo) jdbc.queryForObject(sql, new Object[]{sid}, new BeanPropertyRowMapper(schoolinfo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
