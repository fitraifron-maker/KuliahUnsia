abstract class Hewan {
    protected String nama;
    
    public Hewan(String nama) {
        this.nama = nama;
    }
    
    // Method abstrak yang akan di-override oleh subclass
    public abstract void bersuara();
    public abstract void bergerak();
    
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
    }
}
 
// File: Kucing.java
class Kucing extends Hewan {
    public Kucing(String nama) {
        super(nama);
    }
    
    @Override
    public void bersuara() {
        System.out.println(nama + " bersuara: Meong!");
    }
    
    @Override
    public void bergerak() {
        System.out.println(nama + " berjalan dengan 4 kaki");
    }
}
 
// File: Anjing.java
class Anjing extends Hewan {
    public Anjing(String nama) {
        super(nama);
    }
    
    @Override
    public void bersuara() {
        System.out.println(nama + " bersuara: Guk guk!");
    }
    
    @Override
    public void bergerak() {
        System.out.println(nama + " berlari dengan 4 kaki");
    }
}
 
// File: Burung.java
class Burung extends Hewan {
    public Burung(String nama) {
        super(nama);
    }
    
    @Override
    public void bersuara() {
        System.out.println(nama + " bersuara: Cuit cuit!");
    }
    
    @Override
    public void bergerak() {
        System.out.println(nama + " terbang dengan sayap");
    }
}
 
// File: MainPolimorfisme.java
public class MainPolimorfisme {
    public static void main(String[] args) {
        // Polimorfisme: variabel bertipe parent class 
        // dapat menampung objek dari child class
        Hewan[] hewanArray = new Hewan[3];
        
        // Membuat objek berbeda dengan tipe parent yang sama
        hewanArray[0] = new Kucing("Kitty");
        hewanArray[1] = new Anjing("Buddy");
        hewanArray[2] = new Burung("Tweety");
        
        System.out.println("=== DEMONSTRASI POLIMORFISME ===\n");
        
        // Method yang sama dipanggil, perilaku berbeda
        for (Hewan hewan : hewanArray) {
            hewan.tampilkanInfo();
            hewan.bersuara();  // Polimorfisme terjadi di sini
            hewan.bergerak();  // Polimorfisme terjadi di sini
            System.out.println();
        }
    }
}
