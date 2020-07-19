package com.myfirstapplication.ashirraja.roomdatabase.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class student {

    @PrimaryKey (autoGenerate = true)
    int id;

    String firstname;
    String lastname;
    String st_class;

    public student( String firstname, String lastname, String st_class) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.st_class = st_class;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSt_class() {
        return st_class;
    }

    public void setSt_class(String st_class) {
        this.st_class = st_class;
    }
}
