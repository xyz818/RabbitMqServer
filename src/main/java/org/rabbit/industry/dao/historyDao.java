package org.rabbit.industry.dao;

import org.rabbit.industry.model.historyrecord;

import java.util.List;

public interface historyDao {
     /**
      * @param   hi　历史数据类
      * @author　xuyongzhe
      * @brief 保存历史数据
      **/
     int saveHistory(historyrecord hi);


     List<historyrecord> findHistroyInfo(int pid, String seid, String startTime, String endTime);



}
