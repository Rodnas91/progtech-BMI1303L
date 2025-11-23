package amoba;

import java.util.List;
import java.util.ArrayList;

public class Tabla {
    private final int meret;
    private final char[][] mezok;

    public Tabla(int meret) {
        this.meret = meret;
        this.mezok = new char[meret][meret];

        for (int i = 0; i < meret; i++) {
            for (int j = 0; j < meret; j++) {
                mezok[i][j] = ' ';
            }
        }
    }

    public void kirajzol() {
        System.out.print("   ");
        for (int oszlop = 1; oszlop <= meret; oszlop++) {
            System.out.printf(" %d  ", oszlop);
        }
        System.out.println();

        for (int sor = 0; sor < meret; sor++) {
            System.out.print("   ");
            for (int j = 0; j < meret; j++) {
                System.out.print("+---");
            }
            System.out.println("+");

            System.out.printf("%2d ", sor + 1); // Sor száma
            for (int oszlop = 0; oszlop < meret; oszlop++) {
                System.out.print("| " + mezok[sor][oszlop] + " ");
            }
            System.out.println("|");
        }

        System.out.print("   ");
        for (int j = 0; j < meret; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
}
