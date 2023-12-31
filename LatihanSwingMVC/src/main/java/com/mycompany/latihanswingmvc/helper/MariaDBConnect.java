/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanswingmvc.helper;

import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mariadb.jdbc.Statement;


/**
 *
 * @author helmy
 */
public class MariaDBConnect {
    String jdbcUrl;
    String username;
    String password;
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    Connection con;

    public MariaDBConnect(String host, int port,String dbname, String username, String password) {
        this.jdbcUrl = "jdbc:mariadb://"+host+":"+port+"/"+dbname;
        this.username=username;
        this.password=password;       
                     
    }
    public void connectMaria(){
        try{
            this.con = DriverManager.getConnection(this.jdbcUrl, this.username, this.password);
            if(con !=null){
                System.out.println("Koneksi database berhasil..!!");
            }else {
                System.out.println("Koneksi database gagal..!!");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void connectionClose() throws SQLException{
        con.close();
    }
    
    
    
}
