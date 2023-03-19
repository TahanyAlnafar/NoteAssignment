package com.example.firestoreassignment;

class Note{
    String id;
    String title;
    String content;
    private  Note(){}
    Note(String id, String title ,String content) {
        this.id = id;
        this.title = title;
        this.content = content;

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
    public String getContent(){
        return content;
    }

}