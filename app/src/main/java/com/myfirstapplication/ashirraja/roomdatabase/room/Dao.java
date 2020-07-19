package com.myfirstapplication.ashirraja.roomdatabase.room;

import java.util.List;

import androidx.room.Insert;
import androidx.room.Query;

@androidx.room.Dao
public interface Dao {

    @Insert
    public void insert(student mstudent);

    @Query("SELECT * FROM student")
    public List<student> getAllStudents();
}
