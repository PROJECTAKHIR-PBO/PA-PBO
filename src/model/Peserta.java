/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static model.UIDGenerator.generateUID;

/**
 *
 * @author Nova Nur Fauziah
 */
public class Peserta extends Database implements crud{
    private String uid;
    private long nimPeserta;
    private String namaPeserta;
    private String jenisKelamin;
    private String nomorHpPeserta;
    private int kelompokPeserta;
    private ArrayList<Peserta> listPeserta = new ArrayList<>();

    public Peserta(String uid, long nimPeserta, String namaPeserta, String jenisKelamin, String nomorHpPeserta, int kelompokPeserta) {
        super();
        this.uid = uid;
        this.nimPeserta = nimPeserta;
        this.namaPeserta = namaPeserta;
        this.jenisKelamin = jenisKelamin;
        this.nomorHpPeserta = nomorHpPeserta;
        this.kelompokPeserta = kelompokPeserta;
    }
    
    public String getUid() {
        return uid;
    }
    
    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getNimPeserta() {
        return nimPeserta;
    }

    public void setNimPeserta(long nimPeserta) {
        this.nimPeserta = nimPeserta;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNomorHpPeserta() {
        return nomorHpPeserta;
    }

    public void setNomorHpPeserta(String nomorHpPeserta) {
        this.nomorHpPeserta = nomorHpPeserta;
    }

    public int getKelompokPeserta() {
        return kelompokPeserta;
    }

    public void setKelompokPeserta(int kelompokPeserta) {
    this.kelompokPeserta = kelompokPeserta;
}

    public ArrayList<Peserta> getListPeserta() {
        return listPeserta;
    }
    
//    Validator NIM Peserta
    private boolean isNimUsed(long nimPeserta) {
        for (Peserta x:listPeserta) {
            if (x.getNimPeserta() == nimPeserta) {
                return false;
            }
        }
        return true;
    }

    public Peserta() {this.store();}
    
    @Override
    public void create() {
        try {
            String newUid = generateUID();
            ps = con.prepareStatement("INSERT INTO peserta (uid, nimPeserta, namaPeserta, jenisKelamin, noHp, kelompokPeserta) VALUES (?, ?, ?, ?, ?, ?)");
            
            ps.setString(1, newUid);
            ps.setLong(2, getNimPeserta());
            ps.setString(3, getNamaPeserta());
            ps.setString(4, getJenisKelamin());
            ps.setString(5, getNomorHpPeserta());
            ps.setInt(6, getKelompokPeserta());
            
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
                store();
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terdapat Error Create : " + e.getMessage() );
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
        if (listPeserta.isEmpty()) {
            System.out.println("Tidak Ada Peserta Yang Terdaftar.");
            System.out.println("=================================");
        } else {
            for (Peserta x:listPeserta) {
                System.out.println("Nim : " + x.getNimPeserta());
                System.out.println("Nama : " + x.getNamaPeserta());
                System.out.println("JK : " + x.getJenisKelamin());
                System.out.println("Nomor HP : " + x.getNomorHpPeserta());
                System.out.println("Kelompok : " + x.getKelompokPeserta());
                System.out.println("=======================================");
            }
        }
    }
    
    @Override
    public void update(String uid,  List<Object> data) {
        try {
            String query = "UPDATE peserta SET nimPeserta = ?, namaPeserta = ?, jenisKelamin = ?, noHp= ?, kelompokPeserta = ? WHERE uid = ?";
            ps = con.prepareStatement(query);

            for (Peserta x : listPeserta) {
                if (x.getUid().equals(uid)) {
                    long newNimPeserta = Long.parseLong(data.get(0).toString());
                    String newNamaPeserta = (String) data.get(1);
                    String newJenisKelamin = (String) data.get(2);
                    String newNomorHpPeserta = (String) data.get(3);
                    int newKelompokPeserta = (int) data.get(4);
                    
                    ps.setLong(1, newNimPeserta);
                    ps.setString(2, newNamaPeserta);
                    ps.setString(3, newJenisKelamin);
                    ps.setString(4, newNomorHpPeserta);
                    ps.setInt(5, newKelompokPeserta);
                    ps.setString(6, uid);

                    int rowsUpdated = ps.executeUpdate();

                    if (rowsUpdated > 0) {
                        x.setNimPeserta(Long.parseLong(data.get(0).toString()));
                        x.setNamaPeserta((String) data.get(1));
                        x.setJenisKelamin((String) data.get(2));
                        x.setNomorHpPeserta((String) data.get(3));
                        x.setKelompokPeserta((int) data.get(4));
                        
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
                        store();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Gagal Diperbarui");
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
            String query = "DELETE FROM peserta WHERE uid = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uid);
            
            int RowsDeleted = ps.executeUpdate();
            
            if (RowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                store();
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
            listPeserta.clear();
            
            rs = st.executeQuery("SELECT * FROM peserta");
            
            while (rs.next()) {
                String uoid = rs.getString("uid");
                long nim = rs.getLong("nimPeserta");
                String nama = rs.getString("namaPeserta");
                String jk = rs.getString("jenisKelamin");
                String noHp = rs.getString("noHp");
                int kel = rs.getInt("kelompokPeserta");
                
                listPeserta.add(new Peserta(uoid, nim, nama, jk, noHp, kel));
            }
            
        } catch (SQLException e) {
            System.out.println("Terdapat Error Store: " + e.getMessage());
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