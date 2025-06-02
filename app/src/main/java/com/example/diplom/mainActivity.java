package com.example.diplom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

    public class mainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            TextView FIO = findViewById(R.id.textView5);
            FIO.setText("ФАМИЛИЯ ИМЯ ОТЧЕСТВО");

            RecyclerView recyclerView = findViewById(R.id.RecyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            List<Object> items = new ArrayList<>();
            items.add(new kurs(1, "Курс по Java"));
            items.add(new kurs(2, "Курс по Android"));
            items.add(new kurs(3, "Курс по Java"));
            items.add(new kurs(4, "Курс по Android"));

            CustomAdapter adapter = new CustomAdapter(items);
            recyclerView.setAdapter(adapter);
    }
    public void openPluggerActivity(View view) {
        Intent intent = new Intent(this, PluggerActivity.class);
        startActivity(intent);
    }
    public void openConstructorActivity(View view) {
        Intent intent = new Intent(this, constructorActivity.class);
        startActivity(intent);
    }
    public void onExitButtonClick(View view) {
        finishAffinity();
    }
    public void openMainActivity(View view) {
        Intent intent = new Intent(this, mainActivity.class);
        startActivity(intent);
        finish();
        }
    public void openCourseUseActivity(View view) {
        Intent intent = new Intent(this, courseUseActivity.class);
        startActivity(intent);
        }
    }

