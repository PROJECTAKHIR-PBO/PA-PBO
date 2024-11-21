/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Nova Nur Fauziah
 */
public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/aplikasi_app";
    private static final String USER = "root";
    private static final String PW = "";
    
    public static Connection con;
    public static Statement st;
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    static {
        try {
            con = DriverManager.getConnection(URL, USER, PW);
            System.out.println("Database berhasil terhubung");
        } catch (SQLException e) {
            System.out.println("Nyalakan MYSQL Terlebih Dahulu");
        }
    }
    
    public Database(){
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NYALAKAN MYSQL DAHULU");
        }
    }
}
