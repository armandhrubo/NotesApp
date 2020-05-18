package com.example.editablenotepad.models;


import java.util.Date;

public class Note {

    private int id;
    private String title;
    private String note;
    private String date;

    public Note() {

    }

    public Note(int id,String title,String note) {
        this.id = id;
        this.title = title;
        this.note = note;
    }

    public Note(String title,String note) {
        this.title = title;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}