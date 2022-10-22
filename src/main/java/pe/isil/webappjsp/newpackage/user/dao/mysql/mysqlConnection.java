/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.isil.webappjsp.newpackage.user.dao.mysql;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
        

/**
 *
 * @author MI PC
 */
public class mysqlConnection {
    
    public static final String Driver = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/moduloseg";
    public static final String USER = "root";
    public static final String PASS = "123456";
    
    public mysqlConnection() throws Exception{

        Class.forName(Driver);


}
    public Connection getConnection()throws SQLException{
        return DriverManager.getConnection(URL,USER,PASS);
    }
    
    public Connection getConnection(String url,String user, String pass)throws SQLException{
        return DriverManager.getConnection(url,user,pass);
    }
    
}
