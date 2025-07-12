package com.example.diplom;

import android.graphics.Bitmap;
import android.view.View;
import java.util.ArrayList;

public class kurs {
    public int id;
    public String title;
    public String description;
    public static ArrayList<razdel> sections = new ArrayList<>();
    public Bitmap Preview;
    private transient View itemView;   // transient - чтобы избежать сериализации

    public void setItemView(View view) {
        this.itemView = view;
    }

    public kurs(int id, String name, String des, Bitmap preview) {
        this.id = id;
        this.title = name;
        this.description = des;
        this.Preview = preview;
    }
    public void set_name(String name) {
        title = name;
    }

    public void set_des(String des) {
        description = des;
    }

    public String get_title() {
        return title;
    }
    public Bitmap get_preview() {
        return Preview;
    }
    public String get_des() {
        return description;
    }
    public int get_id() {
        return id;
    }
    public static void add_sec(String name, String des) {
        razdel el = new razdel();
        el.set_name(name);
        el.set_des(des);
        //прописать процесс добавления документа в случае нажатия на кнопку в приложении (или при сохранении заготовки)
        sections.add(el);
    }

    public static void del_sec(int pos){
        sections.remove(pos);
    }

    public void kurs_info(){ //как прототип решения для просмотра материалов курса
        System.out.println(title);
        System.out.println(description);
        int k = sections.size();
        razdel el = new razdel();
        String el_title = "";
        String el_des = "";
        for (int i = 0; i < k; i+=1){
            el_title = el.title;  //получаем данные по разделам. В дальнейшем нужно подтянуть список элементов
            el_des = el.description;
            System.out.print("Section ");  //выводим в консоль
            System.out.print(i+1);
            System.out.print(": ");
            System.out.println(el_title);
            System.out.println(el_des);
        }
    }
}
