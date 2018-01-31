package com.example.jinny.a28012018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fb_camera;
    private FloatingActionButton fb_edit;
    private FloatingActionMenu fb_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    private void setupUI()
    {
        fb_camera = findViewById(R.id.bt_camera);
        fb_edit = findViewById(R.id.bt_edit);
        fb_menu = findViewById(R.id.fl_actionmenu);

        fb_camera.setOnClickListener(this);
        fb_edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Draw.class);
        startActivity(intent);

        fb_menu.close(false);
    }
}
