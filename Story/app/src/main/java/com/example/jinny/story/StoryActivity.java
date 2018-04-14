package com.example.jinny.story;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    ImageView ivBookmarked;
    Button btRead;
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
        btRead = findViewById(R.id.bt_read);
        ivBookmarked = findViewById(R.id.iv_bookmarked);

        tvTitle.setText(storyModel.title);
        tvAuthor.setText(storyModel.author);
        tvDescription.setText(storyModel.description);
        Picasso.get().load(storyModel.image).resize(100, 100).into(ivImage);
        if (storyModel.bookmark == 1) ivBookmarked.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.iv_bookmark, R.id.bt_read})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_bookmark:
                DatabaseManager.getInstance(this).bookmark(storyModel);
                ivBookmarked.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_read:
                Intent intent = new Intent(StoryActivity.this, ReadActivity.class);
                intent.putExtra("story", storyModel);
                startActivity(intent);
                break;
        }
    }
}