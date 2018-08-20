package org.rabbit.industry.service;

import org.rabbit.industry.model.historyrecord;

public interface historyServ {
    boolean saveHistory(historyrecord hi);
    String findHistroyByTime(String json);
}
