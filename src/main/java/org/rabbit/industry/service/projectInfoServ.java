package org.rabbit.industry.service;

import org.rabbit.industry.model.projectinfo;

import java.util.List;

public interface projectInfoServ {
    /**
     * @brief 查询项目
     * */
    String findProJect();


    String findProjectByAccount(String id);

    /**
     * @brief 添加项目
     * @param json 项目
     * */
    boolean addProject(String json);

    boolean updateProject(String  json);

    boolean delProject(int p);

    String findProject(String id);
    boolean updateProjectStatus(String json);

}
