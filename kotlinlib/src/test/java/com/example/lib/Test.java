package com.example.lib;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class Test {
    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept( Chain chain) throws IOException {
                return chain.proceed(chain.request());
            }
        }).build();
    }
}
