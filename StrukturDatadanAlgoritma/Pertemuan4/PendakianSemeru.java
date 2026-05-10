import java.util.Scanner;

public class PendakianSemeru {

    static final int ROWS = 6;
    static final int COLS = 12;

    // 0 = jalur hijau, 1 = jurang/blokir
    static int[][] grid = {
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0},
        {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
        {0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0},
        {0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
    };

    // Pos istirahat
    static int[][] posIstirahat = {
        {0, 0},   // Puncak Mahameru
        {5, 11},  // P1
        {1, 7},   // P3
        {2, 5},   // P4
        {5, 0},   // P5
        {3, 0},   // TC
        {5, 3},   // RK
        {4, 6},   // P2
    };

    static String[] namaPos = {
        "Puncak Mahameru",
        "P1 - Pos Ranu Pane",
        "P3 - Pos 3",
        "P4 - Pos 4",
        "P5 - Pos Kalimati",
        "TC - Tanjakan Cinta",
        "RK - Pos Ranu Kumbolo",
        "P2 - Pos Watu Rejeng"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan tenaga awal : ");
        int tenaga = sc.nextInt();

        System.out.print("Masukkan jalur       : ");
        String jalur = sc.next();

        String hasil = simulasi(tenaga, jalur);

        System.out.println("\nHASIL: " + hasil);

        sc.close();
    }

    static boolean bolehIstirahat(int row, int col) {
        for (int[] pos : posIstirahat) {
            if (pos[0] == row && pos[1] == col) {
                return true;
            }
        }
        return false;
    }

    static String namaLokasi(int row, int col) {
        for (int i = 0; i < posIstirahat.length; i++) {
            if (posIstirahat[i][0] == row && posIstirahat[i][1] == col) {
                return namaPos[i];
            }
        }
        return "(" + row + "," + col + ")";
    }

    static String simulasi(int tenaga, String jalur) {

        // Start dari P1
        int row = 5;
        int col = 11;

        System.out.println("\n========================================");
        System.out.println("SIMULASI PENDAKIAN GUNUNG SEMERU");
        System.out.println("========================================");
        System.out.println("Posisi awal : " + namaLokasi(row, col));
        System.out.println("Tenaga awal : " + tenaga);
        System.out.println("Jalur       : " + jalur);
        System.out.println("----------------------------------------");

        for (int i = 0; i < jalur.length(); i++) {
            char step = jalur.charAt(i);

            // ISTIRAHAT (pakai huruf kecil r)
            if (step == 'r') {
                if (!bolehIstirahat(row, col)) {
                    return "Mohon maaf, istirahat hanya diperbolehkan di Pos-pos yang tersedia";
                }

                tenaga += 10;

                System.out.println(
                        "Langkah " + (i + 1)
                                + " : Istirahat di " + namaLokasi(row, col)
                                + " | Tenaga = " + tenaga
                );

                continue;
            }

            int rBaru = row;
            int cBaru = col;

            // Pergerakan
            switch (step) {
                case 'L':
                    cBaru--;
                    break;
                case 'R':
                    cBaru++;
                    break;
                case 'U':
                    rBaru--;
                    break;
                case 'D':
                    rBaru++;
                    break;
                default:
                    return "Input jalur tidak valid";
            }

            // Keluar peta = blank
            if (rBaru < 0 || rBaru >= ROWS || cBaru < 0 || cBaru >= COLS) {
                int nomorSel = (rBaru * COLS) + cBaru;
                return "Jalur anda salah, anda masuk ke jurang/blank " + nomorSel;
            }

            // Masuk jurang
            if (grid[rBaru][cBaru] == 1) {
                int nomorSel = (rBaru * COLS) + cBaru;
                return "Jalur anda salah, anda masuk ke jurang/blank " + nomorSel;
            }

            // Gerak valid
            row = rBaru;
            col = cBaru;

            // tenaga berkurang
            tenaga--;

            System.out.println(
                    "Langkah " + (i + 1)
                            + " : " + step
                            + " -> " + namaLokasi(row, col)
                            + " | Tenaga = " + tenaga
            );

            // Sampai puncak
            if (row == 0 && col == 0) {
                if (tenaga >= 0) {
                    return "Selamat! Pendakian anda berhasil mencapai Puncak Mahameru, sisa tenaga anda " + tenaga;
                } else {
                    return "Jalur anda benar, tapi tenaga anda tidak akan kuat, coba jalur lain atau sempatkan istirahat terlebih dahulu";
                }
            }
        }

        // Jalur selesai tapi belum sampai puncak
        if (tenaga < 0) {
            return "Jalur anda benar, tapi tenaga anda tidak akan kuat, coba jalur lain atau sempatkan istirahat terlebih dahulu";
        }

        return "Pendakian belum selesai. Posisi saat ini: "
                + namaLokasi(row, col)
                + ", sisa tenaga: "
                + tenaga;
    }
}