package com.example.listviewexamples.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    Context context;
    List<Integer> thumbnails;
    int imageSize;

    public ImageAdapter(Context context, List<Integer> thumbnails) {
        this.context = context;
        this.thumbnails = thumbnails;

        // Lay kich thuoc man hinh thiet bi
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        imageSize = metrics.widthPixels / 3;
    }

    @Override
    public int getCount() {
        return thumbnails.size();
    }

    @Override
    public Object getItem(int i) {
        return thumbnails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(imageSize, imageSize));
        }
        else
            imageView = (ImageView) view;

        imageView.setImageResource(thumbnails.get(i));

        return imageView;
    }
}
