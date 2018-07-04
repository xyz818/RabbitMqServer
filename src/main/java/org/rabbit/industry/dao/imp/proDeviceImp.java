package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.proDeviceDao;
import org.rabbit.industry.model.projectdevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class proDeviceImp implements proDeviceDao {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public projectdevice selProIdByDeviceId(String deviceId) {
        projectdevice projectdevice = null;
        try{
            String sql = "select * from projectdevice where di_id = ?";
            projectdevice = (org.rabbit.industry.model.projectdevice) jdbc.queryForObject(sql,new Object[]{deviceId},new BeanPropertyRowMapper(projectdevice.class));
        }catch (Exception e)
        {

        }
        return projectdevice;
    }
}
