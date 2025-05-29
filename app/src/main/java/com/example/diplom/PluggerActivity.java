package com.example.diplom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PluggerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plugger);
    }
    public void openMainActivity(View view) {
        Intent intent = new Intent(this, mainActivity.class);
        startActivity(intent);
        finish();
    }
}
