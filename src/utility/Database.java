/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ronpa
 */
public class Database {
    private String username = "admin";
    private String password = "admin";
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=ETS_DB;trustServerCertificate=true";
    
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }    
}
