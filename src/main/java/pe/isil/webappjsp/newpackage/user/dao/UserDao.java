/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.isil.webappjsp.newpackage.user.dao;

import pe.isil.webappjsp.newpackage.user.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.isil.webappjsp.newpackage.user.dao.mysql.mysqlConnection;

/**
 *
 * @author MI PC
 */
public class UserDao {
    //Aca va a ir todo el codigo de acceso a datos
    
    public int registerUser(User user) throws Exception{

            mysqlConnection mysqlConn = new mysqlConnection();
            Connection conn = mysqlConn.getConnection();
            int rowsAffected=0;
            
            String queryInsert = "Insert Into Users(name,lastname,username,pass,tipDoc,nroDoc,enable,mail)"+
                    "Values(?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = conn.prepareStatement(queryInsert);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPass());
            ps.setString(5, user.getTipDoc());
            ps.setString(6, user.getNroDoc());
            ps.setString(7, user.getEnable());
            ps.setString(8, user.getMail());
            
            rowsAffected = ps.executeUpdate();
            return rowsAffected;
 
    }
    
    public String updateUser(User user) throws Exception{
        String message= "";
        mysqlConnection mysqlConn = new mysqlConnection();
        Connection conn = mysqlConn.getConnection();
        int rowsAffected=0;
        int count=0;
        
        PreparedStatement ps = conn.prepareStatement("Select * from Users where nroDoc=?");
        ps.setString(1, user.getNroDoc());
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            count++;
        }
        
        if(count > 0){
            String queryUpdate = "Update Users set name=?, lastname=?;usernane=?,pass=?,enable=?,mail=? where nroDoc=?";
            PreparedStatement psUpdate = conn.prepareStatement(queryUpdate);
            psUpdate.setString(1, user.getName());
            psUpdate.setString(1, user.getLastname());
            psUpdate.setString(1, user.getUsername());
            psUpdate.setString(1, user.getPass());
            psUpdate.setString(1, user.getEnable());
            psUpdate.setString(1, user.getMail());
            psUpdate.setString(1, user.getNroDoc());
            rowsAffected= psUpdate.executeUpdate();
            
            if(rowsAffected>0)
            {
                message="Se actualizo el usuario satisfactoriamente";
            }else{
                message="Ocurrio un error";
            }
           
        }else{
            message="User no existe";
        }
        
        return message;
        
    }
    
}
