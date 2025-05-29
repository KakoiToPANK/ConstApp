package com.example.diplom;

import android.os.Bundle;
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

            CustomAdapter adapter = new CustomAdapter(items);
            recyclerView.setAdapter(adapter);
    }
}

