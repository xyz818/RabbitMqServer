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

    public String getSci_Id() {
        return sci_Id;
    }

    public void setSci_Id(String sci_Id) {
        this.sci_Id = sci_Id;
    }

    private String sci_Id;//学校id号

}
