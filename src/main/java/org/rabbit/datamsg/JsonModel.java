package org.rabbit.datamsg;


public class JsonModel {
    public String fromWhere; //来自哪里
    public String localId; //本地id
    public String targetId; //目标id
    public String value; // 数值
    public int netType; //　网络传输类型
    public int sensorType; //　传感器类型
    public String voltage; //　电压
    public int func; //　功能
    public String tranType; //传输类型

    public int getSensorType() {
        return sensorType;
    }

    public void setSensorType(int sensorType) {
        this.sensorType = sensorType;
    }

    public int getFunc() {
        return func;
    }

    public void setFunc(int func) {
        this.func = func;
    }


    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }


    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNetType() {
        return netType;
    }

    public void setNetType(int netType) {
        this.netType = netType;
    }


    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }


}
