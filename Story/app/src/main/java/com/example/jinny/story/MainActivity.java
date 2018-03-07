package com.example.jinny.story;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.jinny.story.Adapter.StoryListViewAdapter;
import com.example.jinny.story.Database.StoryModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvStory;
    StoryListViewAdapter storyListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<StoryModel> storyModelList = DatabaseManager.getInstance(this).getListStory();
        lvStory = findViewById(R.id.lv_story);

        storyListViewAdapter = new StoryListViewAdapter(storyModelList);

        lvStory.setAdapter(storyListViewAdapter);
    }
}
