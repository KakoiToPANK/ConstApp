package com.example.diplom;
import com.example.diplom.razdel;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class courseUseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_use);


    RecyclerView sectionsRecycler = findViewById(R.id.SectionRecyclerView);
    sectionsRecycler.setLayoutManager(new LinearLayoutManager(this));
    List<razdel> sections = loadCourseSections();

    CourseSectionsAdapter adapter = new CourseSectionsAdapter(sections);
    sectionsRecycler.setAdapter(adapter);
    }

    private List<razdel> loadCourseSections() {
        ArrayList<razdel> sections = new ArrayList<>();   //список объектов типа "раздел"
        ArrayList<document> documents1 = new ArrayList<>();

        //тестовое заполнение документов и разделов. Потом надо убрать
        documents1.add(new document());
        documents1.add(new document());
        documents1.get(0).setDoc_name("Лекция 1");
        documents1.get(1).setDoc_name("Лекция 2");
        documents1.get(0).setDoc_id(0);
        documents1.get(1).setDoc_id(1);
        documents1.get(0).setRef("http://123");
        documents1.get(1).setRef("http://321");

        sections.add(new razdel());
        sections.get(0).set_name("Раздел 1");
        sections.get(0).set_des("Тестовый раздел для примера");
        sections.get(0).set_doclist(documents1);
        return sections;

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