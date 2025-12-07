abstract class Hewan {
    abstract void bersuara(); 

    void info() {             
        System.out.println("Ini adalah hewan.");
    }
}

// Kucing mewarisi Hewan (inheritance)
class Kucing extends Hewan {
    @Override
    void bersuara() {
        System.out.println("Meong");
    }
}

public class Abstrak {
    public static void main(String[] args) {


        Hewan h = new Kucing(); 
        h.info();              
        h.bersuara();           
    }
}
