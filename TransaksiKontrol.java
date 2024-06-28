import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransaksiKontrol {
    private Connection conn;

    public TransaksiKontrol() throws SQLException {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    public String tambahTransaksiPeminjaman(int idBuku, int idAnggota) throws SQLException {
        String query = "INSERT INTO transaksi (id_buku, id_anggota, tanggal_pinjam, status) VALUES (?, ?, NOW(), 'Dipinjam')";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idBuku);
            stmt.setInt(2, idAnggota);
            int rowsAffected = stmt.executeUpdate();
            return "Transaksi peminjaman berhasil ditambahkan, " + rowsAffected + " baris terpengaruh.";
        }
    }

    public String ubahTransaksiPengembalian(int idTransaksi) throws SQLException {
        String query = "UPDATE transaksi SET tanggal_kembali = NOW(), status = 'Dikembalikan' WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idTransaksi);
            int rowsAffected = stmt.executeUpdate();
            return "Transaksi pengembalian berhasil diubah, " + rowsAffected + " baris terpengaruh.";
        }
    }

    public String[] lihatTransaksi() throws SQLException {
        String query = "SELECT * FROM transaksi";
        ArrayList<String> transaksiList = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                transaksiList.add("ID: " + rs.getInt("id") + ", ID Buku: " + rs.getInt("id_buku") +
                                  ", ID Anggota: " + rs.getInt("id_anggota") + ", Tanggal Pinjam: " + rs.getDate("tanggal_pinjam") +
                                  ", Tanggal Kembali: " + rs.getDate("tanggal_kembali") + ", Status: " + rs.getString("status"));
            }
        }
        return transaksiList.toArray(new String[0]);
    }
}
