/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import static model.UIDGenerator2.generateUID2;

/**
 *
 * @author Nova Nur Fauziah
 */
public class Penilaian extends Database{
    private String idPenilaian;
    private int nilaiKomunikasi;
    private String keteranganKomunikasi;
    private int nilaiEtika;
    private String keteranganEtika;
    private int nilaiKerjasama;
    private String keteranganKerjasama;
    private int nilaiKepemimpinan;
    private String keteranganKepemimpinan;
    private int nilaiKeaktifan;
    private String keteranganKeaktifan;
    private int mingguKe;
    private long nimPeserta;
    private long nimBindam;
    private ArrayList<Penilaian> listPenilaian = new ArrayList<>();

    public Penilaian(String idPenilaian, int nilaiKomunikasi, String keteranganKomunikasi, int nilaiEtika, String keteranganEtika, int nilaiKerjasama, String keteranganKerjasama, int nilaiKepemimpinan, String keteranganKepemimpinan, int nilaiKeaktifan, String keteranganKeaktifan, int mingguKe, long nimPeserta, long nimBindam) {
        this.idPenilaian = idPenilaian;
        this.nilaiKomunikasi = nilaiKomunikasi;
        this.keteranganKomunikasi = keteranganKomunikasi;
        this.nilaiEtika = nilaiEtika;
        this.keteranganEtika = keteranganEtika;
        this.nilaiKerjasama = nilaiKerjasama;
        this.keteranganKerjasama = keteranganKerjasama;
        this.nilaiKepemimpinan = nilaiKepemimpinan;
        this.keteranganKepemimpinan = keteranganKepemimpinan;
        this.nilaiKeaktifan = nilaiKeaktifan;
        this.keteranganKeaktifan = keteranganKeaktifan;
        this.mingguKe = mingguKe;
        this.nimPeserta = nimPeserta;
        this.nimBindam = nimBindam;
    }

    public String getIdPenilaian() {
        return idPenilaian;
    }

    public void setIdPenilaian(String idPenilaian) {
        this.idPenilaian = idPenilaian;
    }

    public int getNilaiKomunikasi() {
        return nilaiKomunikasi;
    }

    public void setNilaiKomunikasi(int nilaiKomunikasi) {
        this.nilaiKomunikasi = nilaiKomunikasi;
    }

    public String getKeteranganKomunikasi() {
        return keteranganKomunikasi;
    }

    public void setKeteranganKomunikasi(String keteranganKomunikasi) {
        this.keteranganKomunikasi = keteranganKomunikasi;
    }

    public int getNilaiEtika() {
        return nilaiEtika;
    }

    public void setNilaiEtika(int nilaiEtika) {
        this.nilaiEtika = nilaiEtika;
    }

    public String getKeteranganEtika() {
        return keteranganEtika;
    }

    public void setKeteranganEtika(String keteranganEtika) {
        this.keteranganEtika = keteranganEtika;
    }

    public int getNilaiKerjasama() {
        return nilaiKerjasama;
    }

    public void setNilaiKerjasama(int nilaiKerjasama) {
        this.nilaiKerjasama = nilaiKerjasama;
    }

    public String getKeteranganKerjasama() {
        return keteranganKerjasama;
    }

    public void setKeteranganKerjasama(String keteranganKerjasama) {
        this.keteranganKerjasama = keteranganKerjasama;
    }

    public int getNilaiKepemimpinan() {
        return nilaiKepemimpinan;
    }

    public void setNilaiKepemimpinan(int nilaiKepemimpinan) {
        this.nilaiKepemimpinan = nilaiKepemimpinan;
    }

    public String getKeteranganKepemimpinan() {
        return keteranganKepemimpinan;
    }

    public void setKeteranganKepemimpinan(String keteranganKepemimpinan) {
        this.keteranganKepemimpinan = keteranganKepemimpinan;
    }

    public int getNilaiKeaktifan() {
        return nilaiKeaktifan;
    }

    public void setNilaiKeaktifan(int nilaiKeaktifan) {
        this.nilaiKeaktifan = nilaiKeaktifan;
    }

    public String getKeteranganKeaktifan() {
        return keteranganKeaktifan;
    }

    public void setKeteranganKeaktifan(String keteranganKeaktifan) {
        this.keteranganKeaktifan = keteranganKeaktifan;
    }

    public long getNimPeserta() {
        return nimPeserta;
    }

    public void setNimPeserta(long nimPeserta) {
        this.nimPeserta = nimPeserta;
    }

    public long getNimBindam() {
        return nimBindam;
    }

    public void setNimBindam(long nimBindam) {
        this.nimBindam = nimBindam;
    }

    public int getMingguKe() {
        return mingguKe;
    }

    public void setMingguKe(int mingguKe) {
        this.mingguKe = mingguKe;
    }
    
    public ArrayList<Penilaian> getListPenilaian() {
        return listPenilaian;
    }
    
    public Penilaian() {this.store();}
    
