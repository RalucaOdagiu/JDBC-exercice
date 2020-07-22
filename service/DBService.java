package com.sda.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {

    private static final String url = "jdbc:mysql://localhost:3306/JDBC?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "password";

    //private static String sql = "delete from departments where department_id=1";
    // ex 2e
    private static String sql = "update departments set department_name='financiar' where department_id=2";


    private static Connection connection;

    // ex 2c delete id
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();{

                    statement.executeUpdate(sql);
                    System.out.println("Department name changed successfully");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            return connection;
        }

    }
