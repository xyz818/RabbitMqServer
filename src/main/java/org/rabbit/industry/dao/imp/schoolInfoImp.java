package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.schoolInfoDao;
import org.rabbit.industry.model.schoolinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class schoolInfoImp implements schoolInfoDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int addSchool(schoolinfo s) {
        int row = 0;
        try {
            String sql = "insert into schollinfo values(sci_id,sci_name,sci_city,sci_person,sci_phone,sci_address,sci_brief,sci_param)";
            row = jdbc.update(sql, new Object[]{s.getSci_id(), s.getSci_name(), s.getSci_city(), s.getSci_person(), s.getSci_phone(), s.getSci_address(), s.getSci_brief()});
        } catch (Exception e) {
        }
        return row;
    }
}
