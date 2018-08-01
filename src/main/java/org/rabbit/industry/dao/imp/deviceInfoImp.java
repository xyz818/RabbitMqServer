package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.deviceInfoDao;
import org.rabbit.industry.model.deviceinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class deviceInfoImp implements deviceInfoDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<deviceinfo> findDeivceByProject(int pid) {
        List<deviceinfo> list = new ArrayList<>();
        try {
            //关联查询
            String sql = "select a.di_id,a.di_mac,a.di_name,a.di_type,a.di_conttype,a.di_status,a.di_key" +
                    "  from deviceinfo a inner  join  projectdevice b on" +
                    " a.di_id = b.di_id where b.pi_seq = ?";
            list = jdbc.query(sql, new Object[]{pid}, new BeanPropertyRowMapper(deviceinfo.class));

        } catch (Exception e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public deviceinfo findDeviceById(String did) {
        try {
            String sql = "select  * from deviceinfo where di_id = ?";
            deviceinfo d = (deviceinfo) jdbc.queryForObject(sql, new Object[]{did}, new BeanPropertyRowMapper(deviceinfo.class));
            return d;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addDevice(deviceinfo d) {
        int row = 0;
        try {
            String sql = "insert into deviceinfo(di_id,di_mac,di_name,di_type,di_conttype,di_key) values(?,?,?,?,?,?)";
            row = jdbc.update(sql, new Object[]{d.getDi_id(), d.getDi_mac(), d.getDi_name(), d.getDi_type(), d.getDi_conttype(),
                     d.getDi_key()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int updateDevice(deviceinfo d) {
        int row = 0;
        try {
            String sql = "update deviceinfo set di_mac = ?,di_name = ?,di_type = ?,di_conttype = ?,di_status=?";
            row = jdbc.update(sql, new Object[]{d.getDi_mac(), d.getDi_name(), d.getDi_type(), d.getDi_conttype(),
                    d.getDi_status(), d.getDi_id()});

        } catch (Exception e) {
            e.printStackTrace();

        }
        return row;
    }

    @Override
    public int deleteDevice(String did) {

        int row = 0;
        try {
            String sql = "delete  a,b,c,e from deviceinfo a left join devicesensor b on a.di_id = b.di_id left join " +
                    "sensorinfo c on c.sei_id=b.sei_id left join sensorfuncinfo e on e.sei_id = c.sei_id " +
                    " where a.di_id=?";
            row = jdbc.update(sql, new Object[]{did});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
