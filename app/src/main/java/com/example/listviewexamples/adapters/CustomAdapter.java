package com.example.listviewexamples.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.listviewexamples.R;
import com.example.listviewexamples.models.CustomItemModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<CustomItemModel> items;
    ArrayList<CustomItemModel> arrayList;

    public CustomAdapter(Context context, List<CustomItemModel> items) {
        this.context = context;
        this.items = items;

        this.arrayList = new ArrayList<CustomItemModel>();
        this.arrayList.addAll(items);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_custom_item, viewGroup, false);
            viewHolder = new ViewHolder();
//            viewHolder.imageAvatar = view.findViewById(R.id.image_avatar);
            viewHolder.textAvt = view.findViewById(R.id.image_avatar);
            viewHolder.textTitle = view.findViewById(R.id.text_title);
            viewHolder.textSubtitle = view.findViewById(R.id.text_sub_title);
            viewHolder.onClick = view.findViewById(R.id.check_selected);
            viewHolder.time = view.findViewById(R.id.text_time);
            view.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder)view.getTag();

        CustomItemModel item = items.get(i);
//        viewHolder.imageAvatar.setImageResource(item.getAvatarResource());
        viewHolder.textAvt.setText(item.getTextAvt());
        viewHolder.textTitle.setText(item.getTitle());
        viewHolder.textSubtitle.setText(item.getSubtitle());
        viewHolder.time.setText(item.getTime());

        viewHolder.onClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewHolder.check == false) {
                    viewHolder.onClick.setBackgroundResource(R.drawable.ic_baseline_star_24);
                    viewHolder.check = true;
                } else {
                    viewHolder.onClick.setBackgroundResource(R.drawable.ic_baseline_star_border_24);
                    viewHolder.check = false;
                }

                notifyDataSetChanged();
            }
        });

        return view;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        items.clear();
        if(charText.length() == 0) {
            items.addAll(arrayList);
        } else {
            for(CustomItemModel item: arrayList) {
                if(item.getTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                    items.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    private class ViewHolder {
//        ImageView imageAvatar;
        TextView textAvt;
        TextView textTitle;
        TextView textSubtitle;
        TextView time;
        ImageButton onClick;
        boolean check = false;
    }
}
