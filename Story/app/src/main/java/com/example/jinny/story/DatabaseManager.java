package com.example.jinny.story;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.jinny.story.Database.StoryModel;
import com.example.jinny.story.AssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String TABLE_SHORT_STORY = "tbl_short_story";
    private static final String TAG = "DatabaseManager";

    private SQLiteDatabase sqLiteDatabase;
    private AssetHelper assetHelper;

    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance(Context context) {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager(context);
        }
        return databaseManager;
    }

    public DatabaseManager(Context context) {
        assetHelper = new AssetHelper(context);
    }

    public List<StoryModel> getListStory() {
        sqLiteDatabase = assetHelper.getReadableDatabase();

        List<StoryModel> storyModelList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_SHORT_STORY, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String image = cursor.getString(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);
            int bookmark = cursor.getInt(6);

            StoryModel storyModel = new StoryModel(id, image, title, description, content, author, bookmark);
            storyModelList.add(storyModel);

            cursor.moveToNext();
        }

        return storyModelList;
    }

    public void bookmark(StoryModel storyModel) {
        sqLiteDatabase = assetHelper.getWritableDatabase();

        int bookmark = storyModel.bookmark;
        if (bookmark == 0) bookmark++;
        Log.d(TAG, "" + bookmark);

        ContentValues contentValues = new ContentValues();
        contentValues.put("bookmark", bookmark);
        sqLiteDatabase.update(TABLE_SHORT_STORY, contentValues, "id = " + storyModel.id, null);
    }
}