package com.sas.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.sas.foodorderapp.Adaptors.MainAdaptor;
import com.sas.foodorderapp.Adaptors.OrdersAdapter;
import com.sas.foodorderapp.Models.MainModel;
import com.sas.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger,"Burger","6","Chicken Burger with extra cheese"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","12","Buffalo Chicken Pizza"));
        list.add(new MainModel(R.drawable.blueberrycheesecake,"Blueberry Cheescake","5","Blueberry Cheesecake"));
        list.add(new MainModel(R.drawable.sub,"Sub","10","Italian Bread Sub with Chicken patty, honey mustard,lettuce,pepper jack cheese and dill pickels"));
        list.add(new MainModel(R.drawable.tacos,"Tacos","8","Tacos"));
        list.add(new MainModel(R.drawable.donuts,"Donuts","6","Chocolate donuts"));
  

        MainAdaptor adaptor = new MainAdaptor(list,this);
        binding.recylcerView.setAdapter(adaptor);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recylcerView.setLayoutManager(linearLayoutManager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}