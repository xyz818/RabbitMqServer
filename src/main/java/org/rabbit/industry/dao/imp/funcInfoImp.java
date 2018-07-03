package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.funcInfoDao;
import org.rabbit.industry.model.funcinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class funcInfoImp implements funcInfoDao {
    @Autowired
    private JdbcTemplate jdbc;

    /**
     *
     * 查询功能列表dao
     * */
    @Override
    public List<funcinfo> findFuncType() {
        List<funcinfo> list = new ArrayList<>();
        try {
            String sql = "select * from funcinfo";
            list = jdbc.query(sql, new BeanPropertyRowMapper(funcinfo.class));

        } catch (Exception e) {
        }
        return list;
    }

    /**
     * 添加功能列表信息
     * */
    @Override
    public int addFuncType(funcinfo func) {
        int row = 0;
        try {
            String sql = "insert into funcinfo(fui_id,fui_name) values(?,?)";
            row = jdbc.update(sql, new Object[]{func.getFui_id(), func.getFui_name()});
        } catch (Exception e) {
        }
        return row;
    }
}
