package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.senFuncDao;
import org.rabbit.industry.model.sensorfunc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class senFuncImp implements senFuncDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int addSFtype(sensorfunc s) {
        int row = 0;
        try {
            String sql = "insert into sensorfunc(sti_id,fui_id) values(?,?)";
            row = jdbc.update(sql, new Object[]{s.getSti_id(), s.getFui_id()});

        } catch (Exception e) {

        }
        return row;
    }
}
