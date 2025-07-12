package com.example.diplom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Ввиду задержек со стороны человека, работавшего над БД, коннектор не готов
public class DatabaseConnector {
    private static final String DB_URL = "jdbc:mysql://192.168.0.179:3306/Diplom_DB";   //поменять
    private static final String USER = "ivannikita";
    private static final String PASS = "123VAny)";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Регистрируем драйвер
            Class.forName("com.mysql.jdbc.Driver");

            // Устанавливаем соединение
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
