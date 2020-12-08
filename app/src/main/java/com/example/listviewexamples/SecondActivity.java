package com.example.listviewexamples;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.listviewexamples.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<ItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        items = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            items.add(new ItemModel("Title " + i, "Subtitle " + i));

        ArrayAdapter<ItemModel> adapter = new ArrayAdapter<ItemModel>(this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1,
                items) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textTitle = view.findViewById(android.R.id.text1);
                TextView textSubtitle = view.findViewById(android.R.id.text2);

                ItemModel item = items.get(position);
                textTitle.setText(item.getTitle());
                textSubtitle.setText(item.getSubTitle());

                return view;
            }
        };

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}