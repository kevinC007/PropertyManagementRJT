package com.example.shuangzhecheng.propertymanagementrjt.network;

import com.example.shuangzhecheng.propertymanagementrjt.Model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shuangzhecheng on 12/1/17.
 */

public interface ApiInterface {
    @GET("pro_mgt_login.php")
    Call<User> login(@Query("email") String email, @Query("password") String password);
    @GET("shop_reg.php")
    Call<String> getRegisterResponse(@Query("name") String name,
                                     @Query("email") String email,
                                     @Query("mobile") String mobile,
                                     @Query("password") String password);
}
