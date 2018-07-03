package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.senTranTypeDao;
import org.rabbit.industry.model.sensortrantype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class senTranTypeImp implements senTranTypeDao {

    @Autowired
    private JdbcTemplate jdbc;
    /**
     * 插入传感器传输关联表
     * */
    @Override
    public int addSTtype(sensortrantype s) {
        int row = 0;
        try
        {
            String sql = "insert into sensortrantype(sti_id,tti_id) values(?,?)";
            row = jdbc.update(sql,new Object[]{s.getSti_id(),s.getTti_id()});
        }
        catch (Exception e)
        {}
        return row;
    }
}
