package com.example.diplom;

import java.util.ArrayList;
import java.util.Scanner;
public class razdel {
    static public String title;
    static public String description;
    public static ArrayList<Integer> documents = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void set_name() {
        System.out.print("enter name of section: ");
        title = scanner.nextLine();
    }
    public static void set_des() {
        System.out.print("enter description: ");
        description = scanner.nextLine();
    }
    public static void add_doc() {
        System.out.print("enter document (number)");
        int el = scanner.nextInt();
        documents.add(el);
    }

    public static void del_doc(int pos) {
        documents.remove(pos);
    }

    public static int get_doc(int pos) {
        return documents.get(pos);
    }
}
