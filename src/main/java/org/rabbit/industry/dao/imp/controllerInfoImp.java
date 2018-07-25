package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.controllerInfoDao;
import org.rabbit.industry.model.controllerinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class controllerInfoImp implements controllerInfoDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<controllerinfo> findControllerByProject(int pid) {
        return null;
    }

    @Override
    public List<controllerinfo> findControllerByLogic(String id) {
        return null;
    }

    @Override
    public controllerinfo findControllerById(String id) {
        return null;
    }

    @Override
    public int updateController(controllerinfo c) {
        return 0;
    }

    /**
     * @param sid 触发类传感器id
     * @author　xuyongzhe
     * @brief 根据触发器传感器id号查询控制类传感器id号
     **/
    @Override
    public controllerinfo findControllerByTrigId(String sid) {
        try
        {
            String sql = "select b.coi_value,b.sei_id,b.li_id,c.li_status  from triggerinfo a inner join controllerinfo b on a.li_id = b.li_id " +
                    "inner join logicinfo c on c.li_id=b.li_id　where " +
                    "a.sei_id = ?";
            return (controllerinfo) jdbc.queryForObject(sql,new Object[]{sid},new BeanPropertyRowMapper(controllerinfo.class));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
