package org.rabbit.industry.service.imp;

import org.rabbit.industry.dao.historyDao;
import org.rabbit.industry.model.historyrecord;
import org.rabbit.industry.service.historyServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServImp implements historyServ {

    @Autowired
    private historyDao hd;

    @Override
    public boolean saveHistory(historyrecord hi) {
        if (hd.saveHistory(hi) > 0)
            return true;
        return false;
    }
}
