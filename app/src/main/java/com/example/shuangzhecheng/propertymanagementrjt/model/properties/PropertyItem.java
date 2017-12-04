package com.example.shuangzhecheng.propertymanagementrjt.model.properties;

public class PropertyItem{

    public String id;
	public String propertyaddress;
	public String propertycity;
	public String propertystate;
	public String propertycountry;
	public String propertystatus;
	public String propertypurchaseprice;
	public String propertymortageinfo;

    public PropertyItem(String id, String propertyaddress, String propertycity, String propertystate, String propertycountry, String propertystatus, String propertypurchaseprice, String propertymortageinfo) {
        this.id = id;
        this.propertyaddress = propertyaddress;
        this.propertycity = propertycity;
        this.propertystate = propertystate;
        this.propertycountry = propertycountry;
        this.propertystatus = propertystatus;
        this.propertypurchaseprice = propertypurchaseprice;
        this.propertymortageinfo = propertymortageinfo;
    }

    public String getId() {
        return id;
    }

    public String getPropertyaddress() {
        return propertyaddress;
    }

    public String getPropertycity() {
        return propertycity;
    }

    public String getPropertystate() {
        return propertystate;
    }

    public String getPropertycountry() {
        return propertycountry;
    }

    public String getPropertystatus() {
        return propertystatus;
    }

    public String getPropertypurchaseprice() {
        return propertypurchaseprice;
    }

    public String getPropertymortageinfo() {
        return propertymortageinfo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPropertyaddress(String propertyaddress) {
        this.propertyaddress = propertyaddress;
    }

    public void setPropertycity(String propertycity) {
        this.propertycity = propertycity;
    }

    public void setPropertystate(String propertystate) {
        this.propertystate = propertystate;
    }

    public void setPropertycountry(String propertycountry) {
        this.propertycountry = propertycountry;
    }

    public void setPropertystatus(String propertystatus) {
        this.propertystatus = propertystatus;
    }

    public void setPropertypurchaseprice(String propertypurchaseprice) {
        this.propertypurchaseprice = propertypurchaseprice;
    }

    public void setPropertymortageinfo(String propertymortageinfo) {
        this.propertymortageinfo = propertymortageinfo;
    }
}