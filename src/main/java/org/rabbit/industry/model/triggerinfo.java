package org.rabbit.industry.model;

public class triggerinfo {
    private int tri_seq;
    private String li_id;
    private int tri_valuetype;
    private int tri_limit;
    private String tri_value;
    private String sei_id;

    public triggerinfo() {
    }

    public int getTri_seq() {
        return tri_seq;
    }

    public void setTri_seq(int tri_seq) {
        this.tri_seq = tri_seq;
    }

    public String getLi_id() {
        return li_id;
    }

    public void setLi_id(String li_id) {
        this.li_id = li_id;
    }

    public int getTri_valuetype() {
        return tri_valuetype;
    }

    public void setTri_valuetype(int tri_valuetype) {
        this.tri_valuetype = tri_valuetype;
    }

    public int getTri_limit() {
        return tri_limit;
    }

    public void setTri_limit(int tri_limit) {
        this.tri_limit = tri_limit;
    }

    public String getTri_value() {
        return tri_value;
    }

    public void setTri_value(String tri_value) {
        this.tri_value = tri_value;
    }

    public String getSei_id() {
        return sei_id;
    }

    public void setSei_id(String sei_id) {
        this.sei_id = sei_id;
    }
}
