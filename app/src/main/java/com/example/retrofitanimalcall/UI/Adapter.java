package com.example.retrofitanimalcall.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitanimalcall.R;
import com.example.retrofitanimalcall.model.Animalmodel;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
    private List<Animalmodel> animalmodels=new ArrayList<>();

    public void setlist (List<Animalmodel> animalmodels) {
        this.animalmodels = animalmodels;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Animalmodel animal =animalmodels.get(position);
        holder.animalname.setText(animal.getName());
        holder.animalclassname.setText(animal.getClassname());
        holder.animalfamilyname.setText(animal.getFamily());


    }

    @Override
    public int getItemCount() {
        return animalmodels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView animalname;
        TextView animalclassname;
        TextView animalfamilyname;
        CardView cardView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            animalname=itemView.findViewById(R.id.textView);
            animalclassname=itemView.findViewById(R.id.textView2);
            animalfamilyname=itemView.findViewById(R.id.textView3);
            cardView=itemView.findViewById(R.id.card);
        }
    }
}
