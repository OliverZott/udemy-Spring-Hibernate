package main.java.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_employee_tracker?serverTimezone=UTC";

        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, "hbstudent", "hbstudent");
            System.out.printf("Connecting to Server %s successful!", jdbcUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
