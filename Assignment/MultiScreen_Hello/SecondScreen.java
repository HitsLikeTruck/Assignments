package com.example.multiscreen_hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {
    // public static final String EXTRA_TEXT = "Assignment.multiscreen_hello.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Receiving Input from MainActivity
        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        TextView User_Name = findViewById(R.id.User_Name);
        User_Name.setText("Hello, " + text + "!");
    }
}
