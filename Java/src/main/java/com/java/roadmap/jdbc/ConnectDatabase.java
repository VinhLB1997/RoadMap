package com.java.roadmap.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class ConnectDatabase {

    Logger logger = LoggerFactory.getLogger(ConnectDatabase.class);

    private Connection connection;

    public void registerDriver() throws ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
    }

    public void setConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3307/blogapp?user=root&password=20150601");
        }
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public ResultSet executeQuery(Statement stmt, String sql) throws SQLException {
        return stmt.executeQuery(sql);
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM user";
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            connectDatabase.registerDriver();
            connectDatabase.setConnection();
            Statement statement = connectDatabase.createStatement();
            ResultSet resultSet = connectDatabase.executeQuery(statement, sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("email"));
            }
        } catch (Exception exception) {
            System.out.println("Error connect DB");
        } finally {
            connectDatabase.closeConnection();
        }
    }
}
