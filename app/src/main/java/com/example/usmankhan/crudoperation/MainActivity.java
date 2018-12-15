package com.example.usmankhan.crudoperation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText fullname,degree,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        fullname=(EditText)findViewById( R.id.stu_name );
        degree=(EditText)findViewById( R.id.deg_name );
        year=(EditText)findViewById( R.id.std_year );
    }
}
