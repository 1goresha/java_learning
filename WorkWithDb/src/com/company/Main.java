package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "2626882";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/my_service";

    public static void main(String[] args){

        DataBaseConnector dataBaseConnector = new DataBaseConnector(DB_URL, DB_USER, DB_PASSWORD);
        ResultSet resultSet = dataBaseConnector.executeQuery("select * from interview where id = " + "1");
        try {
            resultSet.next();
            String s = resultSet.getString("name");
            System.out.println(s);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
