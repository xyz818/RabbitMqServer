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

    /**
     * 查询所有传输类型列表
     */
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

    /**
     * 添加传输类型
     */
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

    /**
     * @param stid@author 　xuyongzhe
     * @brief 根据传感器类型id查询传输类型
     **/
    @Override
    public List<tranTypeInfo> findTranTypeByStid(String stid) {

        List<tranTypeInfo> list = new ArrayList<>();
        try {
            String sql = "select a.tti_id,a.tti_name from trantypeinfo a inner  join  sensortrantype b " +
                    "on a.tti_id=b.tti_id where b.sti_id = ?";
            list = jdbc.query(sql, new Object[]{stid}, new BeanPropertyRowMapper(tranTypeInfo.class));
        } catch (Exception e) {
        }
        return list;
    }
}
