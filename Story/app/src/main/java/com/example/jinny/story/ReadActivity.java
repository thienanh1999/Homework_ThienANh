package com.example.jinny.story;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jinny.story.Database.StoryModel;

import butterknife.ButterKnife;

public class ReadActivity extends AppCompatActivity {

    StoryModel storyModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        ButterKnife.bind(this);

        storyModel = (StoryModel) getIntent().getSerializableExtra("story");
    }
}
