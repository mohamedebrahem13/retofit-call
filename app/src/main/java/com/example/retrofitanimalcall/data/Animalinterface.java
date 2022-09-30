package com.example.retrofitanimalcall.data;
import com.example.retrofitanimalcall.model.Arrayresponse;
import retrofit2.Call;
import retrofit2.http.GET;



public interface Animalinterface {

    @GET("/all")
    Call<Arrayresponse> getanimal();
}
