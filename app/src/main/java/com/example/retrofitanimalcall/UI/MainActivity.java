package com.example.retrofitanimalcall.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.retrofitanimalcall.R;
import com.example.retrofitanimalcall.model.Animalmodel;
import java.util.List;


public class MainActivity extends AppCompatActivity {
Animalviewmodel animalviewmodel;
    RecyclerView recyclerView;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        animalviewmodel= ViewModelProviders.of(this).get(Animalviewmodel.class);
        animalviewmodel.getanimals();
        animalviewmodel.AnimalMutableLiveData.observe(this, new Observer<List<Animalmodel>>() {
            @Override
            public void onChanged(List<Animalmodel> animalmodels) {
                adapter.setlist(animalmodels);
            }
        });


    }
}