import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        BukuKontrol bukuKontrol = new BukuKontrol();
        AnggotaKontrol anggotaKontrol = new AnggotaKontrol();
        TransaksiKontrol transaksiKontrol = new TransaksiKontrol();

        while (true) {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Menu Buku");
            System.out.println("2. Menu Anggota");
            System.out.println("3. Menu Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        menuBuku(scanner, bukuKontrol);
                        break;
                    case 2:
                        menuAnggota(scanner, anggotaKontrol);
                        break;
                    case 3:
                        menuTransaksi(scanner, transaksiKontrol);
                        break;
                    case 0:
                        System.out.println("Terima kasih telah menggunakan program Sistem Manajemen Perpustakaan ini.");
                        System.exit(0);
                    default:
                        System.out.println("Menu tidak valid!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Silakan masukkan angka untuk memilih menu.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void menuBuku(Scanner scanner, BukuKontrol bukuKontrol) {
        while (true) {
            System.out.println("\n=== Menu Buku ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Buku");
            System.out.println("3. Ubah Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        tambahBuku(scanner, bukuKontrol);
                        break;
                    case 2:
                        lihatBuku(bukuKontrol);
                        break;
                    case 3:
                        ubahBuku(scanner, bukuKontrol);
                        break;
                    case 4:
                        hapusBuku(scanner, bukuKontrol);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Menu tidak valid!");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Silakan masukkan angka untuk memilih menu.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void menuAnggota(Scanner scanner, AnggotaKontrol anggotaKontrol) {
        while (true) {
            System.out.println("\n=== Menu Anggota ===");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Lihat Anggota");
            System.out.println("3. Ubah Anggota");
            System.out.println("4. Hapus Anggota");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        tambahAnggota(scanner, anggotaKontrol);
                        break;
                    case 2:
                        lihatAnggota(anggotaKontrol);
                        break;
                    case 3:
                        ubahAnggota(scanner, anggotaKontrol);
                        break;
                    case 4:
                        hapusAnggota(scanner, anggotaKontrol);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Menu tidak valid!");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Silakan masukkan angka untuk memilih menu.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void menuTransaksi(Scanner scanner, TransaksiKontrol transaksiKontrol) {
        while (true) {
            System.out.println("\n=== Menu Transaksi ===");
            System.out.println("1. Tambah Transaksi Peminjaman");
            System.out.println("2. Ubah Transaksi Pengembalian");
            System.out.println("3. Lihat Transaksi");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        tambahTransaksiPeminjaman(scanner, transaksiKontrol);
                        break;
                    case 2:
                        ubahTransaksiPengembalian(scanner, transaksiKontrol);
                        break;
                    case 3:
                        lihatTransaksi(transaksiKontrol);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Menu tidak valid!");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Silakan masukkan angka untuk memilih menu.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void tambahBuku(Scanner scanner, BukuKontrol bukuKontrol) throws SQLException {
        System.out.print("Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Penulis: ");
        String penulis = scanner.nextLine();
        System.out.print("Penerbit: ");
        String penerbit = scanner.nextLine();
        System.out.print("Tahun: ");
        int tahun = Integer.parseInt(scanner.nextLine());
        System.out.print("Stok: ");
        int stok = Integer.parseInt(scanner.nextLine());

        System.out.println(bukuKontrol.tambahBuku(judul, penulis, penerbit, tahun, stok));
    }

    private static void lihatBuku(BukuKontrol bukuKontrol) throws SQLException {
        String[] bukuList = bukuKontrol.lihatBuku();
        if (bukuList.length == 0) {
            System.out.println("Tidak ada data buku.");
        } else {
            for (String b : bukuList) {
                System.out.println(b);
            }
        }
    }

    private static void ubahBuku(Scanner scanner, BukuKontrol bukuKontrol) throws SQLException {
        System.out.print("ID Buku: ");
        int idUbahBuku = Integer.parseInt(scanner.nextLine());
        System.out.print("Judul Baru: ");
        String judulBaru = scanner.nextLine();
        System.out.print("Penulis Baru: ");
        String penulisBaru = scanner.nextLine();
        System.out.print("Penerbit Baru: ");
        String penerbitBaru = scanner.nextLine();
        System.out.print("Tahun Baru: ");
        int tahunBaru = Integer.parseInt(scanner.nextLine());
        System.out.print("Stok Baru: ");
        int stokBaru = Integer.parseInt(scanner.nextLine());

        System.out.println(bukuKontrol.ubahBuku(idUbahBuku, judulBaru, penulisBaru, penerbitBaru, tahunBaru, stokBaru));
    }

    private static void hapusBuku(Scanner scanner, BukuKontrol bukuKontrol) throws SQLException {
        System.out.print("ID Buku: ");
        int idHapusBuku = Integer.parseInt(scanner.nextLine());
        System.out.println(bukuKontrol.hapusBuku(idHapusBuku));
    }

    private static void tambahAnggota(Scanner scanner, AnggotaKontrol anggotaKontrol) throws SQLException {
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Telepon: ");
        String telepon = scanner.nextLine();

        System.out.println(anggotaKontrol.tambahAnggota(nama, alamat, telepon));
    }

    private static void lihatAnggota(AnggotaKontrol anggotaKontrol) throws SQLException {
        String[] anggotaList = anggotaKontrol.lihatAnggota();
        if (anggotaList.length == 0) {
            System.out.println("Tidak ada data anggota.");
        } else {
            for (String a : anggotaList) {
                System.out.println(a);
            }
        }
    }

    private static void ubahAnggota(Scanner scanner, AnggotaKontrol anggotaKontrol) throws SQLException {
        System.out.print("ID Anggota: ");
        int idUbahAnggota = Integer.parseInt(scanner.nextLine());
        System.out.print("Nama Baru: ");
        String namaBaru = scanner.nextLine();
        System.out.print("Alamat Baru: ");
        String alamatBaru = scanner.nextLine();
        System.out.print("Telepon Baru: ");
        String teleponBaru = scanner.nextLine();

        System.out.println(anggotaKontrol.ubahAnggota(idUbahAnggota, namaBaru, alamatBaru, teleponBaru));
    }

    private static void hapusAnggota(Scanner scanner, AnggotaKontrol anggotaKontrol) throws SQLException {
        System.out.print("ID Anggota: ");
        int idHapusAnggota = Integer.parseInt(scanner.nextLine());
        System.out.println(anggotaKontrol.hapusAnggota(idHapusAnggota));
    }

    private static void tambahTransaksiPeminjaman(Scanner scanner, TransaksiKontrol transaksiKontrol) throws SQLException {
        System.out.print("ID Buku: ");
        int idBukuPinjam = Integer.parseInt(scanner.nextLine());
        System.out.print("ID Anggota: ");
        int idAnggotaPinjam = Integer.parseInt(scanner.nextLine());

        System.out.println(transaksiKontrol.tambahTransaksiPeminjaman(idBukuPinjam, idAnggotaPinjam));
    }

    private static void ubahTransaksiPengembalian(Scanner scanner, TransaksiKontrol transaksiKontrol) throws SQLException {
        System.out.print("ID Transaksi: ");
        int idTransaksiKembali = Integer.parseInt(scanner.nextLine());

        System.out.println(transaksiKontrol.ubahTransaksiPengembalian(idTransaksiKembali));
    }

    private static void lihatTransaksi(TransaksiKontrol transaksiKontrol) throws SQLException {
        String[] transaksiList = transaksiKontrol.lihatTransaksi();
        if (transaksiList.length == 0) {
            System.out.println("Tidak ada data transaksi.");
        } else {
            for (String t : transaksiList) {
                System.out.println(t);
            }
        }
    }
}
