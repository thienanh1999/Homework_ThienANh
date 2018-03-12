package com.example.jinny.story;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinny.story.Database.StoryModel;
import com.squareup.picasso.Picasso;

public class StoryActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvAuthor;
    TextView tvDescription;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        StoryModel storyModel = (StoryModel) getIntent().getSerializableExtra("story");

        tvAuthor = findViewById(R.id.tv_author);
        tvTitle = findViewById(R.id.tv_name);
        tvDescription = findViewById(R.id.tv_detail);
        ivImage = findViewById(R.id.iv_image);

        tvTitle.setText(storyModel.title);
        tvAuthor.setText(storyModel.author);
        tvDescription.setText(storyModel.description);
        Picasso.get().load(storyModel.image).resize(100,100).into(ivImage);
    }
}