    public void create() {
        try {
            
            String newIdPenilaian = generateUID2();
            String query = "INSERT INTO penilaian (idPenilaian, nilaiKomunikasi, keteranganKomunikasi, nilaiEtika, keteranganEtika, nilaiKerjasama, keteranganKerjasama, nilaiKepemimpinan, keteranganKepemimpinan, nilaiKeaktifan, keteranganKeaktifan, mingguKe, peserta_nimPeserta, pengguna_nimPengguna) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            
            ps.setString(1, newIdPenilaian); // ID Penilaian
            ps.setInt(2, 1);
            ps.setString(3, "");
            ps.setInt(4, 1);
            ps.setString(5, "");
            ps.setInt(6, 1);
            ps.setString(7, "");
            ps.setInt(8, 1);
            ps.setString(9, "");
            ps.setInt(10, 1);
            ps.setString(11, "");
            ps.setInt(12, 1); //Minggu Ke Berapa
            ps.setLong(13, 13); //Nim Peserta
            ps.setLong(14, 14); //Nim Bindam
            
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data Penilaian berhasil ditambahkan");
            } else {
                System.out.println("Data Penilaian Gagal Ditambahkan");
            }
            
        } catch (SQLException e) {
            System.out.println("Terdapat Error Create: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {rs.close();}
                if (ps != null) {ps.close();}
            } catch (SQLException e) {
                System.out.println("Error menutup koneksi : " + e.getMessage());
            }
        }
    }

    public void read() {
        if (listPenilaian.isEmpty()) {
            System.out.println("Belum ada penilaian yang diberikan");
            System.out.println("==================================");
        } else {
            for (Penilaian p:listPenilaian) {
                System.out.println("Peserta = " + p.getNimPeserta());
                System.out.println("Penilai = " + p.getNimBindam());
                System.out.println("Minggu Ke = " + p.getMingguKe());
                System.out.println("===================================");
            }
        }
    }
    
    public void detail(String idPenilaian) {
        try {
            String query = "SELECT * FROM penilaian WHERE idPenilaian = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, idPenilaian);
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID Penilaian: " + rs.getString("idPenilaian"));
                System.out.println("Nilai Komunikasi: " + rs.getInt("nilaiKomunikasi"));
                System.out.println("Keterangan Komunikasi: " + rs.getString("keteranganKomunikasi"));
                System.out.println("Nilai Etika: " + rs.getInt("nilaiEtika"));
                System.out.println("Keterangan Etika: " + rs.getString("keteranganEtika"));
                System.out.println("Nilai Kerjasama: " + rs.getInt("nilaiKerjasama"));
                System.out.println("Keterangan Kerjasama: " + rs.getString("keteranganKerjasama"));
                System.out.println("Nilai Kepemimpinan: " + rs.getInt("nilaiKepemimpinan"));
                System.out.println("Keterangan Kepemimpinan: " + rs.getString("keteranganKepemimpinan"));
                System.out.println("Nilai Keaktifan: " + rs.getInt("nilaiKeaktifan"));
                System.out.println("Keterangan Keaktifan: " + rs.getString("keteranganKeaktifan"));
                System.out.println("Minggu Ke: " + rs.getInt("mingguKe"));
                System.out.println("Peserta NIM: " + rs.getLong("peserta_nimPeserta"));
                System.out.println("Bindam NIM: " + rs.getLong("pengguna_nimPengguna"));
            } else {
                System.out.println("Penilaian tidak ditemukan");
            }
        } catch (SQLException e) {
            System.out.println("Terdapat Error Show Detail: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {rs.close();}
                if (ps != null) {ps.close();}
            } catch (SQLException e) {
                System.out.println("Error menutup koneksi : " + e.getMessage());
            }
        }
    }

    public void update(String idPenilaian, List<Object> data) {
        try {
            String query = "UPDATE penilaian SET nilaiKomunikasi = ?, keteranganKomunikasi = ?, nilaiEtika = ?, keteranganEtika = ?, nilaiKerjasama = ?, keteranganKerjasama = ?, nilaiKepemimpinan = ?, keteranganKepemimpinan = ?, nilaiKeaktifan = ?, keteranganKeaktifan = ?, mingguKe = ? WHERE idPenilaian = ?";
            ps = con.prepareStatement(query);
            
            for(Penilaian p:listPenilaian) {
                if (p.getIdPenilaian().equals(idPenilaian)) {
                    int newNilaiKomunikasi = (int) data.get(0);
                    String newKeteranganKomunikasi = (String) data.get(1);
                    int newNilaiEtika = (int) data.get(2);
                    String newKeteranganEtika = (String) data.get(3);
                    int newNilaiKerjasama = (int) data.get(4);
                    String newKeteranganKerjasama = (String) data.get(5);
                    int newNilaiKepemimpinan = (int) data.get(6);
                    String newKeteranganKepemimpinan = (String) data.get(7);
                    int newNilaiKeaktifan = (int) data.get(8);
                    String newKeteranganKeaktifan = (String) data.get(9);
                    int newMingguKe = (int) data.get(10);
                    
                    ps.setInt(1, newNilaiKomunikasi);
                    ps.setString(2, newKeteranganKomunikasi);
                    ps.setInt(3, newNilaiEtika);
                    ps.setString(4, newKeteranganEtika);
                    ps.setInt(5, newNilaiKerjasama);
                    ps.setString(6, newKeteranganKerjasama);
                    ps.setInt(7, newNilaiKepemimpinan);
                    ps.setString(8, newKeteranganKepemimpinan);
                    ps.setInt(9, newNilaiKeaktifan);
                    ps.setString(10, newKeteranganKeaktifan);
                    ps.setInt(11, newMingguKe);
                    
                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                        p.setNilaiKomunikasi((int) data.get(0));
                        p.setKeteranganKomunikasi((String) data.get(1));
                        p.setNilaiEtika((int) data.get(2));
                        p.setKeteranganEtika((String) data.get(3));
                        p.setNilaiKerjasama((int) data.get(4));
                        p.setKeteranganKerjasama((String) data.get(5));
                        p.setNilaiKepemimpinan((int) data.get(6));
                        p.setKeteranganKepemimpinan((String) data.get(7));
                        p.setNilaiKeaktifan((int) data.get(8));
                        p.setKeteranganKeaktifan((String) data.get(9));
                        p.setMingguKe((int) data.get(10));
                        
                        System.out.println("Data Penilaian Berhasil Diperbaharui");
                    } else {
                        System.out.println("Data Penilaian Gagal Diperbaharui");
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

    public void delete(String idPenilaian) {
        try {
            String query = "DELETE FROM penilaian WHERE idPenilaian = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, idPenilaian);
            
            int RowsDeleted = ps.executeUpdate();
            
            if (RowsDeleted > 0) {
                System.out.println("Data Penilaian Berhasil Dihapus");
            } else {
                System.out.println("Data Penilaian Gagal Dihapus");
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

    public void store() {
        try {
            listPenilaian.clear();
            
            rs = st.executeQuery("SELECT * FROM penilaian");
            
            while (rs.next()) {
                String idp = rs.getString("idPenilaian");
                int nKomunikasi = rs.getInt("nilaiKomunikasi");
                String kKomunikasi = rs.getString("keteranganKomunikasi");
                int nEtika = rs.getInt("nilaiEtika");
                String kEtika = rs.getString("keteranganEtika");
                int nKerjasama = rs.getInt("nilaiKerjasama");
                String kKerjasama = rs.getString("keteranganKerjasama");
                int nKepemimpinan = rs.getInt("nilaiKepemimpinan");
                String kKepemimpinan = rs.getString(keteranganKepemimpinan);
                int nKeaktifan = rs.getInt("nilaiKeaktifan");
                String kKeaktifan = rs.getString("keteranganKeaktifan");
                int minggu = rs.getInt("mingguKe");
                long nimp = rs.getLong("peserta_nimPeserta");
                long nimb = rs.getLong("pengguna_nimPengguna");
                
                listPenilaian.add(new Penilaian(idp, nKomunikasi, kKomunikasi, nEtika, kEtika, nKerjasama, kKerjasama, nKepemimpinan, kKepemimpinan, nKeaktifan, kKeaktifan, minggu, nimp, nimb));
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
    
    public List<Penilaian> getMatchingKelompokData() throws SQLException {
        List<Penilaian> penilaianList = new ArrayList<>();
        String query = "SELECT idPenilaian, kelompokPeserta, kelompokBindam, nilaiKomunikasi, nilaiEtika, " +
                       "nilaiKerjasama, nilaiKepemimpinan, nilaiKeaktifan, keteranganKomunikasi, keteranganEtika, " +
                       "keteranganKerjasama, keteranganKepemimpinan, keteranganKeaktifan, mingguKe, peserta_nimPeserta, " +
                       "pengguna_nimPengguna " +
                       "FROM penilaian WHERE kelompokPeserta = kelompokBindam";

        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Penilaian penilaian = new Penilaian(
                    rs.getString("idPenilaian"),
                    rs.getInt("nilaiKomunikasi"),
                    rs.getString("keteranganKomunikasi"),
                    rs.getInt("nilaiEtika"),
                    rs.getString("keteranganEtika"),
                    rs.getInt("nilaiKerjasama"),
                    rs.getString("keteranganKerjasama"),
                    rs.getInt("nilaiKepemimpinan"),
                    rs.getString("keteranganKepemimpinan"), // Perbaiki tanda kutip di sini
                    rs.getInt("nilaiKeaktifan"),
                    rs.getString("keteranganKeaktifan"),
                    rs.getInt("mingguKe"),
                    rs.getLong("peserta_nimPeserta"),
                    rs.getLong("pengguna_nimPengguna")
                );
                penilaianList.add(penilaian);
            }
        } catch (SQLException e) {
            System.err.println("Error saat menjalankan query getMatchingKelompokData: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {rs.close();}
                if (ps != null) {ps.close();}
            } catch (SQLException e) {
                System.out.println("Error menutup koneksi: " + e.getMessage());
            }
        }

        return penilaianList;
    }
}