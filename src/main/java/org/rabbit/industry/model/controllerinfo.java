package org.rabbit.industry.model;

public class controllerinfo  {
    private int coi_seq;
    private String li_id;
    private String coi_valuetype;
    private String coi_value;
    private String sei_id;

    public controllerinfo() {
    }

    public int getCoi_seq() {
        return coi_seq;
    }

    public void setCoi_seq(int coi_seq) {
        this.coi_seq = coi_seq;
    }

    public String getLi_id() {
        return li_id;
    }

    public void setLi_id(String li_id) {
        this.li_id = li_id;
    }

    public String getCoi_valuetype() {
        return coi_valuetype;
    }

    public void setCoi_valuetype(String coi_valuetype) {
        this.coi_valuetype = coi_valuetype;
    }

    public String getCoi_value() {
        return coi_value;
    }

    public void setCoi_value(String coi_value) {
        this.coi_value = coi_value;
    }

    public String getSei_id() {
        return sei_id;
    }

    public void setSei_id(String sei_id) {
        this.sei_id = sei_id;
    }
}
