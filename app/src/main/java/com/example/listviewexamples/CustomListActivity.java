package com.example.listviewexamples;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listviewexamples.adapters.CustomAdapter;
import com.example.listviewexamples.models.CustomItemModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.bloco.faker.Faker;

public class CustomListActivity extends AppCompatActivity {

    List<CustomItemModel> items;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        Faker faker = new Faker();

        items = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            String name = faker.name.name();
            String textAvt = name.substring(0,1);
            String title = faker.lorem.sentence().substring(0, 20) + "...";
            Date time = faker.date.forward();

            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

            String timecv = df.format(time);
            items.add(new CustomItemModel(textAvt, name, title, timecv));
        }

        adapter = new CustomAdapter(this, items);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_view, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menuSearch).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(CustomListActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText.trim());
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}