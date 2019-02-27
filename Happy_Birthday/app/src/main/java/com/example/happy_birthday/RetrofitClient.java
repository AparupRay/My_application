package com.example.happy_birthday;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient(){

        retrofit = new Retrofit.Builder()
                .baseUrl(LoginApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){

        if(mInstance == null)
            mInstance = new RetrofitClient();
        return mInstance;
    }

    public LoginApi getApi(){

        return retrofit.create(LoginApi.class);
    }
}
