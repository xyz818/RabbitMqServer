package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.controllerInfoDao;
import org.rabbit.industry.model.controllerinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class controllerInfoImp implements controllerInfoDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<controllerinfo> findControllerByProject(int pid) {
        List<controllerinfo> list =new ArrayList<>();
        try
        {
          String sql = "select a.coi_seq,a.li_id,a.coi_valuetype,a.coi_value,a.sei_id from controllerinfo a inner join " +
                  "logicinfo b on a.li_id = b.li_id where b.pi_seq = ?";
          list = jdbc.query(sql,new Object[]{pid},new BeanPropertyRowMapper(controllerinfo.class));
        }
        catch (Exception e)
        {}


        return list;
    }

    @Override
    public List<controllerinfo> findControllerByLogic(String id) {
        List<controllerinfo> list =new ArrayList<>();
        try
        {
            String sql = "select * from controllerinfo where li_id = ?";
            list = jdbc.query(sql,new Object[]{id},new BeanPropertyRowMapper(controllerinfo.class));
        }
        catch (Exception e)
        {}


        return list;

    }

    @Override
    public controllerinfo findControllerById(String id) {
        return null;
    }

    @Override
    public int updateController(controllerinfo c) {
        int row = 0;
        try{
            String sql = "update controllerinfo set ";
            row = jdbc.update(sql,new Object[]{});
        }
        catch (Exception e)
        {}
        return row;
    }

    @Override
    public int addControllerInfo(controllerinfo c) {
        int row = 0;
        try
        {
            String sql = "insert into controllerinfo(li_id,coi_valuetype,coi_value,sei_id) values(?,?,?,?)";
            row = jdbc.update(sql,new Object[]{c.getLi_id(),c.getCoi_valuetype(),c.getCoi_value(),c.getSei_id()});
        }
        catch (Exception e)
        {
//            e.printStackTrace();
        }

        return  row;
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
            String sql = "select b.coi_value,b.sei_id,b.li_id,c.li_status from triggerinfo a " +
                    "inner join controllerinfo b on a.li_id = b.li_id " +
                    "inner join logicinfo c on c.li_id=b.li_id where " +
                    "a.sei_id = ?";
            return (controllerinfo) jdbc.queryForObject(sql,new Object[]{sid},new BeanPropertyRowMapper(controllerinfo.class));
        }
        catch (Exception e)
        {
            //e.printStackTrace();
        }
        return null;
    }
}
