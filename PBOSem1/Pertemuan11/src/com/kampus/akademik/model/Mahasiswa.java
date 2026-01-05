package com.kampus.akademik.model;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String jurusan;

    // Constructor
    public Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    // Method tampilkanData()
    public void tampilkanData() {
        System.out.println("=== Data Mahasiswa ===");
        System.out.println("NIM     : " + nim);
        System.out.println("Nama    : " + nama);
        System.out.println("Jurusan : " + jurusan);
    }
}
