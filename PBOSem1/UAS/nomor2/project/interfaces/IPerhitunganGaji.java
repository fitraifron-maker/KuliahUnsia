package interfaces;

/**
 * Interface IPerhitunganGaji
 * Mendefinisikan kontrak method untuk perhitungan gaji pegawai
 */
public interface IPerhitunganGaji {
    
    /**
     * Menghitung jam keterlambatan masuk kerja
     * @return jumlah jam terlambat
     */
    int hitungJamTerlambat();
    
    /**
     * Menghitung jam pulang lebih awal dari waktu normal
     * @return jumlah jam pulang lebih awal
     */
    int hitungJamPulangAwal();
    
    /**
     * Menghitung jam lembur kerja
     * @return jumlah jam lembur
     */
    int hitungJamLembur();
    
    /**
     * Menghitung potongan gaji akibat keterlambatan atau pulang awal
     * @return nominal potongan gaji
     */
    double hitungPotongan();
    
    /**
     * Menghitung tunjangan keluarga (istri dan anak)
     * @return nominal tunjangan keluarga
     */
    double hitungTunjanganKeluarga();
    
    /**
     * Menghitung gaji lembur
     * @return nominal gaji lembur
     */
    double hitungGajiLembur();
    
    /**
     * Menghitung total gaji keseluruhan
     * @return total gaji
     */
    double hitungTotalGaji();
}
