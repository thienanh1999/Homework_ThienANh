package com.example.jinny.story.Adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jinny.story.Database.StoryModel;
import com.example.jinny.story.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class StoryListViewAdapter extends BaseAdapter {
    List<StoryModel> storyModelList;

    public StoryListViewAdapter(List<StoryModel> storyModelList) {
        this.storyModelList = storyModelList;
    }

    @Override
    public int getCount() {
        return storyModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return storyModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        view = layoutInflater.inflate(R.layout.item_story,viewGroup, false);

        StoryModel storyModel = storyModelList.get(i);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvAuthor = view.findViewById(R.id.tv_author);
        ImageView ivImage = view.findViewById(R.id.iv_image);
        LinearLayout llBookmark = view.findViewById(R.id.ll_bookmark);

        tvAuthor.setText(storyModel.author);
        tvTitle.setText(storyModel.title);
        Picasso.get().load(storyModel.image).resize(200,200).into(ivImage);
        if (storyModel.bookmark == 1) llBookmark.setBackgroundColor(Color.RED);

        return view;
    }
}