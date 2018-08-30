package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.devSenDao;
import org.rabbit.industry.model.devicesensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class devSenImp implements devSenDao {
    @Autowired
    JdbcTemplate jdbc;
    @Override
    public int saveDevSenor(String dId, String sId) {
        int row = 0;
        try
        {
            String sql = "insert into devicesensor(di_id,sei_id) values(?,?)";
            row = jdbc.update(sql,new Object[]{dId,sId});
        }
        catch (Exception e)
        {

        }

        return row;
    }

    @Override
    public int delDevSenor(String sId) {
        int row = 0;
        try
        {
            String sql = "delete from devicesensor where sei_id = ?";
            row = jdbc.update(sql,new Object[]{sId});
        }catch (Exception e)
        {

        }

        return row;
    }

    @Override
    public int selSeqByDevSenId(String did, String sId) {
        int row = 0;
        try
        {
            String sql = "select COUNT(*) from devicesensor where di_id=? and sei_id = ?";
            row = jdbc.queryForObject(sql,Integer.class,new Object[]{did,sId});
        }catch (Exception e)
        {
//            e.printStackTrace();
        }
        return row;
    }
}
