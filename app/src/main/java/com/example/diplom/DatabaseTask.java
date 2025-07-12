package com.example.diplom;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTask extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... voids) {
        String result = "";
        Connection connection = DatabaseConnector.getConnection();

        if (connection != null) {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

                while (rs.next()) {
                    result += rs.getString("column_name") + "\n";
                }

                rs.close();
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                result = "Error: " + e.getMessage();
            }
        } else {
            result = "Connection failed";
        }

        return result;
    }
}
    /*@Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // Обновляем UI с результатами
        textView.setText(result);
    }
}*/
