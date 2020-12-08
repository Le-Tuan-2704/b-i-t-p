package com.example.listviewexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.listviewexamples.adapters.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class GridImageActivity extends AppCompatActivity {

    List<Integer> thumbnails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_image);

        thumbnails = new ArrayList<>();
        thumbnails.add(R.drawable.thumb1);
        thumbnails.add(R.drawable.thumb2);
        thumbnails.add(R.drawable.thumb3);
        thumbnails.add(R.drawable.thumb4);
        thumbnails.add(R.drawable.thumb5);
        thumbnails.add(R.drawable.thumb6);
        thumbnails.add(R.drawable.thumb7);
        thumbnails.add(R.drawable.thumb8);
        thumbnails.add(R.drawable.thumb9);
        thumbnails.add(R.drawable.thumb10);
        thumbnails.add(R.drawable.thumb11);
        thumbnails.add(R.drawable.thumb12);

        ImageAdapter adapter = new ImageAdapter(this, thumbnails);
        GridView gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
    }
}