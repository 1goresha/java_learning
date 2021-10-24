package com.company;

import java.sql.*;

public class DataBaseConnector {


    private Connection connection;

    public DataBaseConnector(String url, String user, String password) {
        this.connection = getConnection(url, user, password);
    }

    private Connection getConnection(String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Statement createStatement() {
        try {
            return connection.createStatement();
        }catch (SQLException e){
            throw new IllegalArgumentException(e);
        }
    }

    public ResultSet executeQuery(String query){
        Statement statement = createStatement();
        try{
            return statement.executeQuery(query);
        }catch (SQLException e){
            throw new IllegalArgumentException(e);
        }
    }
}
