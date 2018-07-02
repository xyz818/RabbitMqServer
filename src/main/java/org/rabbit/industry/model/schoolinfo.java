package org.rabbit.industry.model;

public class schoolinfo {
    private String id;   //id
    private String name; //名称
    private String city;  //城市
    private String person;//联系人
    private String phone;//电话
    private String address;//地址
    private String brief;//简介


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public schoolinfo()
    {

    }
    //构造函数
    public schoolinfo(String id,String name,String city,String person,String phone,String address,String breif)
    {
        this.id = id;
        this.name = name;
        this.city = city;
        this.person = person;
        this.phone = phone;
        this.address = address;
        this.brief = breif;

    }




}
