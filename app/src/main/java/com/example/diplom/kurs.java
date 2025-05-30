package com.example.diplom;

import java.util.ArrayList;
import java.util.Scanner;

public class kurs {
    public static int id;
    public static String title;
    static public String description;
    public static ArrayList<razdel> sections = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void set_name(String name) {
        title = name;
    }

    public static void set_des(String des) {
        description = des;
    }

    public String get_title() {
        return title;
    }

    public static void add_sec() { //в дальнейшем нужно будет прописать полноценный порядок работы с начальным заполнением и пр.
        int k = 0;
        razdel el = new razdel();
        el.set_name();
        el.set_des();
        System.out.print("enter count of documents: ");  //Эта строка заменится и будет выполняться по нажатию в приложении
        k = scanner.nextInt();
        for (int i=0; i<k; i+=1){
            el.add_doc();
        }
        sections.add(el);
    }

    public static void del_sec(int pos){
        sections.remove(pos);
    }

    public static void kurs_info(){ //как прототип решения для просмотра материалов курса
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
