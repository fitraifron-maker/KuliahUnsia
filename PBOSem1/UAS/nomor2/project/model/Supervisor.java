package model;

/**
 * Class Supervisor
 * Extends Pegawai - Kode: SPV
 */
public class Supervisor extends Pegawai {
    
    public Supervisor(String kode, String nama, int jamMasuk, int jamKeluar, 
                      boolean sudahMenikah, int jumlahAnak) {
        super(kode, nama, jamMasuk, jamKeluar, sudahMenikah, jumlahAnak);
        
        // Set komponen gaji Supervisor sesuai ketentuan
        this.gajiPokok = 10000000;           // Gaji Pokok = 10.000.000
        this.transport = 1000000;             // Transport = 1.000.000
        this.lemburPerJam = 10000;            // Lembur/jam = 10.000
        this.tunjanganIstri = 300000;         // Tunjangan Istri = 300.000
        this.tunjangan1Anak = 100000;         // Tunjangan 1 Anak = 100.000
        this.tunjanganLebihDari1Anak = 200000; // Tunjangan >1 Anak = 200.000
    }
    
    @Override
    public String getJabatan() {
        return "Supervisor";
    }
}
