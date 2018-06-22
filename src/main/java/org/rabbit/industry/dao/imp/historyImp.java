package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.historyDao;
import org.rabbit.industry.model.historyrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class historyImp implements historyDao {


    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public int saveHistory(historyrecord hi) {
        int row = jdbc.update("insert into historyrecord(ri_id,sei_id,hr_time,hr_conttype,hr_value,hr_electric) values(?,?,?,?,?,?)",
                new Object[]{hi.getRid(),hi.getSid(),hi.getTime(),hi.getContype(),hi.getValue(),hi.getVoltage()});
        return row;
    }
}
