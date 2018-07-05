package org.rabbit.industry.dao;

import org.rabbit.industry.model.accountinfo;

import java.util.List;

public interface accountDao {
    /**
     * @brief 验证登录信息
     * @param pwsd  密码
     * @param id  id号
     * */
     int verify(String id,String pwsd);



    /**
     * @brief更新用户信息
     * @param a 账户信息
     * */
     int updateAccount(accountinfo a);

    /**
     * @brief 更新密码信息
     * @param a
     *
     * */
     int updatePwsd(accountinfo a);


     /**
      * @brief 查询所有的用户信息
      *
      * */
     List<accountinfo> findAccount();

    /**
     * @brief 根据学校查询用户信息
     * @param sid 学校id号
     *
     * */
     List<accountinfo> findAccount(String sid);

    /**
     *
     * @brief 根据用户信息查询信息
     *
     * */
     accountinfo findAccountByAid(String aid);

     /**
      * @brief 添加用户信息
      * @param a  用户信息
      * */
     int addAccountInfo(accountinfo a);

     /**
      * @brief 删除用户信息
      * @param aid  用户id号
      *
      * */
     int delAccountInfo(String aid);

}
