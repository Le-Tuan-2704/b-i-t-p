package com.example.listviewexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.listviewexamples.adapters.MessageAdapter;
import com.example.listviewexamples.models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class LeftRightListActivity extends AppCompatActivity {

    List<MessageModel> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_right_list);

        messages = new ArrayList<>();
        messages.add(new MessageModel(R.drawable.thumb1, "user1", "Hello"));
        messages.add(new MessageModel(R.drawable.thumb2, "me", "Hi"));
        messages.add(new MessageModel(R.drawable.thumb1, "user1", "How are you?"));
        messages.add(new MessageModel(R.drawable.thumb2, "me", "Great"));
        messages.add(new MessageModel(R.drawable.thumb1, "user1", "OK"));

        MessageAdapter adapter = new MessageAdapter(messages, this);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}