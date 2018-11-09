package com.example.edu.viewholderrecyclerview1109;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TooManyListenersException;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    ArrayList<HashMap<String,Object>> arrayList = null;
    public RecyclerAdapter(ArrayList<HashMap<String,Object>>arrayList){
        this.arrayList = new ArrayList<HashMap<String, Object>>();
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.item_cardlayout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        HashMap<String,Object> hashMap = arrayList.get(position);
        holder.itemTitle.setText((String)hashMap.get("title"));
        holder.itemImage.setImageResource((Integer)hashMap.get("image"));
        holder.itemTitle.setText("0");
        holder.itemTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
                Integer count = Integer.parseInt((holder.itemTitle).getText().toString())+1;
                (holder.itemTitle).setText(count.toString());


            }
        });
    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class  MyViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemTitle, itemDetail;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail = (TextView)itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    removeItem(position);
                    Log.d("ViewHolder Click", position+","+getItemId());
                }
            });
        }
    }
    public void removeItem(int position){
        this.arrayList.remove(position);
        notifyDataSetChanged();
    }

    private SQLiteDatabase mdb;
    public RecyclerAdapter(SQLiteDatabase db){
        this.mdb = db;

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String date = format.format(new Date());

//        String query = "SELECT * FROM ORDERED";
        String query = "INSERT INTO ORDERED Values(1,'"+date+"',null);";
        Cursor cursor = mdb.rawQuery(query,null);
        ArrayList<HashMap<String,Object>>arrayListTemp = new ArrayList<>();
        HashMap<String,Object> hashMap = null;
        while (cursor.moveToNext()){
            hashMap = new HashMap<String, Object>();
            hashMap.put("itemTitle",cursor.getString(0));
            arrayList.add(hashMap);
        }
        this.arrayList = arrayListTemp;
    }



}
