package factory;

import model.*;

/**
 * Class PegawaiFactory
 * Menggunakan Factory Pattern untuk membuat objek Pegawai
 * berdasarkan kode jabatan
 */
public class PegawaiFactory {
    
    /**
     * Factory method untuk membuat objek Pegawai
     * @param kodePegawai Kode jabatan (SPV/HRD/TKN/KRY)
     * @param nama Nama pegawai
     * @param jamMasuk Jam masuk kerja (1-24)
     * @param jamKeluar Jam keluar kerja (1-24)
     * @param sudahMenikah Status pernikahan
     * @param jumlahAnak Jumlah anak
     * @return Objek Pegawai sesuai kode
     * @throws IllegalArgumentException jika kode tidak valid atau jam tidak dalam range
     */
    public static Pegawai createPegawai(String kodePegawai, String nama, 
                                         int jamMasuk, int jamKeluar, 
                                         boolean sudahMenikah, int jumlahAnak) {
        
        // Validasi jam (1-24)
        if (jamMasuk < 1 || jamMasuk > 24 || jamKeluar < 1 || jamKeluar > 24) {
            throw new IllegalArgumentException("Jam harus berupa angka 1-24");
        }
        
        // Validasi jumlah anak tidak negatif
        if (jumlahAnak < 0) {
            throw new IllegalArgumentException("Jumlah anak tidak boleh negatif");
        }
        
        // Buat pegawai berdasarkan kode - POLIMORFISME
        switch (kodePegawai.toUpperCase()) {
            case "SPV":
                return new Supervisor(kodePegawai, nama, jamMasuk, jamKeluar, 
                                      sudahMenikah, jumlahAnak);
            case "HRD":
                return new HRD(kodePegawai, nama, jamMasuk, jamKeluar, 
                               sudahMenikah, jumlahAnak);
            case "TKN":
                return new Teknisi(kodePegawai, nama, jamMasuk, jamKeluar, 
                                   sudahMenikah, jumlahAnak);
            case "KRY":
                return new Karyawan(kodePegawai, nama, jamMasuk, jamKeluar, 
                                    sudahMenikah, jumlahAnak);
            default:
                throw new IllegalArgumentException(
                    "Kode pegawai tidak valid: " + kodePegawai + 
                    ". Gunakan SPV/HRD/TKN/KRY");
        }
    }
}
