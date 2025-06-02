package com.example.diplom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class courseUseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_use);
    }
    public void openMainActivity(View view) {
        Intent intent = new Intent(this, mainActivity.class);
        startActivity(intent);
        finish();
    }
    public void openPluggerActivity(View view) {
        Intent intent = new Intent(this, PluggerActivity.class);
        startActivity(intent);
    }
}