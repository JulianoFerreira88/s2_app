package br.com.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.Serializable;

public class RetrofitBuilder implements Serializable {
    public static final String BASE_URL = "http://192.168.1.200:8081/";
    private static final long serialVersionUID = 1454741914422586938L;


    public static Retrofit build() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
