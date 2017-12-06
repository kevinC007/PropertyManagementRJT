package com.example.shuangzhecheng.propertymanagementrjt.network;

import com.example.shuangzhecheng.propertymanagementrjt.Model.Geocode;
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
    @GET("pro_mgt_reg.php")
    Call<String> register(@Query("email") String email,
                                     @Query("password") String password,
                                     @Query("account_for") String accountType);
    @GET("pro_mgt_reg.php")
    Call<String> registertenant(@Query("email") String email,@Query("landlord_email") String landlordemail,
                          @Query("password") String password,
                          @Query("account_for") String accountType);
    @GET("/maps/api/geocode/json")
    Call<Geocode> getlanlang(@Query("address") String address, @Query("apiKey") String apiKey);
}
