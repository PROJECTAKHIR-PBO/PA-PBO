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
public class Bindam extends User implements crud {
    private int kelompokBindam;

    public Bindam(String uid, long nimUser, String namaUser, String jenisKelamin, String role, String passwordUser, int kelompokBindam) {
        super(uid, nimUser, namaUser, jenisKelamin, role, passwordUser);
        this.kelompokBindam = kelompokBindam;
    }

    public int getKelompokBindam() {
        return kelompokBindam;
    }

    public void setKelompokBindam(int kelompokBindam) {
        this.kelompokBindam = kelompokBindam;
    }

    @Override
    public void create() {
        try {
//            Query Tabel Pengguna
            String newUid = generateUID();
            String query = "INSERT INTO pengguna (uid, nimPengguna, namaPengguna, jenisKelamin, password, role) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            
            ps.setString(1, newUid);
            ps.setLong(2, getNimUser());
            ps.setString(3, getNamaUser());
            ps.setString(4, getJenisKelamin());
            ps.setString(5, getPasswordUser());
            ps.setString(6, "Bindam");
            
            int rowsInserted = ps.executeUpdate();
            
//            Query Tabel Bindam
            String query2 = "INSERT INTO bindam (nimPengguna, kelompokBindam) VALUES (?, ?)";
            ps = con.prepareStatement(query2);
            
            ps.setLong(1, getNimUser());
            ps.setInt(2, getKelompokBindam());            
            
            int rowsInserted2 = ps.executeUpdate();

            //            Pesan Konfirmasi Create
            if (rowsInserted > 0 && rowsInserted2 > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ada Error Create Bindam : " + e.getMessage());
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
            System.out.println("Tidak Ada Admin Yang Terdaftar");
            System.out.println("=================================");
        } else {
            for (User x : listUser) {
                if (x instanceof Bindam b) {
                    System.out.println("Nim : " + b.getNimUser());
                    System.out.println("Nama : " + b.getNamaUser());
                    System.out.println("JK : " + b.getJenisKelamin());
                    System.out.println("Password : " + b.getPasswordUser());
                    System.out.println("Role : " + b.getRole());
                    System.out.println("Kelompok : " + b.getKelompokBindam());
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
                    int newKelompokBindam = (int) data.get(4);
                    
//                    Query Tabel Pengguna
                    String query = "UPDATE pengguna SET nimPengguna = ?, namaPengguna = ?, jenisKelamin = ?, password = ? WHERE uid = ? AND role = 'Bindam'";
                    ps = con.prepareStatement(query);
                    ps.setLong(1, newNimPengguna);
                    ps.setString(2, newNamaPengguna);
                    ps.setString(3, newJenisKelamin);
                    ps.setString(4, newPassword);
                    ps.setString(5, uid);
                    
                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                        x.setNimUser(newNimPengguna);
                        x.setNamaUser(newNamaPengguna);
                        x.setJenisKelamin(newJenisKelamin);
                        x.setPasswordUser(newPassword);
                        
                        System.out.println("Data Pengguna Bindam Berhasil Diperbaharui");
                    } else {
                        System.out.println("Data PenggunaBindam Tidak Ditemukan");
                    }
                    
                    
//                    Query Tabel Bindam
                    String query2 = "UPDATE bindam SET nimPengguna = ?, kelompokBindam = ? WHERE nimPengguna = ?";
                    ps = con.prepareStatement(query2);
                    ps.setLong(1, newNimPengguna);
                    ps.setInt(2, newKelompokBindam);
                    ps.setLong(3, x.getNimUser());

                    int rowsUpdated2 = ps.executeUpdate();
                    if (rowsUpdated2 > 0) {
                        setKelompokBindam(newKelompokBindam);
                        System.out.println("Data Bindam berhasil diperbarui");
                    } else {
                        System.out.println("Data Bindam tidak ditemukan");
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Terdapat Error Update : " + e.getMessage());
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
//            Query Tabel Bindam
            String query = "DELETE FROM bindam WHERE nimPengguna = (SELECT nimPengguna FROM pengguna WHERE uid = ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, uid);
            
            int rowsDeleted = ps.executeUpdate();
            
//            Query Tabel Pengguna
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
            System.out.println("Terdapat Error Delete : " + e.getMessage());
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
            rs = st.executeQuery("SELECT p.uid, p.nimPengguna, p.namaPengguna, p.jenisKelamin, p.password, p.role, b.kelompokBindam FROM pengguna p JOIN bindam b ON p.nimPengguna = b.nimPengguna WHERE p.role = 'Bindam'");
            
            while(rs.next()) {
                String uoid = rs.getString("uid");
                long nim = rs.getLong("nimPengguna");
                String nama = rs.getString("namaPengguna");
                String jk = rs.getString("jenisKelamin");
                String password = rs.getString("password");
                String role = rs.getString("role");
                int kelompok = rs.getInt("kelompokBindam");
                
                listUser.add(new Bindam(uoid, nim, nama, jk, role, password, kelompok));
                
//                if (role.equals("Bindam")) {
//                    int kelompok = rs.getInt("kelompokBindam");
//                    listUser.add(new Bindam(uoid, nim, nama, jk, role, password, kelompok));
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