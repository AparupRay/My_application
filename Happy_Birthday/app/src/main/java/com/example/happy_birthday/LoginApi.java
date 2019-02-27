package com.example.happy_birthday;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginApi {

    String BASE_URL = "http://10.100.99.85:3000/user/";

    @GET("getUrl")
    Call<URLResponse> getUrl();

}
