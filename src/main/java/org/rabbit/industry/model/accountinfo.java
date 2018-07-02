package org.rabbit.industry.model;
/*
*
* @brief 账户信息表
*
* */
public class accountinfo {


    public accountinfo()
    {

    }
    public accountinfo(String id, String code, String pwsd, String iphone,String key,String scId)
    {
        this.id = id;
        this.code = code;
        this.pwsd = pwsd;
        this.phone = iphone;
        this.key = key;
        this.scId = scId;
    }

    private String id;//id号
    private String code;//用户明
    private String pwsd;//密码
    private String phone;//电话
    private String key;//秘钥
    private String scId;//学校id号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPwsd() {
        return pwsd;
    }

    public void setPwsd(String pwsd) {
        this.pwsd = pwsd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getScId() {
        return scId;
    }

    public void setScId(String scId) {
        this.scId = scId;
    }
}
