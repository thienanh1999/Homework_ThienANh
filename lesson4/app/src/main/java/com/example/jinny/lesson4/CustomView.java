package com.example.bm.homework;

import android.content.Context;
import android.widget.ImageView;

import com.example.jinny.lesson4.R;

public class CustomView extends ImageView {

    private static final String TAG = "CustomView";

    public CustomView(Context context) {
        super(context);

        int randomNum = (int) (Math.random() * 5000 + 1);
        switch (randomNum % 5) {
            case 0:
                setBackgroundResource(R.drawable.food_1);
                break;
            case 1:
                setBackgroundResource(R.drawable.food_2);
                break;
            case 2:
                setBackgroundResource(R.drawable.food_3);
                break;
            case 3:
                setBackgroundResource(R.drawable.food_4);
                break;
            case 4:
                setBackgroundResource(R.drawable.food_5);
                break;
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width / 2;

        setMeasuredDimension(width, height);
    }
}
