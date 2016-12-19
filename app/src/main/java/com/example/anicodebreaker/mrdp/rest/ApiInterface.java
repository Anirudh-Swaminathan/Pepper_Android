package com.example.anicodebreaker.mrdp.rest;

import com.example.anicodebreaker.mrdp.model.RoboCall;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/**
 * Created by anicodebreaker on 20/12/16.
 */
public interface ApiInterface {
    @Headers("Authorization:Bearer e13f26177f1f47ef8208acfc6fb39c34")
    @GET("/api/query")
    Call<RoboCall> callRobot(@QueryMap Map<String, String> options);
}
