package main;

import model.Pegawai;
import factory.PegawaiFactory;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class MainSistemGaji
 * Entry point untuk sistem penggajian pegawai
 * Mendemonstrasikan penggunaan:
 * - Interface (IPerhitunganGaji)
 * - Abstract Class (Pegawai)
 * - Polimorfisme (berbagai jenis pegawai)
 * - Package (model, interfaces, factory, main)
 */
public class MainSistemGaji {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pegawai> daftarPegawai = new ArrayList<>();
        
        System.out.println("============================================");
        System.out.println("       SISTEM PENGGAJIAN PEGAWAI           ");
        System.out.println("============================================");
        System.out.println("Universitas Siber Asia - IF504");
        System.out.println("Mata Kuliah: Pemrograman Berbasis Objek");
        System.out.println("============================================\n");
        
        boolean lanjut = true;
        
        while (lanjut) {
            try {
                System.out.println("\n--- INPUT DATA PEGAWAI ---");
                System.out.println("Kode Jabatan:");
                System.out.println("  SPV = Supervisor");
                System.out.println("  HRD = HRD");
                System.out.println("  TKN = Teknisi");
                System.out.println("  KRY = Karyawan");
                System.out.print("Masukkan Kode Jabatan: ");
                String kode = scanner.nextLine().toUpperCase().trim();
                
                System.out.print("Nama Pegawai: ");
                String nama = scanner.nextLine().trim();
                
                System.out.print("Jam Masuk (1-24): ");
                int jamMasuk = Integer.parseInt(scanner.nextLine().trim());
                
                System.out.print("Jam Keluar (1-24): ");
                int jamKeluar = Integer.parseInt(scanner.nextLine().trim());
                
                System.out.print("Sudah Menikah? (y/n): ");
                boolean menikah = scanner.nextLine().trim().equalsIgnoreCase("y");
                
                System.out.print("Jumlah Anak: ");
                int jumlahAnak = Integer.parseInt(scanner.nextLine().trim());
                
                // Buat objek pegawai menggunakan factory
                // POLIMORFISME: variabel bertipe Pegawai dapat menampung
                // objek Supervisor, HRD, Teknisi, atau Karyawan
                Pegawai pegawai = PegawaiFactory.createPegawai(
                    kode, nama, jamMasuk, jamKeluar, menikah, jumlahAnak
                );
                
                // Tampilkan slip gaji
                // Method yang sama (tampilkanSlipGaji) menghasilkan
                // output berbeda berdasarkan jenis pegawai
                pegawai.tampilkanSlipGaji();
                
                // Tambahkan ke daftar
                daftarPegawai.add(pegawai);
                
            } catch (NumberFormatException e) {
                // PENTING: NumberFormatException harus di-catch SEBELUM
                // IllegalArgumentException karena NumberFormatException
                // adalah subclass dari IllegalArgumentException
                System.out.println("\n[ERROR] Input harus berupa angka!");
            } catch (IllegalArgumentException e) {
                System.out.println("\n[ERROR] " + e.getMessage());
            }
            
            System.out.print("\nTambah pegawai lain? (y/n): ");
            lanjut = scanner.nextLine().trim().equalsIgnoreCase("y");
        }
        
        // Tampilkan rekap semua pegawai jika ada data
        if (!daftarPegawai.isEmpty()) {
            tampilkanRekap(daftarPegawai);
        }
        
        scanner.close();
        System.out.println("\n============================================");
        System.out.println("  Terima kasih telah menggunakan sistem ini");
        System.out.println("============================================");
    }
    
    /**
     * Method untuk menampilkan rekap gaji semua pegawai
     * Mendemonstrasikan POLIMORFISME: 
     * Loop dengan variabel bertipe Pegawai, 
     * method hitungTotalGaji() dan getJabatan() 
     * memberikan hasil berbeda sesuai objek sebenarnya
     */
    private static void tampilkanRekap(ArrayList<Pegawai> daftarPegawai) {
        System.out.println("\n============================================");
        System.out.println("         REKAP GAJI SEMUA PEGAWAI          ");
        System.out.println("============================================");
        System.out.printf("%-5s %-20s %-12s %15s%n", 
                          "No", "Nama", "Jabatan", "Total Gaji");
        System.out.println("--------------------------------------------");
        
        double totalSemuaGaji = 0;
        int nomor = 1;
        
        for (Pegawai p : daftarPegawai) {
            // Polimorfisme: getJabatan() dan hitungTotalGaji()
            // menghasilkan nilai berbeda sesuai jenis pegawai
            System.out.printf("%-5d %-20s %-12s Rp %,15.0f%n", 
                              nomor++, 
                              p.getNama(), 
                              p.getJabatan(), 
                              p.hitungTotalGaji());
            totalSemuaGaji += p.hitungTotalGaji();
        }
        
        System.out.println("--------------------------------------------");
        System.out.printf("TOTAL PENGELUARAN GAJI: Rp %,15.0f%n", totalSemuaGaji);
        System.out.println("============================================");
    }
}
