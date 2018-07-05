package org.rabbit.industry.service.imp;

import org.rabbit.industry.dao.schoolInfoDao;
import org.rabbit.industry.service.schoolInfoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class schoolInfoServImp implements schoolInfoServ {

    @Autowired
    schoolInfoDao sid;

    @Override
    public boolean addSchoolInfo(String json) {
        try
        {

        }catch (Exception e)
        {
        }




        return false;
    }
}
