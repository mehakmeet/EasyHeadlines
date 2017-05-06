package com.example.mehakmeet.newsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;


public class MainActivity extends AppCompatActivity {

    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    public static String Extra="abc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {


                        Intent i = new Intent(getApplicationContext(),Intented_Activity.class);
                        i.putExtra(Extra,String.valueOf(position));
                        startActivity(i);
                    }
                })
        );

    }
}