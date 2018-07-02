package org.rabbit.industry.dao;

import org.rabbit.industry.model.tranTypeInfo;

import java.util.List;

public interface tranTypeDao {
    List<tranTypeInfo> findTranType();
    int addTranType(tranTypeInfo t);
}
