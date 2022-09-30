package com.example.retrofitanimalcall.UI;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.retrofitanimalcall.data.Animalclient;

import com.example.retrofitanimalcall.model.Animalmodel;
import com.example.retrofitanimalcall.model.Arrayresponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Animalviewmodel extends ViewModel {
    List<Animalmodel>animalmodels;
    MutableLiveData<List<Animalmodel>> AnimalMutableLiveData = new MutableLiveData<>();

    public void getanimals() {
        Animalclient.getINSTANCE().getanimals().enqueue(new Callback<Arrayresponse>() {
            @Override
            public void onResponse(Call<Arrayresponse> call, Response<Arrayresponse> response) {
                Arrayresponse arrayresponse=response.body();
                animalmodels=new ArrayList<>(Arrays.asList(arrayresponse.getAnimals()));
                AnimalMutableLiveData.setValue(animalmodels);

            }

            @Override
            public void onFailure(Call<Arrayresponse> call, Throwable t) {

            }
        });


    }
}

