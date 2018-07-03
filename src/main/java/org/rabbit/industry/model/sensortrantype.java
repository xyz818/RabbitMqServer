package org.rabbit.industry.model;
//传感器协议关联表sensortrantype
public class sensortrantype {
    private int stt_seq;//自增id
    private String sti_id;//传感器类型id
    private  String tti_id;//传输类型id
    private  String stt_param;//保留字段
    public sensortrantype(){}

    public sensortrantype(int stt_seq, String sti_id, String tti_id, String stt_param) {
        this.stt_seq = stt_seq;
        this.sti_id = sti_id;
        this.tti_id = tti_id;
        this.stt_param = stt_param;
    }

    public int getStt_seq() {
        return stt_seq;
    }

    public void setStt_seq(int stt_seq) {
        this.stt_seq = stt_seq;
    }

    public String getSti_id() {
        return sti_id;
    }

    public void setSti_id(String sti_id) {
        this.sti_id = sti_id;
    }

    public String getTti_id() {
        return tti_id;
    }

    public void setTti_id(String tti_id) {
        this.tti_id = tti_id;
    }

    public String getStt_param() {
        return stt_param;
    }

    public void setStt_param(String stt_param) {
        this.stt_param = stt_param;
    }
}
