package model;

/**
 * Class Teknisi
 * Extends Pegawai - Kode: TKN
 */
public class Teknisi extends Pegawai {
    
    public Teknisi(String kode, String nama, int jamMasuk, int jamKeluar, 
                   boolean sudahMenikah, int jumlahAnak) {
        super(kode, nama, jamMasuk, jamKeluar, sudahMenikah, jumlahAnak);
        
        // Set komponen gaji Teknisi sesuai ketentuan
        this.gajiPokok = 3000000;             // Gaji Pokok = 3.000.000
        this.transport = 500000;              // Transport = 500.000
        this.lemburPerJam = 5000;             // Lembur/jam = 5.000
        this.tunjanganIstri = 200000;         // Tunjangan Istri = 200.000
        this.tunjangan1Anak = 75000;          // Tunjangan 1 Anak = 75.000
        this.tunjanganLebihDari1Anak = 150000; // Tunjangan >1 Anak = 150.000
    }
    
    @Override
    public String getJabatan() {
        return "Teknisi";
    }
}
