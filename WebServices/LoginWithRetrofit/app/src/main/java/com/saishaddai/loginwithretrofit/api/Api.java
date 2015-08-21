package com.saishaddai.loginwithretrofit.api;

import com.saishaddai.loginwithretrofit.model.LoginRequest;
import com.saishaddai.loginwithretrofit.model.LoginResponse;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;


public interface Api {
    @POST("/")
    void login(@Body LoginRequest loginRequest, Callback<LoginResponse> response);

    @FormUrlEncoded
    @POST("/")
    void login(@Field("username") String username, @Field("password") String password, Callback<LoginResponse> response);

}
