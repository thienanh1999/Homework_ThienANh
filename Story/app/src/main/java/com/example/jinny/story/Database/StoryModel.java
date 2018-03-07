package com.example.jinny.story.Database;

import java.io.Serializable;

public class StoryModel implements Serializable {
    public int id;
    public String image;
    public String title;
    public String description;
    public String content;
    public String author;
    public int bookmark;

    public StoryModel(int id,String image, String title, String description, String content, String author, int bookmark) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.bookmark = bookmark;
    }
}