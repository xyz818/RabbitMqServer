package org.rabbit.industry.dao;

import org.rabbit.industry.model.projectinfo;

import java.util.List;

public interface projectInfoDao {
    /**
     * @brief 查询项目
     * */
    List<projectinfo> findProJect();


    List<projectinfo> findProjectByAccount(String id);

    /**
     * @brief 添加项目
     * @param p 项目
     * */
    int addProject(projectinfo p);

    int updateProject(projectinfo p);

    int delProject(int p);

    projectinfo findProject(String id);

    int updateProjectStatus(projectinfo p);

}
