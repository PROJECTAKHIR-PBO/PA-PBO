/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static model.UIDGenerator.generateUID;

/**
 *
 * @author Nova Nur Fauziah
 */
public class Panitia extends User implements crud {
    private String divisiPanitia;

    public Panitia(String uid, long nimUser, String namaUser, String jenisKelamin, String role, String passwordUser, String divisiPanitia) {
        super(uid, nimUser, namaUser, jenisKelamin, role, passwordUser);
        this.divisiPanitia = divisiPanitia;
    }
    
    public String getDivisiPanitia() {
        return divisiPanitia;
    }

    public void setDivisiPanitia(String divisiPanitia) {
        this.divisiPanitia = divisiPanitia;
    }

    @Override
    public void create() {
        try {
            String newUid = generateUID();
            String query = "INSERT INTO pengguna (uid, nimPengguna, namaPengguna, jenisKelamin, password, role) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            
            ps.setString(1, newUid);
            ps.setLong(2, getNimUser());
            ps.setString(3, getNamaUser());
            ps.setString(4, getJenisKelamin());
            ps.setString(5, getPasswordUser());
            ps.setString(6, "Panitia");
            
            int rowsInserted = ps.executeUpdate();
            
            String query2 = "INSERT INTO panitia (nimPengguna, divisiPanitia) VALUES (?, ?)";
            ps = con.prepareStatement(query2);
            
            ps.setLong(1, getNimUser());
            ps.setString(2, getDivisiPanitia());            
            
            int rowsInserted2 = ps.executeUpdate();
            
            //            Pesan Konfirmasi Create
            if (rowsInserted > 0 && rowsInserted2 > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
                store();
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ada Error Create Admin : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {rs.close();}
                if (ps != null) {ps.close();}
            } catch (SQLException e) {
                System.out.println("Error menutup koneksi : " + e.getMessage());
            }
        }
    }

    @Override
    public void read() {
        if (listUser.isEmpty()) {
            System.out.println("Tidak Ada Panitia Yang Terdaftar");
            System.out.println("=================================");
        } else {
            for (User x : listUser) {
                if (x instanceof Panitia p) {
                    System.out.println("Nim : " + p.getNimUser());
                    System.out.println("Nama : " + p.getNamaUser());
                    System.out.println("JK : " + p.getJenisKelamin());
                    System.out.println("Password : " + p.getPasswordUser());
                    System.out.println("Role : " + p.getRole());
                    System.out.println("Divisi : " + p.getDivisiPanitia());
                    System.out.println("=======================================");
                }
            }
        }
    }

    @Override
    public void update(String uid, List<Object> data) {
        try {
            for (User x : listUser) {
                if (x.getUid().equals(uid)) {
                    long newNimPengguna = Long.parseLong(data.get(0).toString());
                    String newNamaPengguna = (String) data.get(1);
                    String newJenisKelamin = (String) data.get(2);
                    String newPassword = (String) data.get(3);
                    String newDivisiPanitia = (String) data.get(4);
                    
//                    Query Tabel Pengguna
                    String query = "UPDATE pengguna SET nimPengguna = ?, namaPengguna = ?, jenisKelamin = ?, password = ? WHERE uid = ? AND role = 'Panitia'";
                    ps = con.prepareStatement(query);
                    ps.setLong(1, newNimPengguna);
                    ps.setString(2, newNamaPengguna);
                    ps.setString(3, newJenisKelamin);
                    ps.setString(4, newPassword);
                    ps.setString(5, uid);
                    
                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                        x.setNimUser((int) Long.parseLong(data.get(0).toString()));
                        x.setNamaUser((String) data.get(2));
                        x.setJenisKelamin((String) data.get(3));
                        x.setPasswordUser((String) data.get(4));
                        
                        System.out.println("Data pengguna Panitia Berhasil Diperbaharui!");
                    } else {
                        System.out.println("Data pengguna Panitia Tidak Ditemukan");
                    }
                    
//                    Query Tabel Panitia
                    String query2 = "UPDATE panitia SET nimPengguna = ?, divisiPanitia = ? WHERE nimPengguna = ?";
                    ps = con.prepareStatement(query2);
                    ps.setLong(1, newNimPengguna);
                    ps.setString(2, newDivisiPanitia);
                    ps.setLong(3, x.getNimUser());
                    
                    int rowsUpdated2 = ps.executeUpdate();
                    if (rowsUpdated2 > 0) {
                        setDivisiPanitia((String) data.get(5));
                        System.out.println("Data Panitia berhasil diperbarui");
                    } else {
                        System.out.println("Data Panitia tidak ditemukan");
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Terdapat Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {rs.close();}
                if (ps != null) {ps.close();}
            } catch (SQLException e) {
                System.out.println("Error menutup koneksi : " + e.getMessage());
            }
        }
        
    }
    
    @Override
    public void delete(String uid) {
        try {
            String query = "DELETE FROM panitia WHERE nimPengguna = (SELECT nimPengguna FROM pengguna WHERE uid = ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, uid);
            
            int rowsDeleted = ps.executeUpdate();
            
            String query2 = "DELETE FROM pengguna WHERE uid = ?";
            ps = con.prepareStatement(query2);
            ps.setString(1, uid);
            
            int rowsDeleted2 = ps.executeUpdate();

            if (rowsDeleted > 0 && rowsDeleted2 > 0) {
                store();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            }
        } catch (SQLException e) {
            System.out.println("Terdapat Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {rs.close();}
                if (ps != null) {ps.close();}
            } catch (SQLException e) {
                System.out.println("Error menutup koneksi : " + e.getMessage());
            }
        }
    }

    @Override
    public void store() {
        try {
            listUser.clear();
            rs = st.executeQuery("SELECT u.uid, u.nimPengguna, u.namaPengguna, u.jenisKelamin, u.password, u.role, p.divisiPanitia FROM pengguna u JOIN panitia p ON u.nimPengguna = p.nimPengguna WHERE u.role = 'Panitia'");
            
            while(rs.next()) {
                String uoid = rs.getString("uid");
                long nim = rs.getLong("nimUser");
                String nama = rs.getString("namaUser");
                String jk = rs.getString("jenisKelamin");
                String password = rs.getString("passwordUser");
                String role = rs.getString("role");
                String divisi = rs.getString(divisiPanitia);
                
                listUser.add(new Panitia(uoid, nim, nama, jk, role, password, divisi));
                
//                if (role.equals("Panitia")) {
//                    String divisi = rs.getString("divisiPanitia");
//                    listUser.add(new Panitia(uoid, nim, nama, jk, role, password, divisi));
//                }
            }
        } catch (SQLException e) {
            System.out.println("Terdapat Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {rs.close();}
                if (ps != null) {ps.close();}
            } catch (SQLException e) {
                System.out.println("Error menutup koneksi : " + e.getMessage());
            }
        }
    }
}
