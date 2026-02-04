package model;

import interfaces.IPerhitunganGaji;

/**
 * Abstract Class Pegawai
 * Implementasi base class untuk semua jenis pegawai
 */
public abstract class Pegawai implements IPerhitunganGaji {
    
    // Atribut pegawai
    protected String kode;
    protected String nama;
    protected int jamMasuk;
    protected int jamKeluar;
    protected boolean sudahMenikah;
    protected int jumlahAnak;
    
    // Komponen gaji (diset oleh subclass)
    protected double gajiPokok;
    protected double transport;
    protected double lemburPerJam;
    protected double tunjanganIstri;
    protected double tunjangan1Anak;
    protected double tunjanganLebihDari1Anak;
    
    // Konstanta jam kerja
    protected static final int JAM_MASUK_NORMAL = 7;
    protected static final int JAM_KELUAR_NORMAL = 16;
    protected static final double POTONGAN_PER_JAM = 100000;
    
    /**
     * Constructor
     */
    public Pegawai(String kode, String nama, int jamMasuk, int jamKeluar, 
                   boolean sudahMenikah, int jumlahAnak) {
        this.kode = kode;
        this.nama = nama;
        this.jamMasuk = jamMasuk;
        this.jamKeluar = jamKeluar;
        this.sudahMenikah = sudahMenikah;
        this.jumlahAnak = jumlahAnak;
    }
    
    // ==================== GETTER ====================
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getJamMasuk() { return jamMasuk; }
    public int getJamKeluar() { return jamKeluar; }
    public boolean isSudahMenikah() { return sudahMenikah; }
    public int getJumlahAnak() { return jumlahAnak; }
    public double getGajiPokok() { return gajiPokok; }
    public double getTransport() { return transport; }
    
    // ==================== SETTER ====================
    public void setJamMasuk(int jamMasuk) { 
        if (jamMasuk >= 1 && jamMasuk <= 24) {
            this.jamMasuk = jamMasuk; 
        }
    }
    
    public void setJamKeluar(int jamKeluar) { 
        if (jamKeluar >= 1 && jamKeluar <= 24) {
            this.jamKeluar = jamKeluar; 
        }
    }
    
    // ==================== IMPLEMENTASI INTERFACE ====================
    
    /**
     * Hitung jam keterlambatan
     * Jika masuk lebih dari jam 7, dihitung terlambat
     */
    @Override
    public int hitungJamTerlambat() {
        if (jamMasuk > JAM_MASUK_NORMAL) {
            return jamMasuk - JAM_MASUK_NORMAL;
        }
        return 0;
    }
    
    /**
     * Hitung jam pulang lebih awal
     * Jika pulang sebelum jam 16, dihitung kekurangan
     */
    @Override
    public int hitungJamPulangAwal() {
        if (jamKeluar < JAM_KELUAR_NORMAL) {
            return JAM_KELUAR_NORMAL - jamKeluar;
        }
        return 0;
    }
    
    /**
     * Hitung jam lembur
     * Jika pulang lebih dari jam 16, dihitung lembur
     */
    @Override
    public int hitungJamLembur() {
        if (jamKeluar > JAM_KELUAR_NORMAL) {
            return jamKeluar - JAM_KELUAR_NORMAL;
        }
        return 0;
    }
    
    /**
     * Hitung potongan gaji
     * Potongan = (jam terlambat + jam pulang awal) * 100.000
     */
    @Override
    public double hitungPotongan() {
        int totalJamPotongan = hitungJamTerlambat() + hitungJamPulangAwal();
        return totalJamPotongan * POTONGAN_PER_JAM;
    }
    
    /**
     * Hitung tunjangan keluarga
     * Tunjangan istri (jika menikah) + Tunjangan anak
     */
    @Override
    public double hitungTunjanganKeluarga() {
        double tunjangan = 0;
        
        // Tunjangan istri (jika sudah menikah)
        if (sudahMenikah) {
            tunjangan += tunjanganIstri;
        }
        
        // Tunjangan anak
        if (jumlahAnak == 1) {
            tunjangan += tunjangan1Anak;
        } else if (jumlahAnak > 1) {
            tunjangan += tunjanganLebihDari1Anak;
        }
        
        return tunjangan;
    }
    
    /**
     * Hitung gaji lembur
     * Gaji lembur = jam lembur * tarif lembur per jam
     */
    @Override
    public double hitungGajiLembur() {
        return hitungJamLembur() * lemburPerJam;
    }
    
    /**
     * Hitung total gaji - POLIMORFISME
     * Setiap jenis pegawai memiliki komponen gaji berbeda
     */
    @Override
    public double hitungTotalGaji() {
        // Gaji pokok dikurangi potongan
        double gajiBersih = gajiPokok - hitungPotongan();
        if (gajiBersih < 0) gajiBersih = 0; // Gaji tidak boleh minus
        
        // Total = Gaji Bersih + Transport + Lembur + Tunjangan Keluarga
        return gajiBersih + transport + hitungGajiLembur() + hitungTunjanganKeluarga();
    }
    
    /**
     * Method abstrak untuk mendapatkan nama jabatan
     * Harus diimplementasikan oleh subclass
     */
    public abstract String getJabatan();
    
    /**
     * Tampilkan slip gaji lengkap
     */
    public void tampilkanSlipGaji() {
        System.out.println("\n======================================");
        System.out.println("           SLIP GAJI PEGAWAI          ");
        System.out.println("======================================");
        System.out.println("Kode        : " + kode);
        System.out.println("Nama        : " + nama);
        System.out.println("Jabatan     : " + getJabatan());
        System.out.println("--------------------------------------");
        System.out.println("Jam Masuk   : " + jamMasuk + ":00");
        System.out.println("Jam Keluar  : " + jamKeluar + ":00");
        System.out.println("Status      : " + (sudahMenikah ? "Menikah" : "Belum Menikah"));
        System.out.println("Jumlah Anak : " + jumlahAnak);
        System.out.println("--------------------------------------");
        System.out.println("PENGHASILAN:");
        System.out.printf("Gaji Pokok      : Rp %,.0f%n", gajiPokok);
        System.out.printf("Transport       : Rp %,.0f%n", transport);
        System.out.printf("Lembur (%d jam)  : Rp %,.0f%n", hitungJamLembur(), hitungGajiLembur());
        System.out.printf("Tunj. Keluarga  : Rp %,.0f%n", hitungTunjanganKeluarga());
        System.out.println("--------------------------------------");
        System.out.println("POTONGAN:");
        System.out.printf("Terlambat (%d jam): Rp %,.0f%n", hitungJamTerlambat(), 
                          hitungJamTerlambat() * POTONGAN_PER_JAM);
        System.out.printf("Pulang Awal (%d jam): Rp %,.0f%n", hitungJamPulangAwal(), 
                          hitungJamPulangAwal() * POTONGAN_PER_JAM);
        System.out.println("--------------------------------------");
        System.out.printf("TOTAL GAJI      : Rp %,.0f%n", hitungTotalGaji());
        System.out.println("======================================\n");
    }
}
