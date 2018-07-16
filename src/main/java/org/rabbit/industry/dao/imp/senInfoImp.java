package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.sensorInfoDao;
import org.rabbit.industry.model.sensorinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class senInfoImp implements sensorInfoDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<sensorinfo> findSensorByDevice(String id) {
        List<sensorinfo> list = new ArrayList<>();
        try {
            String sql = "select a.sei_id,a.sti_id,a.tti_id,a.sei_mac,a.sei_value,d.tti_name,c.sti_name,c.sti_control,b.di_id from sensorinfo a " +
                    "inner join devicesensor b on a.sei_id = b.sei_id inner join sensortypeinfo c on c.sti_id = a.sti_id " +
                    "inner  join trantypeinfo d on d.tti_id = a.tti_id  where b.di_id = ?";
            list = jdbc.query(sql, new Object[]{id}, new BeanPropertyRowMapper(sensorinfo.class));
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public sensorinfo findSensorById(String id) {

        sensorinfo s = null;
        try {
            String sql = "select a.sei_id,a.sti_id,a.tti_id,a.sei_mac,a.sei_value,d.tti_name,c.sti_name,c.sti_control,b.di_id from sensorinfo a " +
                    " inner join devicesensor b on a.sei_id = b.sei_id " +
                    " inner join sensortypeinfo c on c.sti_id = a.sti_id " +
                    " inner  join trantypeinfo d on d.tti_id = a.tti_id  where a.sei_id = ?";
            s = (sensorinfo) jdbc.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(sensorinfo.class));
        } catch (Exception e) {
        }
        return s;
    }

    @Override
    public List<sensorinfo> findSensorByControl(String devId, int control) {
        List<sensorinfo> list = new ArrayList<>();
        try {
            String sql = "select a.sei_id,a.sti_id,a.tti_id,a.sei_mac,a.sei_value,d.tti_name,c.sti_name from sensorinfo a " +
                    "inner join devicesensor b on a.sei_id = b.sei_id inner join sensortypeinfo c on c.sti_id = a.sti_id " +
                    "inner  join trantypeinfo d on d.tti_id = a.tti_id  where b.di_id = ? and  c.sti_control = ?";
            list = jdbc.query(sql, new Object[]{devId, (short) control}, new BeanPropertyRowMapper(sensorinfo.class));
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public int addSensor(sensorinfo s) {
        int row = 0;
        try {
            String sql = "insert into sensorinfo(sei_id,sti_id,tti_id,sei_mac) values (?,?,?,?)";
            row = jdbc.update(sql, new Object[]{s.getSei_id(), s.getSti_id(), s.getTti_id(), s.getSei_mac()});
        } catch (Exception e) {
        }
        return row;
    }

    @Override
    public int updateSensor(sensorinfo s) {
        int row = 0;
        try {
            String sql = "update sensorinfo set sti_id = ?,tti_id = ?,sei_value=?,sei_mac=? where sei_id = ?";
            row = jdbc.update(sql, new Object[]{s.getSei_id(), s.getSti_id(), s.getTti_id(), s.getSei_value(), s.getSei_mac()});
        } catch (Exception e) {

        }
        return row;
    }

    @Override
    public int deleteSensor(String id) {
        int row = 0;
        try {
            String sql = "delete from sensorinfo where sei_id = ?";
            row = jdbc.update(sql, new Object[]{id});
        } catch (Exception e) {
        }
        return row;
    }

    @Override
    public List<sensorinfo> findSensorByProject(int pid) {
        List<sensorinfo> list = new ArrayList<>();
        try {

            String sql = "select a.sei_id,a.sti_id,a.tti_id,a.sei_mac,a.sei_value,d.tti_name,c.sti_name,c.sti_control,b.di_id from sensorinfo a " +
                    "inner join devicesensor b on a.sei_id = b.sei_id inner join sensortypeinfo c on c.sti_id = a.sti_id " +
                    "inner  join trantypeinfo d on d.tti_id = a.tti_id  inner join projectdevice e on e.di_id = b.di_id where e.pi_seq = ?";
            list = jdbc.query(sql, new Object[]{pid}, new BeanPropertyRowMapper(sensorinfo.class));

        } catch (Exception e) {

        }

        return list;
    }


}
