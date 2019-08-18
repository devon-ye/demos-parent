package org.devon.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lenovo on 2017/12/15.
 */
public class ConnectDatabase {

    public static Connection getConnection(ConnectionConfig connectionConfig) {
        Connection connection = null;
        try {
            Class.forName(connectionConfig.getDriverClass()).newInstance();
            connection = DriverManager.getConnection(connectionConfig.getDriverClass(),connectionConfig.getUserName(),connectionConfig.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void main(String[] args) {
        ConnectionConfig con= new ConnectionConfig();
        con.setDriverClass("com.mysql.jdbc.Driver");
        con.setUrl("jdbc:mysql://localhost:3306/test1");
        con.setUserName("root");
        con.setPassword("admin");
       Connection connection = ConnectDatabase.getConnection(con);
    }
}
