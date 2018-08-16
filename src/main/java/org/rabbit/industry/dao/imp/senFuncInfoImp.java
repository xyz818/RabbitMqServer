package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.senFuncInfoDao;
import org.rabbit.industry.model.sensorfuncinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class senFuncInfoImp implements senFuncInfoDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int addSensFuncInfo(sensorfuncinfo s) {
        int row = 0;
        try {
            String sql = "insert into sensorfuncinfo(sei_id,sf_seq,sfi_code) select a.sei_id ,b.sf_seq,? from " +
                    "sensorinfo a left join sensorfunc b on a.sti_id=b.sti_id where a.sei_id=? and b.fui_id=?";
            row = jdbc.update(sql, new Object[]{s.getSfi_code(), s.getSei_id(), s.getFui_id()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int selCount(sensorfuncinfo s) {

        int seq = 0;
        try {
            String sql = "select sfi_seq from  sensorfuncinfo  where sei_id=? and sf_seq=(" +
                    "select a.sf_seq from sensorfunc a left join sensorinfo  b on a.sti_id = b.sti_id where a.fui_id = ? and b.sei_id  = ?" +
                    ")";
            seq = jdbc.queryForObject(sql, Integer.class, new Object[]{s.getSei_id(), s.getFui_id(), s.getSei_id()});
        } catch (Exception e) {
        }
        System.out.println("seq:" + seq);
        return seq;
    }


    @Override
    public int updateSenFuncInfo(sensorfuncinfo s) {

        int row = 0;
        try {
            String sql = "update sensorfuncinfo set sfi_code = ? where sei_id=? and sf_seq=(" +
                    "select a.sf_seq from  sensorfunc a left join sensorinfo  b on a.sti_id = b.sti_id where a.fui_id = ? and b.sei_id  = ?" +
                    ")";
            row = jdbc.update(sql, new Object[]{s.getSfi_code(), s.getSei_id(), s.getFui_id(), s.getSei_id()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int deleteSenFuncInfo(sensorfuncinfo s) {
        int row = 0;
        try {
            String sql = "delete from sensorfuncinfo where sfi_seq = ?";
            row = jdbc.update(sql, new Object[]{s.getSfi_seq()});
        } catch (Exception e) {

        }
        return row;
    }

    @Override
    public List<sensorfuncinfo> selFuncBySid(String sid) {
        List<sensorfuncinfo> list = new ArrayList<>();
        try {
            String sql = "select a.sf_seq,b.fui_id,c.fui_name,c.fui_param,a.sfi_code " +
                    "  from sensorfuncinfo a inner join sensorfunc b on a.sf_seq = b.sf_seq " +
                    "inner join funcinfo c on c.fui_id = b.fui_id where a.sei_id = ?";
            list = jdbc.query(sql, new Object[]{sid}, new BeanPropertyRowMapper(sensorfuncinfo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<sensorfuncinfo> seleFuncs(String stid) {
        List<sensorfuncinfo> list = new ArrayList<>();
        try {
            String sql = "select  a.fui_id,c.sfi_code,b.fui_name,b.fui_param   from sensorfunc a left join funcinfo b on " +
                    "b.fui_id = a.fui_id left join sensorfuncinfo c on c.sf_seq = a.sf_seq where a.sti_id = ?";
            list = jdbc.query(sql, new Object[]{stid}, new BeanPropertyRowMapper(sensorfuncinfo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public sensorfuncinfo selFuncCode(String sid, String fid, String stid) {
        try {
            String sql = "select a.sfi_seq,a.sfi_code from sensorfuncinfo a inner join sensorfunc b on a.sf_seq = b.sf_seq where " +
                    "a.sei_id =? and b.sti_id=? and fui_id = ?";
            return (sensorfuncinfo) jdbc.queryForObject(sql, new Object[]{sid, stid, fid}, new BeanPropertyRowMapper(sensorfuncinfo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
