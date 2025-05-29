package com.example.diplom;

import java.util.Scanner;

public class init {
    public static void loadfiles (){
        kurs Kurs = new kurs();
        Scanner scanner = new Scanner(System.in);
        int j = 0;

        Kurs.set_name();
        Kurs.set_des();
        System.out.print("enter count of sections: ");
        j = scanner.nextInt();
        for (int i = 0; i < j; i++) {
            Kurs.add_sec();
        }
        Kurs.kurs_info();
    }
}
