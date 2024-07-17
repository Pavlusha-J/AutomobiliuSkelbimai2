package com.example.AutomobiliuSkelbimai.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {
    private static final String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7719960";
    private static final String USERNAME = " sql7719960";
    private static final String PASSWORD = "PtezisyTtg";

    private static Connection connection;

    public static PreparedStatement SQLConnection(String sqls) throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = sqls;
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps;
    }
}
