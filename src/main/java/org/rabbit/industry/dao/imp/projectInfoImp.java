package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.projectInfoDao;
import org.rabbit.industry.model.projectinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class projectInfoImp implements projectInfoDao {
    @Autowired
    JdbcTemplate jdbc;


    @Override
    public List<projectinfo> findProJect() {
        List<projectinfo> list = new ArrayList<>();
        try {
            String sql = "select a.pi_seq,a.pti_id,a.pi_name,a.pi_time,a.pi_status,a.aci_id,b.pti_name from projectinfo a " +
                    " inner  join  projecttypeinfo b on a.pti_id = b.pti_id";
            list = jdbc.query(sql, new BeanPropertyRowMapper(projectinfo.class));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<projectinfo> findProjectByAccount(String id) {
        List<projectinfo> list = new ArrayList<>();
        try {
            String sql = "select a.pi_seq,a.pti_id,a.pi_name,a.pi_time,a.pi_status,a.aci_id,b.pti_name from projectinfo a " +
                    "inner  join projecttypeinfo b  on a.pti_id = b.pti_id where aci_id = ?";
            list = jdbc.query(sql, new Object[]{id}, new BeanPropertyRowMapper(projectinfo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int addProject(projectinfo p) {
        int row = 0;
        try {
            String sql = "insert into projectinfo(pti_id,pi_name,pi_time,pi_status,aci_id) values(?,?,?,?,?)";
            row = jdbc.update(sql, new Object[]{p.getPti_id(), p.getPi_name(), p.getPi_time(), p.getPi_status(), p.getAci_id()});
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    @Override
    public int updateProject(projectinfo p) {
        int row = 0;
        try {
            String sql = "update projectinfo set pti_id=?,pi_name=?,pi_time=? where pi_seq = ? ";
            row = jdbc.update(sql, new Object[]{p.getPti_id(), p.getPi_name(), p.getPi_time(),p.getPi_seq()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int delProject(int id) {

        int row = 0;
        try {
            String sql = "delete  a,b,c,d,e,f from projectinfo a left join projectdevice b " +
                    "on a.pi_seq=b.pi_seq left join deviceinfo c on " +
                    "c.di_id = b.di_id left join  devicesensor d on " +
                    "d.di_id = c.di_id left join sensorinfo e on " +
                    "d.sei_id =e.sei_id left join sensorfuncinfo f on f.sei_id = e.sei_id  where a.pi_seq = ?";
            row = jdbc.update(sql, new Object[]{id});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public projectinfo findProject(int id) {
        try {
            String sql = "select * from projectinfo where pi_seq = ?";
            return (projectinfo) jdbc.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(projectinfo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateProjectStatus(projectinfo p) {
        int row = 0;
        try
        {
            String sql = "update projectinfo set pi_status = ? where pi_seq = ?";
            row =  jdbc.update(sql,new Object[]{p.getPi_status(),p.getPi_seq()});
        }
        catch (Exception e)
        {
        }

        return row;
    }
}
