package com.sas.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sas.foodorderapp.Models.OrderModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context,  DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table orders"+
                        "(id integer primary key autoincrement," +
                        "name text,"+
                        "phone text,"+
                        "price int ,"+
                        "image int,"+
                        "quantity int,"+
                        "description text,"+
                        "foodname text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists orders");
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String name,String phone,int price,int image,int quantity,String desc,String foodName){
        SQLiteDatabase database = getReadableDatabase();
        //just like hashmap...to put values in database(key=column,value=entry)
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("quantity",quantity);
        values.put("description",desc);
        values.put("foodName",foodName);
        long id = database.insert("orders",null,values);
        if(id <=0){
            return false;
        }
        return true;
    }
    public ArrayList<OrderModel>getOrders(){
        ArrayList<OrderModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price from orders",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrderModel model = new OrderModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }


}
