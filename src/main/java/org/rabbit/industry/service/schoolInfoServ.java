package org.rabbit.industry.service;

import org.rabbit.industry.model.schoolinfo;

import java.util.List;

public interface schoolInfoServ {
    boolean addSchoolInfo(String json);
    boolean delScholl(String json);
    boolean updateSchool(String json);
    String  findSchool();
    String  findSchoolById(String id);
}
