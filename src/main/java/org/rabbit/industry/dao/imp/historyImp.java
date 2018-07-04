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
        int row = 0;
        try {
            row = jdbc.update("insert into historyrecord(di_id,sei_id,hr_time,hr_value,pi_seq) select ?,?,?,?,pi_seq from projectdevice where di_id = ? ",
                    new Object[]{hi.getDi_id(), hi.getSei_id(), hi.getHr_time(), hi.getHr_value(), hi.getDi_id()});
            return row;
        }
        catch (Exception e)
        {

        }
        return row;
    }
}
