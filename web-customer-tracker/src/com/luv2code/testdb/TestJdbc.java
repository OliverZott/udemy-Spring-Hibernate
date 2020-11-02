package com.luv2code.testdb;

import org.springframework.core.SpringVersion;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";

        String user = "hbstudent";
        String password = "hbstudent";

        try {
            System.out.println("Connecting to DB: " + jdbcUrl);

            System.out.println("Spring-Version: " + SpringVersion.getVersion());
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connections successful: " + jdbcUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
