package com.example.diplom;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
// Данная версия - не финальная. Многие вещи сделаны чтобы провести демонстрацию
public class mainActivity extends AppCompatActivity {
    static List<kurs> Citems = new ArrayList<>(); //поле для хранения курса

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView FIO = findViewById(R.id.textView5);
        FIO.setText("ФАМИЛИЯ ИМЯ ОТЧЕСТВО");

        RecyclerView recyclerView = findViewById(R.id.RecyclerViewFile);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Citems.add(new kurs(1, "Обучение безопасным методам и приемам выполнения работ", "Пробный курс, разработанный обучающимися каведры ТБ для наполнения приложения", BitmapFactory.decodeResource(getResources(), R.drawable.tb)));
        Citems.add(new kurs(2, "Тестовый курс", "Тестовый пустой курс для демонстрации работы с несколькими курсами", BitmapFactory.decodeResource(getResources(), R.drawable.java)));

        CustomAdapter adapter = new CustomAdapter(Citems);
        recyclerView.setAdapter(adapter);
        GetView(CustomAdapter.items); //получение измененного list
    }

    public List<kurs> GetView(List<kurs> insert) {   // В адаптере добавляются ссылки на view, а этот метод передает измененный list обратно
        Citems = insert;
        return Citems;
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

