package com.kampus.akademik.service;

import com.kampus.akademik.model.Mahasiswa;
import com.kampus.akademik.model.Dosen;

public class AkademikService {

    public void tampilMahasiswa(Mahasiswa m) {
        m.tampilkanData();
        System.out.println(); // spasi
    }

    public void tampilDosen(Dosen d) {
        d.tampilkanData();
        System.out.println(); // spasi
    }
}
