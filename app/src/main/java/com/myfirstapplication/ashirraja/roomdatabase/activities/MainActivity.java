package com.myfirstapplication.ashirraja.roomdatabase.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.myfirstapplication.ashirraja.roomdatabase.R;
import com.myfirstapplication.ashirraja.roomdatabase.room.Database;
import com.myfirstapplication.ashirraja.roomdatabase.room.student;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText fName, lName, stClass;
    Button submit, getdata;
    Database mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fName=(EditText)findViewById(R.id.firstname);
        lName=(EditText)findViewById(R.id.lastname);
        stClass=(EditText)findViewById(R.id.stclass);
        submit=(Button) findViewById(R.id.submit);
        getdata=(Button)findViewById(R.id.getdata);
        setDB();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!fName.getText().toString().trim().isEmpty() && !fName.getText().toString().trim().isEmpty() &&
                !fName.getText().toString().trim().isEmpty()){

                    student  mStudent= new student(fName.getText().toString().trim(), lName.getText().toString().trim(),stClass.getText().toString().trim());

                    mDatabase= Room.databaseBuilder(MainActivity.this, Database.class, "studenttb")
                            .allowMainThreadQueries().build();

                    mDatabase.dao().insert(mStudent);
                }

            }
        });

        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               List<student> stList= mDatabase.dao().getAllStudents();

               for(int i =0; i<stList.size(); i++){
                   Log.d("TAG", "onClick: Name is -> "+ stList.get(i).getFirstname());
               }
            }
        });


    }


    public void setDB()
    {
         mDatabase= Room.databaseBuilder(MainActivity.this, Database.class, "studenttb")
                .allowMainThreadQueries().build();
    }
}
