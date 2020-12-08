package com.example.listviewexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    List<String> items;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            items.add("Item " + i);

//        adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, items);

        adapter = new ArrayAdapter<>(this, R.layout.layout_item, R.id.text_view, items);

        ListView listView = findViewById(R.id.my_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = items.get(i);
                Log.v("TAG", "Selected: " + item);
            }
        });

        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = items.get(0);
                item = "Updated item 0";
                items.set(0, item);
                Log.v("TAG", items.get(0));

                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.btn_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(0);
                items.remove(0);
                items.remove(0);
                items.remove(0);
                items.remove(0);

                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(0, "New item 0");
                items.add(0, "New item 1");
                items.add(0, "New item 2");
                items.add(0, "New item 3");
                items.add(0, "New item 4");

                adapter.notifyDataSetChanged();
            }
        });
    }
}