// Mahasiswa.java
// NIM  : 250401020040
// Nama : Fitra Ansyari Ifron
// Kelas : IF504 (PBO)
// Case: 
//Saya ingin membuat program untuk menyimpan nama dan umur satu orang mahasiswa, lalu menampilkan perkenalannya.
//Selain itu, saya ingin umur tidak bisa diisi sembarangan, misalnya tidak boleh 0 atau negatif.

public class Mahasiswa {
private String nama;
private int umur;

//constructor
public Mahasiswa(String nama, int umur){
    this.nama = nama;
    this. umur = umur;
    }

public void sayHello() {
    System.out.println("Hallo, saya " + nama + ", umur " + umur);
}

public void setUmur(int umurBaru){
    if (umurBaru <= 0) {
        System.out.println("Umur tidak boleh kurang atau sama dengan 0");
    }else{
        umur = umurBaru;
    }
}

}
