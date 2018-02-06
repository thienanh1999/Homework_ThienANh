package com.example.jinny.lesson5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class gridImageAdapter extends BaseAdapter{
    Context context;
    public gridImageAdapter (Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount() {
        return MainActivity.count;
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return  0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout ll_image = new LinearLayout(context);
        ll_image.setOrientation(LinearLayout.VERTICAL);
        ll_image.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 250));
        ll_image.setPadding(0,0,0,5);

        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8,8,8,8);
        imageView.setCropToPadding(true);
        imageView.setImageResource(R.drawable.food);

        TextView textView = new TextView(context);
        textView.setText("food");
        textView.setTextColor(Color.parseColor("#FF020202"));
        textView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);

        ll_image.addView(imageView);
        ll_image.addView(textView);

        return ll_image;
    }
}