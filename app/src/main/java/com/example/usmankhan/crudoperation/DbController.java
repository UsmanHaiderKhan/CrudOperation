package com.example.usmankhan.crudoperation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class DbController extends SQLiteOpenHelper {


    public DbController(Context context,String s, SQLiteDatabase.CursorFactory factory,int version) {
        super( context, "StudentDatabase.db", factory, version);
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
    public void AddStudent(String fullname,String degreename,String year ){
        ContentValues cv=new ContentValues();
        cv.put( "FULLNAME",fullname );
        cv.put("DEGREENAME",degreename);
        cv.put( "YEAR",year );
        this.getWritableDatabase().insertOrThrow( "STUDENT","",cv );
    }
    public void delete_student(String fullname)
    {
    this.getWritableDatabase().delete("STUDENT","FULLNAME='"+fullname+"'",null);
    }
    public void update_student(String old_fullname,String new_fullname){
        this.getWritableDatabase().execSQL( "UPDATE STUDENT SET FULLNAME='"+new_fullname+"'WHERE FULLNAME'"+old_fullname+"'");

    }
      public void all_students(TextView textView)
      {
          Cursor cursor=this.getReadableDatabase().rawQuery( "SELECT * FROM STUDENT",null );
          textView.setText( "" );
          while (cursor.moveToNext())
            {
                textView.append( cursor.getString( 1 )+" "+cursor.getString( 2 )+" "+cursor.getString( 3 ) );
            }
      }
}
