package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.projectTypeDao;
import org.rabbit.industry.model.projecttype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class projectTypeImp implements projectTypeDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<projecttype> findProjectType() {
        List<projecttype> list = new ArrayList<>();
        try {
            String sql = "select * from projecttypeinfo";
            list = jdbc.query(sql, new BeanPropertyRowMapper(projecttype.class));
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public int addProjectType(projecttype p) {

        int row = 0;
        try {
            String sql = "insert into projecttypeinfo(pti_id,pti_name) values(?,?)";
            row = jdbc.update(sql, new Object[]{p.getPti_id(), p.getPti_name()});
        } catch (Exception e) {

        }
        return row;
    }
}
