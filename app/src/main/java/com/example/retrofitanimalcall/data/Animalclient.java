package com.example.retrofitanimalcall.data;

import com.example.retrofitanimalcall.model.Arrayresponse;

import java.io.IOException;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Animalclient {
    private static final String BASE_URL = "https://animaliapi3.p.rapidapi.com";
    private Animalinterface animalinterface;
    private static Animalclient INSTANCE;
    private static final String key="0212e391ccmshae45317eb3cdd0ep1df2f6jsn03f4dd1cf8cd";
    private static final String host="animaliapi3.p.rapidapi.com";


    public Animalclient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("X-RapidAPI-Key",key)
                        .header("X-RapidAPI-Host",host)
                        .build();
                return chain.proceed(request);


            }
        });
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        animalinterface = retrofit.create(Animalinterface.class);
    }

    public static Animalclient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new Animalclient();
        }
        return INSTANCE;
    }
    public Call<Arrayresponse> getanimals(){
        return animalinterface.getanimal();
    }
}
