package org.rabbit.industry.model;
//传感器类型表
public class sensorTypeInfo {
    private String sti_id;//传感器类型
    private String sti_name;//传感器名称
    private String sti_unit;//传感器单位
    private short sti_control;//控制类型
    private String sti_param;
    public sensorTypeInfo(){}

    public sensorTypeInfo(String sti_id, String sti_name, String sti_unit, short sti_control, String sti_param) {
        this.sti_id = sti_id;
        this.sti_name = sti_name;
        this.sti_unit = sti_unit;
        this.sti_control = sti_control;
        this.sti_param = sti_param;
    }

    public String getSti_id() {
        return sti_id;
    }

    public void setSti_id(String sti_id) {
        this.sti_id = sti_id;
    }

    public String getSti_name() {
        return sti_name;
    }

    public void setSti_name(String sti_name) {
        this.sti_name = sti_name;
    }

    public String getSti_unit() {
        return sti_unit;
    }

    public void setSti_unit(String sti_unit) {
        this.sti_unit = sti_unit;
    }

    public short getSti_control() {
        return sti_control;
    }

    public void setSti_control(short sti_control) {
        this.sti_control = sti_control;
    }

    public String getSti_param() {
        return sti_param;
    }

    public void setSti_param(String sti_param) {
        this.sti_param = sti_param;
    }
}
