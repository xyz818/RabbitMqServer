package org.rabbit.industry.dao;

import org.rabbit.industry.model.schoolinfo;

import java.util.List;

public interface schoolInfoDao {
    int addSchool(schoolinfo s);
    int delScholl(schoolinfo s);
    int updateSchool(schoolinfo s);
    List<schoolinfo> findSchool();
    schoolinfo findSchoolById(String sid);
}
