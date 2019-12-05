package com.example.mvp_android;

public class Note {

    private long id;
    private String note;
    private String date;

    public Note(long id, String note, String date)
    {
        this.id=id;
        this.note=note;
        this.date=date;
    }

    private long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id= id;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note=note;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date=date;
    }
}
