/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nova Nur Fauziah
 */
public class User extends Database {
    private String uid;
    private long nimUser;
    private String namaUser;
    private String jenisKelamin;
    private String role;
    private String passwordUser;
    protected ArrayList<User> listUser = new ArrayList<>();

    public User(String uid, long nimUser, String namaUser, String jenisKelamin, String role, String passwordUser) {
        this.uid = uid;
        this.nimUser = nimUser;
        this.namaUser = namaUser;
        this.jenisKelamin = jenisKelamin;
        this.role = role;
        this.passwordUser = passwordUser;
    }

    public String getUid() {
        return uid;
    }
    
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public long getNimUser() {
        return nimUser;
    }

    public void setNimUser(long nimUser) {
        this.nimUser = nimUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public ArrayList<User> getListUser(){
        return listUser;
    }
    
    private static User loggedUser;
    
    public static User getLoggedUser() {
        return loggedUser;
    }
    
    public static void logoutUser() {
        loggedUser = null;
        JOptionPane.showMessageDialog(null, "Anda telah logout");
    }
    
//===================  Login
    public static boolean loginUser(long nim, String password) {
        try {
            String query = "SELECT * FROM pengguna WHERE nimPengguna = ? AND password = ?";
            ps = con.prepareStatement(query);

            ps.setLong(1, nim);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                String uid = rs.getString("uid");
                long nimUser = rs.getLong("nimPengguna");
                String namaUser = rs.getString("namaPengguna");
                String jenisKelamin = rs.getString("jenisKelamin");
                String role = rs.getString("role");
                String passwordUser = rs.getString("password");
                loggedUser = new User(uid, nimUser, namaUser, jenisKelamin, role, passwordUser);
                
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login Gagal!, " + e.getMessage());
        }
        return false;
    }
}
