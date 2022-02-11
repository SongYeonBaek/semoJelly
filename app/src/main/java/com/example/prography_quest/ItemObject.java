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

    /*
    public static ArrayList<ItemObject> createContactsList(int numContacts) {
        ArrayList<ItemObject> contacts = new ArrayList<ItemObject>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new ItemObject("Pororo ", "me", "I love prororo", "i", "s"));
        }

        return contacts;
    } */
}
