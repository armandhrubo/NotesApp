package com.example.editablenotepad.models;


public class Note {

    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String title;
    private String note;
    private String timestamp;

    public Note() {

    }

    public Note(int id, String title, String note, String timestamp) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.timestamp = timestamp;
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

    public String getTimestamp() {
        return timestamp;
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

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}