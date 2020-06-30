package com.example.multiscreen_hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "Assignment.multiscreen_hello.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button to Second Activity
        Button Welcome = findViewById(R.id.Welcome);
        Welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondScreen();
            }
        });

    }

    private void openSecondScreen() {
        EditText User_Name = findViewById(R.id.User_Name);
        String text = User_Name.getText().toString();

        Intent intent = new Intent(MainActivity.this, SecondScreen.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }

}
