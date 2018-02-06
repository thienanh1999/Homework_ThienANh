package com.example.jinny.lesson5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView GvGallery;
    public static int count = 9;
    //public static ImageModel image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    private void setupUI() {
        GvGallery = findViewById(R.id.gv_gallery);

       // image.path = R.drawable.food;

        gridImageAdapter ImageAdapter = new gridImageAdapter(this);
        GvGallery.setAdapter(ImageAdapter);
    }
}
