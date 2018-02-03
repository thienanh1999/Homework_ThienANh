package com.example.jinny.lesson4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private LinearLayout LlGallery;
    private com.getbase.floatingactionbutton.FloatingActionButton FbAdd;
    private Button BtAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FbAdd = findViewById(R.id.fb_add);
        LlGallery = findViewById(R.id.ll_Gallery);
        BtAdd = findViewById(R.id.bt_add);

        BtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                ImageView image = new ImageView(getApplicationContext());
                int n = 1 + (int)(Math.random()*5);
                switch (n)
                {
                    case 1:
                    {
                        image.setBackgroundResource(R.drawable.food_1);
                        break;
                    }
                    case 2:
                    {
                        image.setBackgroundResource(R.drawable.food_2);
                        break;
                    }
                    case 3:
                    {
                        image.setBackgroundResource(R.drawable.food_3);
                        break;
                    }
                    case 4:
                    {
                        image.setBackgroundResource(R.drawable.food_4);
                        break;
                    }
                    case 5:
                    {
                        image.setBackgroundResource(R.drawable.food_5);
                        break;
                    }
                }

               /* int width = image.getWidth();
                int height = width / 2;*/

                //image.setMeasuredDimension(width, height);

                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );
                layout.setMargins(10,10,10,10);
                image.setLayoutParams(layout);
                LlGallery.addView(image);
            }
        });
    }
}
