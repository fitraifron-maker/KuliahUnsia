package model;

/**
 * Class Karyawan
 * Extends Pegawai - Kode: KRY
 */
public class Karyawan extends Pegawai {
    
    public Karyawan(String kode, String nama, int jamMasuk, int jamKeluar, 
                    boolean sudahMenikah, int jumlahAnak) {
        super(kode, nama, jamMasuk, jamKeluar, sudahMenikah, jumlahAnak);
        
        // Set komponen gaji Karyawan sesuai ketentuan
        this.gajiPokok = 1500000;             // Gaji Pokok = 1.500.000
        this.transport = 250000;              // Transport = 250.000
        this.lemburPerJam = 5000;             // Lembur/jam = 5.000
        this.tunjanganIstri = 200000;         // Tunjangan Istri = 200.000
        this.tunjangan1Anak = 60000;          // Tunjangan 1 Anak = 60.000
        this.tunjanganLebihDari1Anak = 130000; // Tunjangan >1 Anak = 130.000
    }
    
    @Override
    public String getJabatan() {
        return "Karyawan";
    }
}
