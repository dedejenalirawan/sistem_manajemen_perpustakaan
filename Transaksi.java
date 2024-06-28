/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author talen
 */
import java.sql.Date;

public class Transaksi {
    private int id;
    private int idBuku;
    private int idAnggota;
    private Date tanggalPinjam;
    private Date tanggalKembali;
    private String status;

    public Transaksi(int id, int idBuku, int idAnggota, Date tanggalPinjam, Date tanggalKembali, String status) {
        this.id = id;
        this.idBuku = idBuku;
        this.idAnggota = idAnggota;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdBuku() { return idBuku; }
    public void setIdBuku(int idBuku) { this.idBuku = idBuku; }
    public int getIdAnggota() { return idAnggota; }
    public void setIdAnggota(int idAnggota) { this.idAnggota = idAnggota; }
    public Date getTanggalPinjam() { return tanggalPinjam; }
    public void setTanggalPinjam(Date tanggalPinjam) { this.tanggalPinjam = tanggalPinjam; }
    public Date getTanggalKembali() { return tanggalKembali; }
    public void setTanggalKembali(Date tanggalKembali) { this.tanggalKembali = tanggalKembali; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

