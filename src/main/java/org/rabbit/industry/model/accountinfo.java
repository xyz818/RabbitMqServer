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

    private String aci_id;//id号
    private String aci_code;//用户明
    private String aci_pwd;//密码
    private String aci_phone;//电话
    private String aci_key;//秘钥

    public String getAci_id() {
        return aci_id;
    }

    public void setAci_id(String aci_id) {
        this.aci_id = aci_id;
    }

    public String getAci_code() {
        return aci_code;
    }

    public void setAci_code(String aci_code) {
        this.aci_code = aci_code;
    }

    public String getAci_pwd() {
        return aci_pwd;
    }

    public void setAci_pwd(String aci_pwd) {
        this.aci_pwd = aci_pwd;
    }

    public String getAci_phone() {
        return aci_phone;
    }

    public void setAci_phone(String aci_phone) {
        this.aci_phone = aci_phone;
    }

    public String getAci_key() {
        return aci_key;
    }

    public void setAci_key(String aci_key) {
        this.aci_key = aci_key;
    }



    public short getAci_role() {
        return aci_role;
    }

    public void setAci_role(short aci_role) {
        this.aci_role = aci_role;
    }

    public String getSci_id() {
        return sci_id;
    }

    public void setSci_id(String sci_id) {
        this.sci_id = sci_id;
    }

    private short aci_role;
    private String sci_id;//学校id号

}
