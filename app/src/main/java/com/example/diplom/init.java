package com.example.diplom;

import java.util.Scanner;

public class init {
    public String name, des;
    public static void loadfiles (){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String des = scanner.nextLine();
        kurs Kurs = new kurs(1, name);

        int j = 0;
        Kurs.set_des(des);
        System.out.print("enter count of sections: ");
        j = scanner.nextInt();
        for (int i = 0; i < j; i++) {
            name = scanner.nextLine();
            des = scanner.nextLine();
            Kurs.add_sec(name, des);
        }
        Kurs.kurs_info();
    }
}
