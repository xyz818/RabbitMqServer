package org.rabbit.industry.model;

public class schoolinfo {
    private String sci_id;   //id
    private String sci_name; //名称
    private String sci_city;  //城市
    private String sci_person;//联系人
    private String sci_phone;//电话
    private String sci_address;//地址



    private String sci_brief;//简介

    public schoolinfo() {
    }


    public String getSci_id() {
        return sci_id;
    }

    public void setSci_id(String sci_id) {
        this.sci_id = sci_id;
    }

    public String getSci_name() {
        return sci_name;
    }

    public void setSci_name(String sci_name) {
        this.sci_name = sci_name;
    }

    public String getSci_city() {
        return sci_city;
    }

    public void setSci_city(String sci_city) {
        this.sci_city = sci_city;
    }

    public String getSci_person() {
        return sci_person;
    }

    public void setSci_person(String sci_person) {
        this.sci_person = sci_person;
    }

    public String getSci_phone() {
        return sci_phone;
    }

    public void setSci_phone(String sci_phone) {
        this.sci_phone = sci_phone;
    }

    public String getSci_address() {
        return sci_address;
    }

    public void setSci_address(String sci_address) {
        this.sci_address = sci_address;
    }

    public String getSci_brief() {
        return sci_brief;
    }

    public void setSci_brief(String sci_brief) {
        this.sci_brief = sci_brief;
    }
}
