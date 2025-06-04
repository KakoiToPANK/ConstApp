package com.example.diplom;

import java.util.ArrayList;
import java.util.Scanner;
public class razdel {
    public String title;
    public String description;
    public static ArrayList<document> documents = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void mksection() {
    }
    public void set_name(String name) {
        this.title = name;
    }
    public void set_doclist(ArrayList<document> doc) {
        this.documents = doc;
    }
    public void set_des(String des) {
        this.description = des;
    }
    public void add_doc(String name, String ref, int id) {
        document el = new document();
        el.setDoc_id(id);
        el.setDoc_name(name);
        el.setRef(ref);
        documents.add(el);
    }
    public static void del_doc(int pos) {
        documents.remove(pos);
    }
    public static document get_doc(int pos) {
        return documents.get(pos);
    }
    public ArrayList<document> getDocuments() {
        return documents;
    }
    public String getTitle() {
        return title;
    }
}
