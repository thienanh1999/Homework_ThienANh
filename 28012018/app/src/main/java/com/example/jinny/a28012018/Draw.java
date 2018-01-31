package com.example.jinny.a28012018;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class Draw extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "DrawActivity";
    private ImageView ivColor;
    private ImageView ivDone;
    private RadioButton rbthin;
    private RadioButton rbmedium;
    private RadioButton rbstrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        setupUI();
    }

    private void setupUI()
    {
        ivColor = findViewById(R.id.iv_colorlens);
        ivDone = findViewById(R.id.iv_done);
        rbthin = findViewById(R.id.rb_thin);
        rbmedium = findViewById(R.id.rb_medium);
        rbstrong = findViewById(R.id.rb_strong);

        ivColor.setOnClickListener(this);
        ivDone.setOnClickListener(this);
        rbthin.setOnClickListener(this);
        rbmedium.setOnClickListener(this);
        rbstrong.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.iv_colorlens:
            {
                ColorPickerDialogBuilder
                        .with(this)
                        .setTitle("Choose color")
                        .initialColor(-65472)
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(12)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {
                                Log.d(TAG, "onColorSelected: " + selectedColor);

                            }
                        })
                        .setPositiveButton("ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .build()
                        .show();
                break;
            }
            case R.id.iv_done: {
                break;
            }
            case R.id.rb_thin: {
                Log.d(TAG, "thin");
                break;
            }
            case R.id.rb_medium: {
                Log.d(TAG , "medium");
                break;
            }
            case R.id.rb_strong: {
                Log.d(TAG , "strong");
                break;
            }
        }
    }
}
