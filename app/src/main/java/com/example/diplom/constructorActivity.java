package com.example.diplom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class constructorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_constructor);
    }
    public void openPluggerActivity(View view) {
        Intent intent = new Intent(this, PluggerActivity.class);
        startActivity(intent);
    }

}