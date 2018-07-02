package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.tranTypeDao;
import org.rabbit.industry.model.tranTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class tranTypeImp implements tranTypeDao {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<tranTypeInfo> findTranType() {
        List<tranTypeInfo> list = new ArrayList<>();
        try {
            String sql = "select * from trantypeinfo";
            list = jdbc.query(sql, new BeanPropertyRowMapper(tranTypeInfo.class));
        } catch (Exception e) {

        }
        return list;
    }


    @Override
    public int addTranType(tranTypeInfo t) {
        String sql = "insert into trantypeinfo(tti_id,tti_name) values(?,?)";
        int row = 0;
        try {
            row = jdbc.update(sql, new Object[]{t.getTti_id(), t.getTti_name()});
        } catch (Exception e) {
        }
        return row;
    }
}
