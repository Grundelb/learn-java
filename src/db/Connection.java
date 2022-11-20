package db;

import java.sql.*;

public class Connection {

    private static java.sql.Connection conn;

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
            System.err.println("Driver is no found \n" +
                    e);
        }
        System.out.println("Driver is registered");
    }

    private static java.sql.Connection create() {
        registerDriver();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/animals",
                    "root",
                    "Password1");
            System.out.println("We are connected");

        } catch (SQLException e) {
            System.err.println("Connection is not established \n" +
                    e);
        }
        return conn;
    }

    public static java.sql.Connection getConnection() {
        if (conn == null) {
            return create();
        }
        return conn;
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                System.err.println("Error while closing the connection\n" +
                        e);
            }
        }
    }

}