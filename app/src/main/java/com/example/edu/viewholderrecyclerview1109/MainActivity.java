package com.example.edu.viewholderrecyclerview1109;

import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;

    MyDBOpenHelper dbHelper;
    SQLiteDatabase mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDBOpenHelper(this, "order.db", null, 1);
        mdb = dbHelper.getWritableDatabase();
        adapter = new RecyclerAdapter(mdb);


        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.addItemAction);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,Object> hashMap = new HashMap<String,Object>();
                hashMap.put("title","Chapter One");
                hashMap.put("Image", R.drawable.android_image_1);
                adapter.addItem(1,hashMap);
            }
        });

//        ArrayList로 표현
//        ArrayList<HashMap<String,Object>> arrayList = new ArrayList<HashMap<String, Object>>();
//        HashMap<String,Object> hashMap = null;
//        hashMap = new HashMap<String, Object>();
//        hashMap.put("title","Chapter One");
//        hashMap.put("detail","Item one details");
//        hashMap.put("image", R.drawable.android_image_1);
//        arrayList.add(hashMap);
//
//        hashMap = null;
//        hashMap = new HashMap<String, Object>();
//        hashMap.put("title","Chapter Two");
//        hashMap.put("detail","Item two details");
//        hashMap.put("image", R.drawable.android_image_2);
//        arrayList.add(hashMap);
//
//        hashMap = null;
//        hashMap = new HashMap<String, Object>();
//        hashMap.put("title","Chapter Three");
//        hashMap.put("detail","Item three details");
//        hashMap.put("image", R.drawable.android_image_3);
//        arrayList.add(hashMap);
//
//        hashMap = null;
//        hashMap = new HashMap<String, Object>();
//        hashMap.put("title","Chapter Four");
//        hashMap.put("detail","Item four details");
//        hashMap.put("image", R.drawable.android_image_4);
//        arrayList.add(hashMap);
//
//        hashMap = null;
//        hashMap = new HashMap<String, Object>();
//        hashMap.put("title","Chapter Five");
//        hashMap.put("detail","Item five details");
//        hashMap.put("image", R.drawable.android_image_5);
//        arrayList.add(hashMap);
//
//        hashMap = null;
//        hashMap = new HashMap<String, Object>();
//        hashMap.put("title","Chapter Six");
//        hashMap.put("detail","Item six details");
//        hashMap.put("image", R.drawable.android_image_6);
//        arrayList.add(hashMap);
//
//        hashMap = null;
//        hashMap = new HashMap<String, Object>();
//        hashMap.put("title","Chapter Seven");
//        hashMap.put("detail","Item seven details");
//        hashMap.put("image", R.drawable.android_image_7);
//        arrayList.add(hashMap);
//
//        hashMap = null;
//        hashMap = new HashMap<String, Object>();
//        hashMap.put("title","Chapter Eight");
//        hashMap.put("detail","Item eight details");
//        hashMap.put("image", R.drawable.android_image_8);
//        arrayList.add(hashMap);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
//        GridLayoutManager column값을 줘야한다.
//        layoutManager =new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

//        ArrayList로
//        adapter = new RecyclerAdapter(arrayList);


        recyclerView.setAdapter(adapter);




    }
}
