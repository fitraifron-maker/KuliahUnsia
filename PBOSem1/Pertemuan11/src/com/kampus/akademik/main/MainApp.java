package com.kampus.akademik.main;

import com.kampus.akademik.model.Mahasiswa;
import com.kampus.akademik.model.Dosen;
import com.kampus.akademik.service.AkademikService;

public class MainApp {
    public static void main(String[] args) {
        // 1) Buat objek Mahasiswa dan Dosen
        Mahasiswa m1 = new Mahasiswa("231234567", "Fitra Ifron", "Teknik Informatika");
        Dosen d1 = new Dosen("1987654321", "Pak Budi", "Pemrograman Berorientasi Objek");

        // 2) Gunakan AkademikService
        AkademikService service = new AkademikService();

        // 3) Tampilkan data ke layar
        service.tampilMahasiswa(m1);
        service.tampilDosen(d1);
    }
}
