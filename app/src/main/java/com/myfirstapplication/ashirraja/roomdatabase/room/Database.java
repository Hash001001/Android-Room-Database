package com.myfirstapplication.ashirraja.roomdatabase.room;


import androidx.room.RoomDatabase;

@androidx.room.Database(entities = student.class, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract Dao dao();

}
