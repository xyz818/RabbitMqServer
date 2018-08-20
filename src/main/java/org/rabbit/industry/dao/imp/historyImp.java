package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.historyDao;
import org.rabbit.industry.model.historyrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<historyrecord> findHistroyInfo(int pid, String seid, String startTime, String endTime) {
        List<historyrecord> list = new ArrayList<>();
        try
        {
            String sql = "select * from historyrecord where hr_time between ? and ? and sei_id = ? and pi_seq = ? " +
                    "order by hr_seq desc limit 100";
            list = jdbc.query(sql,new Object[]{startTime,endTime,seid,pid},new BeanPropertyRowMapper(historyrecord.class));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return list;
    }
}
