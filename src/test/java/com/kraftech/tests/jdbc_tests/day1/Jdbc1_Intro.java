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

        resultSet.next();
        System.out.println("resultSet.getString(\"employeeId\") = " + resultSet.getString("employeeId"));
        System.out.println("resultSet.getString(\"firstName\") = " + resultSet.getString("firstName"));

        System.out.println("resultSet.getString(3) = " + resultSet.getString(3));
        System.out.println("resultSet.getString(4) = " + resultSet.getString(4));

        resultSet.next();
        System.out.println("resultSet.getString(\"phonenumber\") = " + resultSet.getString("phonenumber"));
        System.out.println("resultSet.getString(5) = " + resultSet.getString(5));

    while(resultSet.next()){
        System.out.println(
                resultSet.getString("eployeeId")
                + " - "
                + resultSet.getString("firstName")
                + " - "
                + resultSet.getString("lastName")
        );
    }


        resultSet.close();
        statement.close();
        connection.close();


    }

}
