package com.kraftech.tests.jdbc_tests.day2;

import com.sun.source.tree.WhileLoopTree;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.*;


public class Jdbc4_DynamicList {
    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "Tanatuzu0";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select firstName, lastName, salary, jobId from employees");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        List<Map<String,Object>> queryData = new ArrayList<>();

       int columnCount = resultSetMetaData.getColumnCount();

       while (resultSet.next()){
           Map<String,Object> map = new HashMap<>();

           for (int i = 1; i <= columnCount; i++) {
               map.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
           }

           queryData.add(map);
       }

        System.out.println("queryData = " + queryData);

        System.out.println("--------------------------------------------");

        System.out.println("queryData.get(queryData.size()-1).get(\"jobid\") = " + queryData.get(queryData.size() - 1).get("jobid"));


        resultSet.close();
        statement.close();
        connection.close();
    }
}
