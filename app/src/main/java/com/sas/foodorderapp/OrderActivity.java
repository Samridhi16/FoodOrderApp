package com.sas.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.sas.foodorderapp.Adaptors.OrdersAdapter;
import com.sas.foodorderapp.Models.OrderModel;
import com.sas.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        ArrayList<OrderModel> list = new ArrayList<>();

        DbHelper helper = new DbHelper(this);
        ArrayList<OrderModel> list = helper.getOrders();


//        list.add(new OrderModel(R.drawable.burger,"CheeseBurger","4","34256738"));
//        list.add(new OrderModel(R.drawable.burger,"CheeseBurger","4","34256738"));
//        list.add(new OrderModel(R.drawable.burger,"CheeseBurger","4","34256738"));
//        list.add(new OrderModel(R.drawable.burger,"CheeseBurger","4","34256738"));
//        list.add(new OrderModel(R.drawable.burger,"CheeseBurger","4","34256738"));
//        list.add(new OrderModel(R.drawable.burger,"CheeseBurger","4","34256738"));
//        list.add(new OrderModel(R.drawable.burger,"CheeseBurger","4","34256738"));
//        list.add(new OrderModel(R.drawable.burger,"CheeseBurger","4","34256738"));

        OrdersAdapter adapter = new OrdersAdapter(list,this);
        binding.orderRecylerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecylerView.setLayoutManager(layoutManager);

    }
}