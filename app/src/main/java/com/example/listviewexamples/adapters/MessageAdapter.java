package com.example.listviewexamples.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listviewexamples.R;
import com.example.listviewexamples.models.MessageModel;

import java.util.List;

public class MessageAdapter extends BaseAdapter {
    List<MessageModel> messages;
    Context context;

    public MessageAdapter(List<MessageModel> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (messages.get(position).getUsername().equals("me"))
            return 1;
        else
            return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            if (getItemViewType(i) == 0)
                view = LayoutInflater.from(context).inflate(R.layout.layout_left_item, viewGroup, false);
            else
                view = LayoutInflater.from(context).inflate(R.layout.layout_right_item, viewGroup, false);
        }

        ImageView imageAvatar = view.findViewById(R.id.image_avatar);
        TextView textUsername = view.findViewById(R.id.text_username);
        TextView textMessage = view.findViewById(R.id.text_message);

        MessageModel item = (MessageModel) getItem(i);

        imageAvatar.setImageResource(item.getAvatarResource());
        textUsername.setText(item.getUsername());
        textMessage.setText(item.getMessage());

        return view;
    }
}
