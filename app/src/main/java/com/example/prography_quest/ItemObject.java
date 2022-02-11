package com.example.prography_quest;

import java.util.ArrayList;

public class ItemObject {
    private String title;
    private String director;
    private String story;
    private String score;
    private String image;

    public ItemObject(String title, String director, String story, String score, String image) {
        this.title = title;
        this.director = director;
        this.story = story;
        this.score = score;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getStory() {
        return story;
    }

    public String getScore() {
        return score;
    }

    public String getImage() {
        return image;
    }

}
