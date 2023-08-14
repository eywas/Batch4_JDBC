package com.kraftech.tests.jdbc_tests.day1;

import java.sql.*;

public class Jdbc1_Intro {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "Tanatuzu0";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from employees");

        resultSet.close();
        statement.close();
        connection.close();


    }

}
