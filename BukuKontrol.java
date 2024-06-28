import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BukuKontrol {
    private Connection conn;

    public BukuKontrol() throws SQLException {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    public String tambahBuku(String judul, String penulis, String penerbit, int tahun, int stok) throws SQLException {
        String query = "INSERT INTO buku (judul, penulis, penerbit, tahun, stok) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setString(3, penerbit);
            stmt.setInt(4, tahun);
            stmt.setInt(5, stok);
            int rowsAffected = stmt.executeUpdate();
            return "Buku berhasil ditambahkan, " + rowsAffected + " baris terpengaruh.";
        }
    }

    public String[] lihatBuku() throws SQLException {
        String query = "SELECT * FROM buku";
        ArrayList<String> bukuList = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                bukuList.add("ID: " + rs.getInt("id") + ", Judul: " + rs.getString("judul") +
                             ", Penulis: " + rs.getString("penulis") + ", Penerbit: " + rs.getString("penerbit") +
                             ", Tahun: " + rs.getInt("tahun") + ", Stok: " + rs.getInt("stok"));
            }
        }
        return bukuList.toArray(new String[0]);
    }

    public String ubahBuku(int id, String judul, String penulis, String penerbit, int tahun, int stok) throws SQLException {
        String query = "UPDATE buku SET judul = ?, penulis = ?, penerbit = ?, tahun = ?, stok = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setString(3, penerbit);
            stmt.setInt(4, tahun);
            stmt.setInt(5, stok);
            stmt.setInt(6, id);
            int rowsAffected = stmt.executeUpdate();
            return "Buku berhasil diubah, " + rowsAffected + " baris terpengaruh.";
        }
    }

    public String hapusBuku(int id) throws SQLException {
        String query = "DELETE FROM buku WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return "Buku berhasil dihapus, " + rowsAffected + " baris terpengaruh.";
        }
    }
}
