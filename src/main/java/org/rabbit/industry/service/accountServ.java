package org.rabbit.industry.service;

import org.rabbit.industry.model.accountinfo;

import java.util.List;

public interface accountServ {
    /**
     * @brief 验证登录服务接口
     * @param json  身份id
     * @return  是否成功
     * */
    boolean verifyLogin(String json);

    /**
     * @brief 更新用户信息
     * @param json  json格式数据
     *
     * */
    boolean updateAccount(String json);



    /**
     * @brief 更新密码
     * */
    boolean updatePwsd(String json);



    /**
     * @brief 查询所有的用户信息
     *
     * */
    String findAccount();

    /**
     * @brief 根据学校查询用户信息
     * @param sid 学校id号
     *
     * */
    String findAccount(String sid);

    /**
     *
     * @brief 根据用户信息查询信息
     *
     * */
    String findAccountByAid(String aid);

    /**
     * @brief 添加用户信息
     * @param json  用户信息
     * */
    boolean addAccountInfo(String json);

    /**
     * @brief 删除用户信息
     * @param aid  用户id号
     *
     * */
    boolean delAccountInfo(String aid);

    /**
     * @param
     * @author　xuyongzhe
     * @brief 根据权限查询
     **/
    String findAccountByRole(int role);


    /**
     * @param
     * @author　xuyongzhe
     * @brief 根据权限查询
     **/
    String findAccountByScAndRole(String scid,int role);

}
