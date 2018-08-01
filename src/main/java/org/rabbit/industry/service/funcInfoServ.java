package org.rabbit.industry.service;

public interface funcInfoServ {
    String findFuncType();
    int addFuncType(String json);
    String selFuncByValue(String val);
}
