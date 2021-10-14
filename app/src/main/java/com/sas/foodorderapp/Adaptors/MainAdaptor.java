package com.sas.foodorderapp.Adaptors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sas.foodorderapp.DetailActivity;
import com.sas.foodorderapp.Models.MainModel;
import com.sas.foodorderapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdaptor extends RecyclerView.Adapter<MainAdaptor.viewHolder> {

    ArrayList<MainModel> list;
    Context context;

    public MainAdaptor(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final MainModel model = list.get(position);
        holder.foodImage.setImageResource(model.getImage());
        holder.mainName.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("Image",model.getImage());
                intent.putExtra("Price",model.getPrice());
                intent.putExtra("desc",model.getDescription());
                intent.putExtra("name",model.getName());
                context.startActivity(intent);
            }
        });

//        holder.itemView.setOnClickListener(view -> {
//            Intent intent = new Intent(context,DetailActivity.class);
//            intent.putExtra("Image",model.getImage());
//            intent.putExtra("Price",model.getPrice());
//            intent.putExtra("desc",model.getDescription());
//            intent.putExtra("name",model.getName());
//            context.startActivity(intent);
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView mainName, price,description;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.imageView);
            mainName = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.orderPrice);
            description = itemView.findViewById(R.id.description);
        }
    }
}
