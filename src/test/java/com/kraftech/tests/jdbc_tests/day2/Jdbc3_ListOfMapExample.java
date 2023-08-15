package com.kraftech.tests.jdbc_tests.day2;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jdbc3_ListOfMapExample {
    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "Tanatuzu0";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select firstName, lastName, salary, jobId from employees");

        List<Map<String,Object>> queryData = new ArrayList<>();

        Map<String,Object> row1 = new HashMap<>();
        row1.put("firstName", "Eren");
        row1.put("lastName", "Çengel");
        row1.put("salary", 100000);
        row1.put("jobId", "QA");

        Map<String,Object> row2 = new HashMap<>();
        row2.put("firstName", "Alperen");
        row2.put("lastName", "Çengel");
        row2.put("salary", 120000);
        row2.put("jobId", "Dev");

        System.out.println("row1 = " + row1);
        System.out.println("row2 = " + row2);

        queryData.add(row1);
        queryData.add(row2);

        System.out.println("---------------------------------------------------");

        System.out.println("queryData.get(0).get(\"lastName\") = " + queryData.get(0).get("lastName"));
        System.out.println("queryData.get(2).get(\"salary\") = " + queryData.get(1).get("salary"));

        System.out.println("---------------------------------------------------");

        List<Map<String,Object>> queryData2 = new ArrayList<>();

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        resultSet.next();

        Map<String,Object> row1Dynamic = new HashMap<>();
        row1Dynamic.put(resultSetMetaData.getColumnName(1),resultSet.getString("firstName"));
        row1Dynamic.put(resultSetMetaData.getColumnName(2),resultSet.getString("lastName"));
        row1Dynamic.put(resultSetMetaData.getColumnName(3),resultSet.getString("salary"));
        row1Dynamic.put(resultSetMetaData.getColumnName(4),resultSet.getString("jobId"));

        System.out.println("row1Dynamic = " + row1Dynamic);

        System.out.println("---------------------------------------------------");

        resultSet.next();

        Map<String,Object> row2Dynamic = new HashMap<>();
        row2Dynamic.put(resultSetMetaData.getColumnName(1),resultSet.getString("firstname"));
        row2Dynamic.put(resultSetMetaData.getColumnName(2),resultSet.getString("lastName"));
        row2Dynamic.put(resultSetMetaData.getColumnName(3),resultSet.getString("salary"));
        row2Dynamic.put(resultSetMetaData.getColumnName(4),resultSet.getString("jobId"));

        System.out.println("row2Dynamic = " + row2Dynamic);

        System.out.println("---------------------------------------------------");

        queryData2.add(row1Dynamic);
        queryData2.add(row2Dynamic);

        System.out.println("queryData2.get(1).get(\"jobid\") = " + queryData2.get(1).get("jobid"));



        resultSet.close();
        statement.close();
        connection.close();
    }
}
