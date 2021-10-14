 package com.sas.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sas.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

     ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //making all the variables below final so that can be accessed from the inner class setOnClickListener
        final int image = getIntent().getIntExtra("Image",0);
        final int price;
        if(getIntent().getStringExtra("Price")!=null) {
            price = Integer.parseInt(getIntent().getStringExtra("Price"));
        }else{
            price =0;
        }
        final String name = getIntent().getStringExtra("name");
        final String description = getIntent().getStringExtra("desc");

        binding.detailImage.setImageResource(image);
        binding.priceLbl.setText(String.format("%d",price));
        binding.productName.setText(name);
        binding.detailDescription.setText(description);

        final DbHelper helper = new DbHelper(this);

        binding.orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean isInserted = helper.insertOrder(
                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        Integer.parseInt(binding.quantity.getText().toString()),
                        description,
                        name
                );
               if(isInserted){
                   Toast.makeText(DetailActivity.this,"Data Success",Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(DetailActivity.this,"Error",Toast.LENGTH_SHORT).show();
               }
            }
        });


    }
}