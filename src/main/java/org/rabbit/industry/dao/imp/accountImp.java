package org.rabbit.industry.dao.imp;

import org.rabbit.industry.dao.accountDao;
import org.rabbit.industry.model.accountinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository
public class accountImp implements accountDao {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public int verify(String id, String pwsd) {
        int row = 0;
        try {
            row = jdbc.queryForObject("select COUNT(*) from accountinfo where aci_id = ? and aci_pwd=?", Integer.class, new String[]{id, pwsd});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int updateAccount(accountinfo a) {
        int row = 0;
        try {
            row = jdbc.update("update accountinfo set aci_code=?,aci_phone=? where aci_id = ?", new Object[]{a.getAci_code(), a.getAci_phone(), a.getAci_id()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int updatePwsd(accountinfo a) {
        int row = 0;
        try {
            row = jdbc.update("update accountinfo set aci_pwd =? where aci_id = ?", new Object[]{a.getAci_pwd(), a.getAci_id()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<accountinfo> findAccount() {
        List<accountinfo> list = new ArrayList<>();
        try {
            String sql = "select a.aci_id,a.aci_code,a.aci_pwd,a.aci_phone,a.aci_key,a.aci_role,a.sci_id,b.sci_name " +
                    " from accountinfo a inner join schoolinfo b on a.sci_id = b.sci_id ";
            list = jdbc.query(sql, new BeanPropertyRowMapper(accountinfo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<accountinfo> findAccount(String sid) {
        List<accountinfo> list = new ArrayList<>();
        try {
            String sql = "select a.aci_id,a.aci_code,a.aci_pwd,a.aci_phone,a.aci_key,a.aci_role,a.sci_id,b.sci_name " +
                    "from accountinfo a  inner join  schoolinfo b on a.sci_id  = b.sci_id where sci_id = ?";
            list = jdbc.query(sql, new Object[]{sid}, new BeanPropertyRowMapper(accountinfo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public accountinfo findAccountByAid(String aid) {
        try {
            //根据id号查询信息
            String sql = "select a.aci_id,a.aci_code,a.aci_pwd,a.aci_phone,a.aci_key,a.aci_role,a.sci_id,b.sci_name" +
                    " from accountinfo a  inner join  schoolinfo b on a.sci_id  = b.sci_id where aci_id = ?";
            return (accountinfo) jdbc.queryForObject(sql, new Object[]{aid}, new BeanPropertyRowMapper(accountinfo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addAccountInfo(accountinfo a) {
        int row = 0;
        try {
            String sql = "insert into accountinfo(aci_id,aci_code,aci_pwd,aci_phone,aci_key,sci_id) values(?,?,?,?,?,?,?)";
            row = jdbc.update(sql, new Object[]{a.getAci_id(), a.getAci_code(), a.getAci_pwd(), a.getAci_phone(), a.getAci_key(), a.getSci_id(), a.getAci_role()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int delAccountInfo(String aid) {
        int row = 0;
        try {
            String sql = "delete from accountinfo where aci_id = ?";
            row = jdbc.update(sql, new Object[]{aid});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    /**
     * @param role@author 　xuyongzhe
     * @brief 根据权限查询账号
     **/
    @Override
    public List<accountinfo> findAccountByRole(int role) {
        List<accountinfo> list = new ArrayList<>();
        try {
            String sql = "select a.aci_id,a.aci_code,a.aci_pwd,a.aci_phone,a.aci_key,a.aci_role,a.sci_id,b.sci_name " +
                    " from accountinfo a  inner join  schoolinfo b on a.sci_id  = b.sci_id where aci_role = ?";
            list = jdbc.query(sql, new Object[]{role}, new BeanPropertyRowMapper(accountinfo.class));
        } catch (Exception e) {
        }
        return list;
    }

    /**
     * @param scid
     * @param role
     * @author　xuyongzhe
     * @brief 根据学校id和权限查询账号
     **/
    @Override
    public List<accountinfo> findAccountByScAndRole(String scid, int role) {
        List<accountinfo> list = new ArrayList<>();
        try {
            String sql = "select a.aci_id,a.aci_code,a.aci_pwd,a.aci_phone,a.aci_key,a.aci_role,a.sci_id,b.sci_name "  +
                   " from accountinfo a  inner join  schoolinfo b on a.sci_id  = b.sci_id where sci_id = ? and aci_role = ?";
            list = jdbc.query(sql, new Object[]{scid,role}, new BeanPropertyRowMapper(accountinfo.class));
        } catch (Exception e) {
        }
        return list;
    }
}
