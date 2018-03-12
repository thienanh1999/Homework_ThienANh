package com.example.jinny.story;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinny.story.Database.StoryModel;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class StoryActivity extends AppCompatActivity {

    private static final String TAG = "StoryActivity";
    TextView tvTitle;
    TextView tvAuthor;
    TextView tvDescription;
    ImageView ivImage;
    ImageView ivBookmark;
    StoryModel storyModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);

        storyModel = (StoryModel) getIntent().getSerializableExtra("story");

        tvAuthor = findViewById(R.id.tv_author);
        tvTitle = findViewById(R.id.tv_name);
        tvDescription = findViewById(R.id.tv_detail);
        ivImage = findViewById(R.id.iv_image);
        ivBookmark = findViewById(R.id.iv_bookmark);

        tvTitle.setText(storyModel.title);
        tvAuthor.setText(storyModel.author);
        tvDescription.setText(storyModel.description);
        Picasso.get().load(storyModel.image).resize(100, 100).into(ivImage);
    }

    @OnClick(R.id.iv_bookmark)
    public void onViewClicked() {
        DatabaseManager.getInstance(this).bookmark(storyModel);
        Log.d(TAG, "éc éc");
    }
}
