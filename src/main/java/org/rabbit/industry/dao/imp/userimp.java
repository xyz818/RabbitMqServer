package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.userdao;
import org.rabbit.industry.model.accountinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class userimp implements userdao {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public int verify(String id, String pwsd) {
       List user = jdbc.query("select * from userinfo where ui_id = ? and ui_pwd=?",new String[]{id,pwsd},new BeanPropertyRowMapper(accountinfo.class));
        return user.size();
    }
}
