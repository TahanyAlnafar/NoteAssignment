package com.example.firestoreassignment;

public class Note {
    String id;
    String title;

    private Note(){}
    Note(String id, String title) {
        this.id = id;
        this.title = title;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


}
