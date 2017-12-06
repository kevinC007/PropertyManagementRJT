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

	public PropertyItem(String id, String propertyaddress, String propertycity, String propertystate, String propertycountry, String propertypurchaseprice, String propertymortageinfo) {
		this.id = id;
		this.propertyaddress = propertyaddress;
		this.propertycity = propertycity;
		this.propertystate = propertystate;
		this.propertycountry = propertycountry;
		this.propertypurchaseprice = propertypurchaseprice;
		this.propertymortageinfo = propertymortageinfo;
	}

}