/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import static model.UIDGenerator.generateUID;

/**
 *
 * @author Nova Nur Fauziah
 */
public class Admin extends User implements crud{
    private String kodeAdmin;

    public Admin(String uid, long nimUser, String namaUser, String jenisKelamin, String role, String passwordUser, String kodeAdmin) {
        super(uid,nimUser, namaUser, jenisKelamin, role, passwordUser);
        this.kodeAdmin = kodeAdmin;
    }
    
        public String getKodeAdmin() {
        return kodeAdmin;
    }

    public void setKodeAdmin(String kodeAdmin) {
        this.kodeAdmin = kodeAdmin;
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
            ps.setString(6, "Admin");
            
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data Tabel User Admin Berhasil Disimpan");
            } else {
                System.out.println("Data Tabel User Admin Gagal Disimpan");
            }
            
//            Query Tabel Admin
            String query2 = "INSERT INTO admin (nimPengguna, kodeAdmin) VALUES (?, ?)";
            ps = con.prepareStatement(query2);
            
            ps.setLong(1, getNimUser());
            ps.setString(2, getKodeAdmin());            
            
            int rowsInserted2 = ps.executeUpdate();
            if (rowsInserted2 > 0) {
                System.out.println("Data Tabel Admin Berhasil Disimpan");
            } else {
                System.out.println("Data Tabel Admin Gagal Disimpan");
            }
            
//            Pesan Konfirmasi Create
            if (rowsInserted > 0 && rowsInserted2 > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
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
            System.out.println("Tidak Ada Admin Yang Terdaftar");
            System.out.println("=================================");
        } else {
            for (User x : listUser) {
                if (x instanceof Admin a) {
                    System.out.println("Nim : " + a.getNimUser());
                    System.out.println("Nama : " + a.getNamaUser());
                    System.out.println("JK : " + a.getJenisKelamin());
                    System.out.println("Password : " + a.getPasswordUser());
                    System.out.println("Role : " + a.getRole());
                    System.out.println("Kode : " + a.getKodeAdmin());
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
                    String newKodeAdmin = (String) data.get(4);

//                    Query Tabel Pengguna
                    String query = "UPDATE pengguna SET nimPengguna = ?, namaPengguna = ?, jenisKelamin = ?, password = ? WHERE uid = ? AND role = 'Admin'";
                    ps = con.prepareStatement(query);
                    ps.setLong(1, newNimPengguna);
                    ps.setString(2, newNamaPengguna);
                    ps.setString(3, newJenisKelamin);
                    ps.setString(4, newPassword);
                    ps.setString(5, uid);

                    int rowsUpdatedUser = ps.executeUpdate();
                    if (rowsUpdatedUser > 0) {
                        x.setNimUser(newNimPengguna);
                        x.setNamaUser(newNamaPengguna);
                        x.setJenisKelamin(newJenisKelamin);
                        x.setPasswordUser(newPassword);

                        System.out.println("Data pengguna Admin berhasil diperbarui");
                    } else {
                        System.out.println("Data pengguna Admin tidak ditemukan");
                    }

//                    Query Tabel Admin
                    String query2 = "UPDATE admin SET nimPengguna = ?, kodeAdmin = ? WHERE nimPengguna = ?";
                    ps = con.prepareStatement(query2);
                    ps.setLong(1, newNimPengguna);
                    ps.setString(2, newKodeAdmin);
                    ps.setLong(3, x.getNimUser());

                    int rowsUpdated2 = ps.executeUpdate();
                    if (rowsUpdated2 > 0) {
                        setKodeAdmin(newKodeAdmin);
                        System.out.println("Data Admin berhasil diperbarui");
                    } else {
                        System.out.println("Data Admin tidak ditemukan");
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Terdapat Error Update: " + e.getMessage());
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
//            Query Tabel Admin
            String query = "DELETE FROM admin WHERE nimPengguna = (SELECT nimPengguna FROM pengguna WHERE uid = ?)";
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
            System.out.println("Terdapat Error Delete: " + e.getMessage());
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
            rs = st.executeQuery("SELECT p.uid, p.nimPengguna, p.namaPengguna, p.jenisKelamin, p.password, p.role, a.kodeAdmin FROM pengguna p JOIN admin a ON p.nimPengguna = a.nimPengguna WHERE p.role = 'Admin'");
                
            while(rs.next()) {
                String uoid = rs.getString("uid");
                long nim = rs.getLong("nimPengguna");
                String nama = rs.getString("namaPengguna");
                String jk = rs.getString("jenisKelamin");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String kode = rs.getString("kodeAdmin");
                
                listUser.add(new Admin(uoid, nim, nama, jk, role, password, kode));
                
//                if (role.equals("Admin")) {
//                    String kode = rs.getString("kodeAdmin");
//                    listUser.add(new Admin(uoid, nim, nama, jk, role, password, kode));
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