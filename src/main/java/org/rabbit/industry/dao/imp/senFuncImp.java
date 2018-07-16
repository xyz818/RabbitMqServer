package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.senFuncDao;
import org.rabbit.industry.model.sensorfunc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<sensorfunc> selSensorFunc(String sid) {
        List<sensorfunc> list = new ArrayList<>();
        try
        {
            String sql = "select a.sei_id,b.sti_id,b.sti_name,d.fui_id,d.fui_name,c.sf_imgurl from sensorinfo a inner join sensortypeinfo b  on a.sti_id = b.sti_id " +
                    "inner join sensorfunc c on b.sti_id = c.sti_id inner join  funcinfo d on d.fui_id = c.fui_id where a.sei_id = ?";
            list = jdbc.query(sql,new Object[]{sid},new BeanPropertyRowMapper(sensorfunc.class));
        }
        catch (Exception e)
        {

        }
        return list;
    }

    @Override
    public sensorfunc selSensorFuncByFuncId(String sid, String fid) {

        try
        {
            String sql = "select a.sei_id,b.sti_id,b.sti_name,d.fui_id,d.fui_name,c.sf_imgurl from sensorinfo a inner join sensortypeinfo b  on a.sti_id = b.sti_id " +
                    "inner join sensorfunc c on b.sti_id = c.sti_id inner join  funcinfo d on d.fui_id = c.fui_id where a.sei_id = ? and c.fui_id = ?";
            return (sensorfunc) jdbc.queryForObject(sql,new Object[]{sid,fid},new BeanPropertyRowMapper(sensorfunc.class));
        }
        catch (Exception e)
        {
            //e.printStackTrace();
        }
        return null;
    }
}
