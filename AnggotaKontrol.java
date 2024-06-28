import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnggotaKontrol {
    private Connection conn;

    public AnggotaKontrol() throws SQLException {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    public String tambahAnggota(String nama, String alamat, String telepon) throws SQLException {
        String query = "INSERT INTO anggota (nama, alamat, telepon) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setString(2, alamat);
            stmt.setString(3, telepon);
            int rowsAffected = stmt.executeUpdate();
            return "Anggota berhasil ditambahkan, " + rowsAffected + " baris terpengaruh.";
        }
    }

    public String[] lihatAnggota() throws SQLException {
        String query = "SELECT * FROM anggota";
        ArrayList<String> anggotaList = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                anggotaList.add("ID: " + rs.getInt("id") + ", Nama: " + rs.getString("nama") +
                                ", Alamat: " + rs.getString("alamat") + ", Telepon: " + rs.getString("telepon"));
            }
        }
        return anggotaList.toArray(new String[0]);
    }

    public String ubahAnggota(int id, String nama, String alamat, String telepon) throws SQLException {
        String query = "UPDATE anggota SET nama = ?, alamat = ?, telepon = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setString(2, alamat);
            stmt.setString(3, telepon);
            stmt.setInt(4, id);
            int rowsAffected = stmt.executeUpdate();
            return "Anggota berhasil diubah, " + rowsAffected + " baris terpengaruh.";
        }
    }

    public String hapusAnggota(int id) throws SQLException {
        String query = "DELETE FROM anggota WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return "Anggota berhasil dihapus, " + rowsAffected + " baris terpengaruh.";
        }
    }
}
