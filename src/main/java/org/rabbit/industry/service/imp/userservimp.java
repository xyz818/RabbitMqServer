package org.rabbit.industry.service.imp;

import org.rabbit.industry.dao.userdao;
import org.rabbit.industry.service.userserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userservimp implements userserv {
    @Autowired
    private userdao ud;

    @Override
    public int verify(String id, String pwsd) {
        return ud.verify(id,pwsd);
    }
}
