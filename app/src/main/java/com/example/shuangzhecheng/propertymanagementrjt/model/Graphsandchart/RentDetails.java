package com.example.shuangzhecheng.propertymanagementrjt.model.Graphsandchart;

/**
 * Created by joel on 12/4/2017.
 */

public class RentDetails {

    public String id;
    public String propertyaddress;
    public String propertycity;
    public String propertystate;
    public String propertycountry;
    public String propertystatus;
    public String propertypurchaseprice;
    public String propertymortageinfo;

    public RentDetails(String id, String propertyaddress, String propertycity, String propertystate, String propertycountry, String propertypurchaseprice, String propertymortageinfo) {
        this.id = id;
        this.propertyaddress = propertyaddress;
        this.propertycity = propertycity;
        this.propertystate = propertystate;
        this.propertycountry = propertycountry;
        this.propertypurchaseprice = propertypurchaseprice;
        this.propertymortageinfo = propertymortageinfo;
    }
}

