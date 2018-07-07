package org.rabbit.industry.dao;

import org.rabbit.industry.model.projecttype;

import java.util.List;

public interface projectTypeDao {
    /**
     * @breief 查询所有项目类型
     * */
    List<projecttype> findProjectType();



    /**
     * @brief 添加项目类型
     *
     * */
    int addProjectType(projecttype p);
}
