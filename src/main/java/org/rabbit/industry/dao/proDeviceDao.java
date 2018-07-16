package org.rabbit.industry.dao;

import org.rabbit.industry.model.projectdevice;

public interface proDeviceDao {
    projectdevice selProIdByDeviceId(String deviceId);

    int addProDev(String did,int pid);
}
