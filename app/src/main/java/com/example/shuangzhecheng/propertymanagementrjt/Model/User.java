package com.example.shuangzhecheng.propertymanagementrjt.Model;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("msg")
	private String msg;

	@SerializedName("usertype")
	private String usertype;

	@SerializedName("appapikey")
	private String appapikey;

	@SerializedName("userid")
	private String userid;

	@SerializedName("useremail")
	private String useremail;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setUsertype(String usertype){
		this.usertype = usertype;
	}

	public String getUsertype(){
		return usertype;
	}

	public void setAppapikey(String appapikey){
		this.appapikey = appapikey;
	}

	public String getAppapikey(){
		return appapikey;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}

	public String getUserid(){
		return userid;
	}

	public void setUseremail(String useremail){
		this.useremail = useremail;
	}

	public String getUseremail(){
		return useremail;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"msg = '" + msg + '\'' + 
			",usertype = '" + usertype + '\'' + 
			",appapikey = '" + appapikey + '\'' + 
			",userid = '" + userid + '\'' + 
			",useremail = '" + useremail + '\'' + 
			"}";
		}
}