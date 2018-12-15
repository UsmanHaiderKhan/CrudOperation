package com.example.usmankhan.crudoperation;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbController extends SQLiteOpenHelper {


    public DbController(Context context., SQLiteDatabase.CursorFactory factory,int version) {
        super( context, "Student.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          db.execSQL( " CREATE TABLE STUDENT(ID INTEGER PRIMARY KEY AUTOINCREMENT, FULLNAME TEXT UNIQUE, DEGREENAME TEXT, YEAR TEXT );" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( " DROP TABLE  IF EXISTS STUDENT;" );
        onCreate( db );

    }
    public void AddStudent(String fullname,,String degreename,String year ){

    }
}
