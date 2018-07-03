package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.sensorInfoDao;
import org.rabbit.industry.model.sensorinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class senInfoImp implements sensorInfoDao {
    @Autowired
    JdbcTemplate jdbc;
    @Override
    public List<sensorinfo> findSensorByDevice(String id) {
        List<sensorinfo> list = new ArrayList<>();
        try {
            String sql="select a.sei_seq,a.sei_id,a.sti_id,a.tti_id,a.sei_mac,a.sei_value,d.tti_name,c.sti_name from sensorinfo a " +
                    "inner join devicesensor b on a.sei_id = b.sei_id inner join sensortypeinfo c on c.sti_id = a.sti_id " +
                    "inner  join trantypeinfo d on d.tti_id = a.tti_id  where b.di_id = ?";
            list = jdbc.query(sql,new Object[]{id},new BeanPropertyRowMapper(sensorinfo.class));
        } catch (Exception e)
        {
        }
        return list;
    }
}
