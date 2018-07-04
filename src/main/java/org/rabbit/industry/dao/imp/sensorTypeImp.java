package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.sensorTypeDao;
import org.rabbit.industry.model.sensorTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class sensorTypeImp implements sensorTypeDao {

    @Autowired
    private JdbcTemplate jdbc;

    /*
    * 查询所有的传感器类型
    *
    * */
    @Override
    public List<sensorTypeInfo> findSensorType() {
        List<sensorTypeInfo> list = new ArrayList<>();
        try {

            list = jdbc.query("select * from sensortypeinfo", new BeanPropertyRowMapper(sensorTypeInfo.class));
            System.out.println(list.size());
            sensorTypeInfo ss = list.get(0);

            System.out.println(ss.getSti_id()+",,,,,,,");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
    * 根据控制类型查询传感器类型
    * */
    @Override
    public List<sensorTypeInfo> findSensorTypeByControl(int control) {
        List<sensorTypeInfo> list = new ArrayList<>();
        try {
            list = jdbc.query("select * from sensortypeinfo where sti_control=?",new Object[]{ (short)control},new BeanPropertyRowMapper(sensorTypeInfo.class));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int addSensorType(sensorTypeInfo s) {
        String sql = "insert into sensortypeinfo(sti_id,sti_name,sti_unit,sti_control) values(?,?,?,?)";
        int row =jdbc.update(sql,new Object[]{s.getSti_id(),s.getSti_name(),s.getSti_unit(),s.getSti_control()});
        return row;
    }

    @Override
    public List<sensorTypeInfo> selSenTypeByTid(String tid) {
        List<sensorTypeInfo> list = new ArrayList<>();
        try
        {
            String sql = "select * from sensortypeinfo a inner join sensortrantype b on a.sti_id = b.sti_id where b.tti_id = ?";
            list = jdbc.query(sql,new Object[]{tid},new BeanPropertyRowMapper(sensorTypeInfo.class));
        }catch (Exception e)
        {
        }
        return list;
    }


}
