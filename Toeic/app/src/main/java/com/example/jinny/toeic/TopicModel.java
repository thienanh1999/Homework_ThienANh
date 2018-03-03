package com.example.jinny.toeic;

public class TopicModel {
    public  int id;
    public String name;
    public String imageUrl;
    public String category;
    public String color;
    public String lastTime;

    public TopicModel(int id, String name, String imageUrl, String category, String color, String lastTime) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
        this.color = color;
        this.lastTime = lastTime;
    }

    @Override
    public String toString() {
        return "TopicModel{" +
                "name='" + name + '\'' +
                '}';
    }
}