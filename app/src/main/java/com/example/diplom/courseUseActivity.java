package com.example.diplom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class courseUseActivity extends AppCompatActivity {
    public TextView title;
    public TextView des;
    public ArrayList<document> Alldocuments = new ArrayList<>();
    ArrayList<razdel> Allsections = new ArrayList<>();
    public static ArrayList<document> OutDocs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_use);

        TextView FIO = findViewById(R.id.textView7);
        FIO.setText("ФАМИЛИЯ ИМЯ ОТЧЕСТВО");
        title = findViewById(R.id.textView10);
        des = findViewById(R.id.textView11);

        RecyclerView sectionsRecycler = findViewById(R.id.SectionRecyclerView);
        sectionsRecycler.setLayoutManager(new LinearLayoutManager(this));
        List<razdel> sections = loadCourseSections(CourseViewHolder.outID);

        for (kurs obj : mainActivity.Citems) {                                                      //сравнение всех курсов с tag кнопки
            if (obj.get_id() == CourseViewHolder.outID) {
                title.setText(obj.get_title());
                des.setText(obj.get_des());
            }
        }

        CourseSectionsAdapter adapter = new CourseSectionsAdapter(sections);
        sectionsRecycler.setAdapter(adapter);
    }
    private void docinit() {
        //тестовое заполнение документов и разделов. Сделано так из-за спешки. В дальнейшем переработать для БД
        for (int i = 0; i < 83; i++) {
            Alldocuments.add(new document());
        }

        Alldocuments.get(0).setDoc_name("Теоритическая часть");
        Alldocuments.get(0).setDoc_id(0);
        Alldocuments.get(0).setSectoin_id(1);
        Alldocuments.get(0).setRef("documents/Тема_1_1_1_Документы_необходимые_для_заключения_договора.html");

        Alldocuments.get(1).setDoc_name("Документы для договора (Презентация)");
        Alldocuments.get(1).setDoc_id(1);
        Alldocuments.get(1).setSectoin_id(1);
        Alldocuments.get(1).setRef("https://disk.yandex.ru/i/Mj4qIzihuLl_TA");

        Alldocuments.get(2).setDoc_name("Теоритическая часть");
        Alldocuments.get(2).setDoc_id(2);
        Alldocuments.get(2).setSectoin_id(1);
        Alldocuments.get(2).setRef("documents/Тема_1_1_2_Сведения,_указанные_в_договоре.html");

        Alldocuments.get(3).setDoc_name("Трудовой договор (Презентация)");
        Alldocuments.get(3).setDoc_id(3);
        Alldocuments.get(3).setSectoin_id(1);
        Alldocuments.get(3).setRef("https://disk.yandex.ru/i/L5lG_LY5oOKUXg");

        Alldocuments.get(4).setDoc_name("Теоритическая часть");
        Alldocuments.get(4).setDoc_id(4);
        Alldocuments.get(4).setSectoin_id(1);
        Alldocuments.get(4).setRef("documents/Тема_1_1_3_Роспись_и_ознакомление_работника.html");

        Alldocuments.get(5).setDoc_name("Роспись работника (Видео)");
        Alldocuments.get(5).setDoc_id(5);
        Alldocuments.get(5).setSectoin_id(1);
        Alldocuments.get(5).setRef("https://disk.yandex.ru/i/bb9wmJOsco0Kzg");

        Alldocuments.get(6).setDoc_name("Теоритическая часть");
        Alldocuments.get(6).setDoc_id(6);
        Alldocuments.get(6).setRef("documents/Тема 1.1.4. Виды инструктажей.html");
        Alldocuments.get(6).setSectoin_id(1);

        Alldocuments.get(7).setDoc_name("Виды инструктажей (Видео)");
        Alldocuments.get(7).setDoc_id(7);
        Alldocuments.get(7).setSectoin_id(1);
        Alldocuments.get(7).setRef("https://disk.yandex.ru/i/W-pTaF4fBM60kQ");

        Alldocuments.get(8).setDoc_name("Теоритическая часть");
        Alldocuments.get(8).setDoc_id(8);
        Alldocuments.get(8).setRef("documents/тема 1.1.5. Обучение по программам.html");
        Alldocuments.get(8).setSectoin_id(1);

        Alldocuments.get(9).setDoc_name("Обучение по программам (Презентация)");
        Alldocuments.get(9).setDoc_id(9);
        Alldocuments.get(9).setSectoin_id(1);
        Alldocuments.get(9).setRef("https://disk.yandex.ru/i/PMuPS_P8hA8USg");

        Alldocuments.get(10).setDoc_name("Теоритическая часть");
        Alldocuments.get(10).setDoc_id(10);
        Alldocuments.get(10).setSectoin_id(1);
        Alldocuments.get(10).setRef("documents/Тема_1_1_6_Протокол_реестра_Минтруда.html");
//Раздел 1.2
        Alldocuments.get(11).setDoc_name("Теоритическая часть");
        Alldocuments.get(11).setDoc_id(11);
        Alldocuments.get(11).setSectoin_id(2);
        Alldocuments.get(11).setRef("documents/Тема_1_2_1_Гарантии_и_компенсации_работникам.html");

        Alldocuments.get(12).setDoc_name("Гарантии и компенсации работникам (Презентация)");
        Alldocuments.get(12).setDoc_id(12);
        Alldocuments.get(12).setSectoin_id(2);
        Alldocuments.get(12).setRef("https://disk.yandex.ru/i/hHB78YSHtnf4Xg");

// Раздел 1.3
        Alldocuments.get(13).setDoc_name("Теоритическая часть");
        Alldocuments.get(13).setDoc_id(13);
        Alldocuments.get(13).setSectoin_id(3);
        Alldocuments.get(13).setRef("documents/Тема 1.3.1. Режимы труда и отдыха.html");

        Alldocuments.get(14).setDoc_name("Режимы труда и отдыха (Презентация)");
        Alldocuments.get(14).setDoc_id(14);
        Alldocuments.get(14).setSectoin_id(3);
        Alldocuments.get(14).setRef("https://disk.yandex.ru/i/a4tKIybgTX810A");

        Alldocuments.get(15).setDoc_name("Теоритическая часть");
        Alldocuments.get(15).setDoc_id(15);
        Alldocuments.get(15).setSectoin_id(3);
        Alldocuments.get(15).setRef("documents/Тема_1_3_2_Дополнительные_требования_в_теплый_и_холодный_период.html");

        Alldocuments.get(16).setDoc_name("Дополнительные требования в теплый и холодный период (Презентация)");
        Alldocuments.get(16).setDoc_id(16);
        Alldocuments.get(16).setSectoin_id(3);
        Alldocuments.get(16).setRef("https://disk.yandex.ru/i/ZZzKxvDhx6Bx2w");

// Раздел 2.1
        Alldocuments.get(17).setDoc_name("Теоритическая часть");
        Alldocuments.get(17).setDoc_id(17);
        Alldocuments.get(17).setSectoin_id(5);
        Alldocuments.get(17).setRef("documents/Тема_2_1_1_Вредные_факторы_на_рабочем_месте_.html");

        Alldocuments.get(18).setDoc_name("Вредные факторы на рабочем месте (Презентация)");
        Alldocuments.get(18).setDoc_id(18);
        Alldocuments.get(18).setSectoin_id(5);
        Alldocuments.get(18).setRef("https://disk.yandex.ru/i/WsaO-cZqpCcLNA");
// Раздел 2.2
        Alldocuments.get(19).setDoc_name("Теоритическая часть");
        Alldocuments.get(19).setDoc_id(19);
        Alldocuments.get(19).setSectoin_id(6);
        Alldocuments.get(19).setRef("documents/Тема_2_2_1_Определение_опасных_зон.html");

        Alldocuments.get(20).setDoc_name("Определение опасных зон (Презенатция)");
        Alldocuments.get(20).setDoc_id(20);
        Alldocuments.get(20).setSectoin_id(6);
        Alldocuments.get(20).setRef("https://disk.yandex.ru/i/LTUdqBPxWGjYGQ");
// Раздел 2.3
        Alldocuments.get(21).setDoc_name("Теоритическая часть");
        Alldocuments.get(21).setDoc_id(21);
        Alldocuments.get(21).setSectoin_id(7);
        Alldocuments.get(21).setRef("documents/Тема_2_3_1_Опасности,_присутствующие_на_рабочем_месте.html");

        Alldocuments.get(22).setDoc_name("Опасности, присутствующие на рабочем месте (Презентация)");
        Alldocuments.get(22).setDoc_id(22);
        Alldocuments.get(22).setSectoin_id(7);
        Alldocuments.get(22).setRef("https://disk.yandex.ru/i/nep8hNgjQBUD1g");
// Раздел 2.4
        Alldocuments.get(23).setDoc_name("Теоритическая часть");
        Alldocuments.get(23).setDoc_id(23);
        Alldocuments.get(23).setSectoin_id(8);
        Alldocuments.get(23).setRef("documents/Тема_2_4_1_Специальная_оценка_условий_труда_СОУТ.html");

        Alldocuments.get(24).setDoc_name("СОУТ (Видео)");
        Alldocuments.get(24).setDoc_id(24);
        Alldocuments.get(24).setSectoin_id(8);
        Alldocuments.get(24).setRef("https://disk.yandex.ru/i/el0nD-GJ8Ut9jQ");
// Раздел 3.1
        Alldocuments.get(25).setDoc_name("Теоритическая часть");
        Alldocuments.get(25).setDoc_id(25);
        Alldocuments.get(25).setSectoin_id(10);
        Alldocuments.get(25).setRef("documents/Тема_3_1_1_Оценка_профессиональных_рисков.html");

        Alldocuments.get(26).setDoc_name("Оценка профессиональных рисков (Презентация)");
        Alldocuments.get(26).setDoc_id(26);
        Alldocuments.get(26).setSectoin_id(10);
        Alldocuments.get(26).setRef("https://disk.yandex.ru/i/hqgn52FzUZfL3A");

        Alldocuments.get(27).setDoc_name("Карта рисков (Видео)");
        Alldocuments.get(27).setDoc_id(27);
        Alldocuments.get(27).setSectoin_id(10);
        Alldocuments.get(27).setRef("https://disk.yandex.ru/i/bY8NeMA9IucO2Q");

        Alldocuments.get(28).setDoc_name("Теоритическая часть");
        Alldocuments.get(28).setDoc_id(28);
        Alldocuments.get(28).setSectoin_id(10);
        Alldocuments.get(28).setRef("documents/Тема_3_1_2_Идентификация_опасностей.html");

// Раздел 4.1
        Alldocuments.get(29).setDoc_name("Теоритическая часть");
        Alldocuments.get(29).setDoc_id(29);
        Alldocuments.get(29).setSectoin_id(12);
        Alldocuments.get(29).setRef("documents/Тема_4_1_1_Общие_требования_охраны_труда.html");

        Alldocuments.get(30).setDoc_name("Общие требования охраны труда (Презентация)");
        Alldocuments.get(30).setDoc_id(30);
        Alldocuments.get(30).setSectoin_id(12);
        Alldocuments.get(30).setRef("https://disk.yandex.ru/i/NxwZI9YLMKlJNQ");
// Раздел 4.2
        Alldocuments.get(31).setDoc_name("Теоритическая часть");
        Alldocuments.get(31).setDoc_id(31);
        Alldocuments.get(31).setSectoin_id(13);
        Alldocuments.get(31).setRef("documents/Тема_4_2_1_Требования_охраны_труда_перед_началом_работ.html");

        Alldocuments.get(32).setDoc_name("Требования охраны труда перед, во время, по окончании работ (Презентация)");
        Alldocuments.get(32).setDoc_id(32);
        Alldocuments.get(32).setSectoin_id(13);
        Alldocuments.get(32).setRef("https://disk.yandex.ru/i/q0ktAOFG7X1deg");
// Раздел 4.3
        Alldocuments.get(33).setDoc_name("Теоритическая часть");
        Alldocuments.get(33).setDoc_id(33);
        Alldocuments.get(33).setSectoin_id(14);
        Alldocuments.get(33).setRef("documents/Тема_4_3_1_Требования_охраны_труда_во_время_выполнения_работ.html");

// Раздел 4.4
        Alldocuments.get(34).setDoc_name("Теоритическая часть");
        Alldocuments.get(34).setDoc_id(34);
        Alldocuments.get(34).setSectoin_id(15);
        Alldocuments.get(34).setRef("documents/Тема_4_4_1_Требования_при_аварийных_ситуациях.html");

// Раздел 4.5
        Alldocuments.get(35).setDoc_name("Теоритическая часть");
        Alldocuments.get(35).setDoc_id(35);
        Alldocuments.get(35).setSectoin_id(16);
        Alldocuments.get(35).setRef("documents/Тема_4_5_1_Требования_охраны_труда_по_окончанию_работ.html");

// Раздел 4.6
        Alldocuments.get(36).setDoc_name("Теоритическая часть");
        Alldocuments.get(36).setDoc_id(36);
        Alldocuments.get(36).setSectoin_id(17);
        Alldocuments.get(36).setRef("documents/Тема_4_6_1_Методы_и_средства_предупреждения_несчастных_случаев.html");

        Alldocuments.get(37).setDoc_name("Методы и средства предупреждения несчастных случаев (Презентация)");
        Alldocuments.get(37).setDoc_id(37);
        Alldocuments.get(37).setSectoin_id(17);
        Alldocuments.get(37).setRef("https://disk.yandex.ru/i/gfWKem3Md0XuMQ");
// Раздел 4.7
        Alldocuments.get(38).setDoc_name("Теоритическая часть");
        Alldocuments.get(38).setDoc_id(38);
        Alldocuments.get(38).setSectoin_id(18);
        Alldocuments.get(38).setRef("documents/Тема_4_7_1_Правила_охраны_труда_при_работах_повышенной_опасности.html");

        Alldocuments.get(39).setDoc_name("Правила охраны труда при работах повышенной опасности (Презентация)");
        Alldocuments.get(39).setDoc_id(39);
        Alldocuments.get(39).setSectoin_id(18);
        Alldocuments.get(39).setRef("https://disk.yandex.ru/i/1p_2ng1ssk_-yg");
// Раздел 5.1
        Alldocuments.get(40).setDoc_name("Теоритическая часть");
        Alldocuments.get(40).setDoc_id(40);
        Alldocuments.get(40).setSectoin_id(20);
        Alldocuments.get(40).setRef("documents/Тема_5_1_1_Организационные_меры_защиты.html");

        Alldocuments.get(41).setDoc_name("Организационные меры защиты (Презентация)");
        Alldocuments.get(41).setDoc_id(41);
        Alldocuments.get(41).setSectoin_id(20);
        Alldocuments.get(41).setRef("https://disk.yandex.ru/i/T-XVY-Zp-qKNoQ");
// Раздел 5.2
        Alldocuments.get(42).setDoc_name("Теоритическая часть");
        Alldocuments.get(42).setDoc_id(42);
        Alldocuments.get(42).setSectoin_id(21);
        Alldocuments.get(42).setRef("documents/Тема 5.2.1 Технические меры защиты.html");

        Alldocuments.get(43).setDoc_name("Технические меры защиты (Презентация)");
        Alldocuments.get(43).setDoc_id(43);
        Alldocuments.get(43).setSectoin_id(21);
        Alldocuments.get(43).setRef("https://disk.yandex.ru/i/OQw2FbZ-z8_o4Q");
// Раздел 6.1
        Alldocuments.get(44).setDoc_name("Теоритическая часть");
        Alldocuments.get(44).setDoc_id(45);
        Alldocuments.get(44).setSectoin_id(23);
        Alldocuments.get(44).setRef("documents/Тема_6_1_1_Обязательные_СИЗ_для_монтёра_пути.html");

        Alldocuments.get(46).setDoc_name("Обязательные СИЗ для монтёра пути (Презентация)");
        Alldocuments.get(46).setDoc_id(46);
        Alldocuments.get(46).setSectoin_id(23);
        Alldocuments.get(46).setRef("https://disk.yandex.ru/i/tkOinc4G6-AEFA");
// Раздел 7.1
        Alldocuments.get(47).setDoc_name("Теоритическая часть");
        Alldocuments.get(47).setDoc_id(47);
        Alldocuments.get(47).setSectoin_id(25);
        Alldocuments.get(47).setRef("documents/Тема_7_1_1_Снижение_уровней_профессионального_риска.html");

        Alldocuments.get(48).setDoc_name("Снижение уровней профессионального риска (Презентация)");
        Alldocuments.get(48).setDoc_id(48);
        Alldocuments.get(48).setSectoin_id(25);
        Alldocuments.get(48).setRef("https://disk.yandex.ru/i/XrzS5qY_qug8Kw");
// Раздел 7.2
        Alldocuments.get(49).setDoc_name("Теоритическая часть");
        Alldocuments.get(49).setDoc_id(49);
        Alldocuments.get(49).setSectoin_id(26);
        Alldocuments.get(49).setRef("documents/Тема_7_2_1_Меры_профилактики_профессиональных_рисков.html");

        Alldocuments.get(50).setDoc_name("Меры профилактики профессиональных рисков (Презентация)");
        Alldocuments.get(50).setDoc_id(50);
        Alldocuments.get(50).setSectoin_id(26);
        Alldocuments.get(50).setRef("https://disk.yandex.ru/i/Rua7Kq1K-GzSRg");
//интерактивные задания модуля 1
        Alldocuments.get(51).setDoc_name("Мини-игра: Распределение");
        Alldocuments.get(51).setDoc_id(51);
        Alldocuments.get(51).setSectoin_id(4);
        Alldocuments.get(51).setRef("https://wordwall.net/resource/93126661/%d1%80%d0%b0%d1%81%d0%bf%d1%80%d0%b5%d0%b4%d0%b5%d0%bb%d0%b5%d0%bd%d0%b8%d0%b5-%d0%bf%d0%be-%d0%b3%d1%80%d1%83%d0%bf%d0%bf%d0%b0%d0%bc");

        Alldocuments.get(52).setDoc_name("Мини-тест: Да/Нет");
        Alldocuments.get(52).setDoc_id(52);
        Alldocuments.get(52).setSectoin_id(4);
        Alldocuments.get(52).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81240");

        Alldocuments.get(53).setDoc_name("Мини-игра: Пропущенные слова");
        Alldocuments.get(53).setDoc_id(53);
        Alldocuments.get(53).setSectoin_id(4);
        Alldocuments.get(53).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81385");

        Alldocuments.get(54).setDoc_name("Мини-тест: Ответьте на вопросы");
        Alldocuments.get(54).setDoc_id(54);
        Alldocuments.get(54).setSectoin_id(4);
        Alldocuments.get(54).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81384");

        Alldocuments.get(55).setDoc_name("Мини-игра: Составить слова");
        Alldocuments.get(55).setDoc_id(55);
        Alldocuments.get(55).setSectoin_id(4);
        Alldocuments.get(55).setRef("https://learningapps.org/watch?v=pa3gxeuhj25");

        Alldocuments.get(56).setDoc_name("Итоговый тест по модулю");
        Alldocuments.get(56).setDoc_id(56);
        Alldocuments.get(56).setSectoin_id(4);
        Alldocuments.get(56).setRef("https://sdo.irgups.ru/mod/quiz/view.php?id=81410");
//интерактивные задания модуля 2
        Alldocuments.get(57).setDoc_name("Мини-тест: Ответьте на вопросы");
        Alldocuments.get(57).setDoc_id(57);
        Alldocuments.get(57).setSectoin_id(9);
        Alldocuments.get(57).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81399");

        Alldocuments.get(58).setDoc_name("Мини-тест: Да/Нет");
        Alldocuments.get(58).setDoc_id(58);
        Alldocuments.get(58).setSectoin_id(9);
        Alldocuments.get(58).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81412");

        Alldocuments.get(59).setDoc_name("Мини-игра: Отметьте слова");
        Alldocuments.get(59).setDoc_id(59);
        Alldocuments.get(59).setSectoin_id(9);
        Alldocuments.get(59).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81414");

        Alldocuments.get(60).setDoc_name("Мини-игра: Пропущенные слова");
        Alldocuments.get(60).setDoc_id(60);
        Alldocuments.get(60).setSectoin_id(9);
        Alldocuments.get(60).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81389");

        Alldocuments.get(61).setDoc_name("Итоговый тест по модулю");
        Alldocuments.get(61).setDoc_id(61);
        Alldocuments.get(61).setSectoin_id(9);
        Alldocuments.get(61).setRef("https://sdo.irgups.ru/mod/quiz/view.php?id=81427");
//интерактивные задания модуля 3
        Alldocuments.get(62).setDoc_name("Мини-тест: Да/Нет");
        Alldocuments.get(62).setDoc_id(62);
        Alldocuments.get(62).setSectoin_id(11);
        Alldocuments.get(62).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81425");

        Alldocuments.get(63).setDoc_name("Мини-игра: Пропущенные слова");
        Alldocuments.get(63).setDoc_id(63);
        Alldocuments.get(63).setSectoin_id(11);
        Alldocuments.get(63).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81426");

        Alldocuments.get(64).setDoc_name("Мини-игра: Отметьте слова");
        Alldocuments.get(64).setDoc_id(64);
        Alldocuments.get(64).setSectoin_id(11);
        Alldocuments.get(64).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81429");

        Alldocuments.get(65).setDoc_name("Итоговый тест по модулю");
        Alldocuments.get(65).setDoc_id(65);
        Alldocuments.get(65).setSectoin_id(11);
        Alldocuments.get(65).setRef("https://sdo.irgups.ru/mod/quiz/view.php?id=81428");
//интерактивные задания модуля 4
        Alldocuments.get(66).setDoc_name("Мини-тест: Ответьте на вопросы");
        Alldocuments.get(66).setDoc_id(66);
        Alldocuments.get(66).setSectoin_id(19);
        Alldocuments.get(66).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81437");

        Alldocuments.get(67).setDoc_name("Мини-тест: Да/Нет");
        Alldocuments.get(67).setDoc_id(67);
        Alldocuments.get(67).setSectoin_id(19);
        Alldocuments.get(67).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81438");

        Alldocuments.get(68).setDoc_name("Мини-игра: Отметьте слова");
        Alldocuments.get(68).setDoc_id(68);
        Alldocuments.get(68).setSectoin_id(19);
        Alldocuments.get(68).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81439");

        Alldocuments.get(69).setDoc_name("Мини-игра: Кроссворд");
        Alldocuments.get(69).setDoc_id(69);
        Alldocuments.get(69).setSectoin_id(19);
        Alldocuments.get(69).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81442");

        Alldocuments.get(70).setDoc_name("Итоговый тест по модулю");
        Alldocuments.get(70).setDoc_id(70);
        Alldocuments.get(70).setSectoin_id(19);
        Alldocuments.get(70).setRef("https://sdo.irgups.ru/mod/quiz/view.php?id=81443");
//интерактивные задания модуля 5
        Alldocuments.get(71).setDoc_name("Мини-игра: Отметьте слова");
        Alldocuments.get(71).setDoc_id(71);
        Alldocuments.get(71).setSectoin_id(22);
        Alldocuments.get(71).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81450");

        Alldocuments.get(72).setDoc_name("Мини-игра: Пропущенные слова");
        Alldocuments.get(72).setDoc_id(72);
        Alldocuments.get(72).setSectoin_id(22);
        Alldocuments.get(72).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81451");

        Alldocuments.get(73).setDoc_name("Итоговый тест по модулю");
        Alldocuments.get(73).setDoc_id(73);
        Alldocuments.get(73).setSectoin_id(22);
        Alldocuments.get(73).setRef("https://sdo.irgups.ru/mod/quiz/view.php?id=81452");
//интерактивные задания модуля 6
        Alldocuments.get(74).setDoc_name("Мини-игра: Кроссворд");
        Alldocuments.get(74).setDoc_id(74);
        Alldocuments.get(74).setSectoin_id(24);
        Alldocuments.get(74).setRef("https://learningapps.org/watch?v=p7pnm0nza25");

        Alldocuments.get(75).setDoc_name("Мини-игра: Сопоставление");
        Alldocuments.get(75).setDoc_id(75);
        Alldocuments.get(75).setSectoin_id(24);
        Alldocuments.get(75).setRef("https://learningapps.org/watch?v=pyz03nmbk25");

        Alldocuments.get(76).setDoc_name("Итоговый тест по модулю");
        Alldocuments.get(76).setDoc_id(76);
        Alldocuments.get(76).setSectoin_id(24);
        Alldocuments.get(76).setRef("https://sdo.irgups.ru/mod/quiz/view.php?id=81456");
//интерактивные задания модуля 7
        Alldocuments.get(77).setDoc_name("Мини-тест: Да/Нет");
        Alldocuments.get(77).setDoc_id(77);
        Alldocuments.get(77).setSectoin_id(27);
        Alldocuments.get(77).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81457");

        Alldocuments.get(78).setDoc_name("Мини-игра: Найдите слова");
        Alldocuments.get(78).setDoc_id(78);
        Alldocuments.get(78).setSectoin_id(27);
        Alldocuments.get(78).setRef("https://learningapps.org/watch?v=pnbrk9o1n25");

        Alldocuments.get(79).setDoc_name("Мини-игра: Сопоставьте карточки");
        Alldocuments.get(79).setDoc_id(79);
        Alldocuments.get(79).setSectoin_id(27);
        Alldocuments.get(79).setRef("https://learningapps.org/watch?v=pz7irk7pn25");

        Alldocuments.get(80).setDoc_name("Мини-игра: Впишите пропущенные слова");
        Alldocuments.get(80).setDoc_id(80);
        Alldocuments.get(80).setSectoin_id(27);
        Alldocuments.get(80).setRef("https://sdo.irgups.ru/mod/hvp/view.php?id=81461");

        Alldocuments.get(81).setDoc_name("Итоговый тест по модулю");
        Alldocuments.get(81).setDoc_id(81);
        Alldocuments.get(81).setSectoin_id(27);
        Alldocuments.get(81).setRef("https://sdo.irgups.ru/mod/quiz/view.php?id=81462");

        Alldocuments.get(82).setDoc_name("Итоговый тест");
        Alldocuments.get(82).setDoc_id(82);
        Alldocuments.get(82).setSectoin_id(28);
        Alldocuments.get(82).setRef("https://sdo.irgups.ru/mod/quiz/view.php?id=82062");
//-----------------------------------------------------------------------------------------------------------------------
        Allsections.add(new razdel());
        Allsections.get(0).setSectionID(1);
        Allsections.get(0).set_name("Тема 1.1 Обеспечение прав работников по охране труда");
        Allsections.get(0).set_des("В данном разделе рассматриваются права работников в области охраны труда");
        Allsections.get(0).setCourse_id(1);
        Allsections.get(0).set_doclist(DocFilter(Alldocuments, Allsections.get(0).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(1).setSectionID(2);
        Allsections.get(1).set_name("Тема 1.2 Обеспечение гарантий и компенсаций работникам");
        Allsections.get(1).set_des("Раздел посвящен гарантиям и компенсациям для работников");
        Allsections.get(1).setCourse_id(1);
        Allsections.get(1).set_doclist(DocFilter(Alldocuments, Allsections.get(1).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(2).setSectionID(3);
        Allsections.get(2).set_name("Тема 1.3 Обеспечение оптимальных режимов труда и отдыха");
        Allsections.get(2).set_des("В разделе рассматриваются вопросы организации труда и отдыха");
        Allsections.get(2).setCourse_id(1);
        Allsections.get(2).set_doclist(DocFilter(Alldocuments, Allsections.get(2).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(3).setSectionID(4);
        Allsections.get(3).set_name("Интерактивные задания модуля 1");
        Allsections.get(3).set_des("Практические задания по материалам первого модуля");
        Allsections.get(3).setCourse_id(1);
        Allsections.get(3).set_doclist(DocFilter(Alldocuments, Allsections.get(3).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(4).setSectionID(5);
        Allsections.get(4).set_name("Тема 2.1 Вредные производственные факторы по воздействию на организм работающего человека");
        Allsections.get(4).set_des("Раздел о вредных производственных факторах и их влиянии");
        Allsections.get(4).setCourse_id(1);
        Allsections.get(4).set_doclist(DocFilter(Alldocuments, Allsections.get(4).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(5).setSectionID(6);
        Allsections.get(5).set_name("Тема 2.2 Идентификация опасных зон");
        Allsections.get(5).set_des("Методы выявления и классификации опасных зон на производстве");
        Allsections.get(5).setCourse_id(1);
        Allsections.get(5).set_doclist(DocFilter(Alldocuments, Allsections.get(5).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(6).setSectionID(7);
        Allsections.get(6).set_name("Тема 2.3 Опасности, связанные с работой монтёра пути");
        Allsections.get(6).set_des("Специфические опасности в работе монтера пути");
        Allsections.get(6).setCourse_id(1);
        Allsections.get(6).set_doclist(DocFilter(Alldocuments, Allsections.get(6).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(7).setSectionID(8);
        Allsections.get(7).set_name("Тема 2.4 Специальная оценка условий труда (СОУТ)");
        Allsections.get(7).set_des("Процедура специальной оценки условий труда");
        Allsections.get(7).setCourse_id(1);
        Allsections.get(7).set_doclist(DocFilter(Alldocuments, Allsections.get(7).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(8).setSectionID(9);
        Allsections.get(8).set_name("Интерактивные задания модуля 2");
        Allsections.get(8).set_des("Практические задания по материалам второго модуля");
        Allsections.get(8).setCourse_id(1);
        Allsections.get(8).set_doclist(DocFilter(Alldocuments, Allsections.get(8).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(9).setSectionID(10);
        Allsections.get(9).set_name("Тема 3.1 Оценка профессиональных рисков (ОПР)");
        Allsections.get(9).set_des("Методы оценки профессиональных рисков на производстве");
        Allsections.get(9).setCourse_id(1);
        Allsections.get(9).set_doclist(DocFilter(Alldocuments, Allsections.get(9).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(10).setSectionID(11);
        Allsections.get(10).set_name("Интерактивные задания модуля 3");
        Allsections.get(10).set_des("Практические задания по материалам третьего модуля");
        Allsections.get(10).setCourse_id(1);
        Allsections.get(10).set_doclist(DocFilter(Alldocuments, Allsections.get(10).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(11).setSectionID(12);
        Allsections.get(11).set_name("Тема 4.1 Общие требования охраны труда");
        Allsections.get(11).set_des("Основные требования по охране труда");
        Allsections.get(11).setCourse_id(1);
        Allsections.get(11).set_doclist(DocFilter(Alldocuments, Allsections.get(11).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(12).setSectionID(13);
        Allsections.get(12).set_name("Тема 4.2 Требования охраны труда перед началом работ");
        Allsections.get(12).set_des("Меры безопасности перед началом работ");
        Allsections.get(12).setCourse_id(1);
        Allsections.get(12).set_doclist(DocFilter(Alldocuments, Allsections.get(12).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(13).setSectionID(14);
        Allsections.get(13).set_name("Тема 4.3 Требования охраны труда во время выполнения работ");
        Allsections.get(13).set_des("Меры безопасности во время выполнения работ");
        Allsections.get(13).setCourse_id(1);
        Allsections.get(13).set_doclist(DocFilter(Alldocuments, Allsections.get(13).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(14).setSectionID(15);
        Allsections.get(14).set_name("Тема 4.4 Требования при аварийных ситуациях");
        Allsections.get(14).set_des("Действия при возникновении аварийных ситуаций");
        Allsections.get(14).setCourse_id(1);
        Allsections.get(14).set_doclist(DocFilter(Alldocuments, Allsections.get(14).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(15).setSectionID(16);
        Allsections.get(15).set_name("Тема 4.5 Требования охраны труда по окончанию работ");
        Allsections.get(15).set_des("Меры безопасности после завершения работ");
        Allsections.get(15).setCourse_id(1);
        Allsections.get(15).set_doclist(DocFilter(Alldocuments, Allsections.get(15).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(16).setSectionID(17);
        Allsections.get(16).set_name("Тема 4.6 Методы и средства предупреждения несчастных случаев, микротравм и профзаболеваний");
        Allsections.get(16).set_des("Профилактика несчастных случаев и профессиональных заболеваний");
        Allsections.get(16).setCourse_id(1);
        Allsections.get(16).set_doclist(DocFilter(Alldocuments, Allsections.get(16).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(17).setSectionID(18);
        Allsections.get(17).set_name("Тема 4.7 Правила охраны труда при работах повышенной опасности для монтёра пути");
        Allsections.get(17).set_des("Особые требования безопасности для работ повышенной опасности");
        Allsections.get(17).setCourse_id(1);
        Allsections.get(17).set_doclist(DocFilter(Alldocuments, Allsections.get(17).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(18).setSectionID(19);
        Allsections.get(18).set_name("Интерактивные задания модуля 4");
        Allsections.get(18).set_des("Практические задания по материалам четвертого модуля");
        Allsections.get(18).setCourse_id(1);
        Allsections.get(18).set_doclist(DocFilter(Alldocuments, Allsections.get(18).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(19).setSectionID(20);
        Allsections.get(19).set_name("Тема 5.1 Организационные меры защиты");
        Allsections.get(19).set_des("Организационные методы защиты работников");
        Allsections.get(19).setCourse_id(1);
        Allsections.get(19).set_doclist(DocFilter(Alldocuments, Allsections.get(19).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(20).setSectionID(21);
        Allsections.get(20).set_name("Тема 5.2 Технические меры защиты");
        Allsections.get(20).set_des("Технические средства защиты работников");
        Allsections.get(20).setCourse_id(1);
        Allsections.get(20).set_doclist(DocFilter(Alldocuments, Allsections.get(20).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(21).setSectionID(22);
        Allsections.get(21).set_name("Интерактивные задания модуля 5");
        Allsections.get(21).set_des("Практические задания по материалам пятого модуля");
        Allsections.get(21).setCourse_id(1);
        Allsections.get(21).set_doclist(DocFilter(Alldocuments, Allsections.get(21).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(22).setSectionID(23);
        Allsections.get(22).set_name("Тема 6.1 Обязательные СИЗ для монтёра пути");
        Allsections.get(22).set_des("Средства индивидуальной защиты для монтера пути");
        Allsections.get(22).setCourse_id(1);
        Allsections.get(22).set_doclist(DocFilter(Alldocuments, Allsections.get(22).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(23).setSectionID(24);
        Allsections.get(23).set_name("Интерактивные задания модуля 6");
        Allsections.get(23).set_des("Практические задания по материалам шестого модуля");
        Allsections.get(23).setCourse_id(1);
        Allsections.get(23).set_doclist(DocFilter(Alldocuments, Allsections.get(23).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(24).setSectionID(25);
        Allsections.get(24).set_name("Тема 7.1 Снижение уровней профессионального риска");
        Allsections.get(24).set_des("Методы снижения профессиональных рисков");
        Allsections.get(24).setCourse_id(1);
        Allsections.get(24).set_doclist(DocFilter(Alldocuments, Allsections.get(24).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(25).setSectionID(26);
        Allsections.get(25).set_name("Тема 7.2 Меры профилактики профессиональных рисков");
        Allsections.get(25).set_des("Профилактические меры против профессиональных рисков");
        Allsections.get(25).setCourse_id(1);
        Allsections.get(25).set_doclist(DocFilter(Alldocuments, Allsections.get(25).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(26).setSectionID(27);
        Allsections.get(26).set_name("Интерактивные задания модуля 7");
        Allsections.get(26).set_des("Практические задания по материалам седьмого модуля");
        Allsections.get(26).setCourse_id(1);
        Allsections.get(26).set_doclist(DocFilter(Alldocuments, Allsections.get(26).get_sectionID()));

        Allsections.add(new razdel());
        Allsections.get(27).setSectionID(28);
        Allsections.get(27).set_name("Итоговое тестирование");
        Allsections.get(27).set_des("Итоговое тестирование по курсу");
        Allsections.get(27).setCourse_id(1);
        Allsections.get(27).set_doclist(DocFilter(Alldocuments, Allsections.get(27).get_sectionID()));
    }
    private List<razdel> loadCourseSections(int id) {

        ArrayList<razdel> sections = new ArrayList<>();                           //Список передаваемых на отображение разделов

        docinit();
        OutDocs = Alldocuments;


        for (razdel section : Allsections) {
            if (section.get_courseid() == id) {
                sections.add(section);
            }
        }
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

    public void openreaderActivity(View view) {
        Intent intent = new Intent(this, readerActivity.class);
        startActivity(intent);
    }

    public ArrayList<document> DocFilter(ArrayList<document> all, int id) {
        ArrayList<document> Filtreddocuments = new ArrayList<>();
        Filtreddocuments.clear();
        for (document doc : all) {
            if (doc.getSectoin_id() == id) {
                Filtreddocuments.add(doc);
            }
        }
    return Filtreddocuments;
    }
}