package org.rabbit.industry.service.imp;

import org.rabbit.industry.dao.proDeviceDao;
import org.rabbit.industry.model.projectdevice;
import org.rabbit.industry.service.proDeviceServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class proDevServImp implements proDeviceServ {
    @Autowired
    proDeviceDao pdd;
    @Override
    public int selProjectIdByDeviceID(String id) {
        projectdevice  p = pdd.selProIdByDeviceId(id);
        if(p!=null)
            return p.getPi_seq();
        return 0;
    }
}
