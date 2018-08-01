package org.rabbit.industry.dao;

import org.rabbit.industry.model.historyrecord;

public interface historyDao {
     /**
      * @param   hi　历史数据类
      * @author　xuyongzhe
      * @brief 保存历史数据
      **/
     int saveHistory(historyrecord hi);
}
