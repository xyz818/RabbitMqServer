package org.rabbit.industry.dao;

import org.rabbit.industry.model.loginrecord;

import java.sql.Timestamp;
import java.util.List;

public interface loginRecorDao {
    List<loginrecord> findLogincRecordByTime(Timestamp start, Timestamp end);
    String findLoginRecordByUser(String accountid);
    String findLoginRecordByThing(String json);
    int addLoginRecord(loginrecord lr);
}
