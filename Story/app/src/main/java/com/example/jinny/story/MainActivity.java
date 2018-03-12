package com.example.jinny.story;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        lvStory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StoryModel storyModel = storyModelList.get(i);
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtra("story", storyModel);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<StoryModel> storyModelList = DatabaseManager.getInstance(this).getListStory();
        StoryListViewAdapter storyListViewAdapter = new StoryListViewAdapter(storyModelList);
        lvStory.setAdapter(storyListViewAdapter);
    }
}
