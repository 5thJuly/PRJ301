/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hoa Doan
 */
public class DBUtils {
    
    private static final String DB_NAME = "FoodManagement";
    private static final String DB_USER_NAME = "sa";
    private static final String DB_PASSWORD = "12345";
    
    
    public static Connection makeConnection() throws Exception{
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName="+ DB_NAME;
        conn = DriverManager.getConnection(url,DB_USER_NAME,DB_PASSWORD);
        return conn;
    }
}
