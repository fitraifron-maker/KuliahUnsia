package model;

/**
 * Class HRD
 * Extends Pegawai - Kode: HRD
 */
public class HRD extends Pegawai {
    
    public HRD(String kode, String nama, int jamMasuk, int jamKeluar, 
               boolean sudahMenikah, int jumlahAnak) {
        super(kode, nama, jamMasuk, jamKeluar, sudahMenikah, jumlahAnak);
        
        // Set komponen gaji HRD sesuai ketentuan
        // Note: Transport di soal tertulis 750.000.000, diasumsikan typo, seharusnya 750.000
        this.gajiPokok = 5000000;             // Gaji Pokok = 5.000.000
        this.transport = 750000;              // Transport = 750.000 (diperbaiki dari 750.000.000)
        this.lemburPerJam = 7500;             // Lembur/jam = 7.500
        this.tunjanganIstri = 250000;         // Tunjangan Istri = 250.000
        this.tunjangan1Anak = 90000;          // Tunjangan 1 Anak = 90.000
        this.tunjanganLebihDari1Anak = 190000; // Tunjangan >1 Anak = 190.000
    }
    
    @Override
    public String getJabatan() {
        return "HRD";
    }
}
