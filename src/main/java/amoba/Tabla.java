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

            System.out.printf("%2d ", sor + 1);
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

    public boolean lepes(int sor, int oszlop, char jel) {
        if (sor < 0 || sor >= meret || oszlop < 0 || oszlop >= meret) {
            return false;
        }
        if (mezok[sor][oszlop] != ' ') {
            return false;
        }
        mezok[sor][oszlop] = jel;
        return true;
    }

    public List<int[]> getSzabadmezok() {
        List <int[]> szabadMezok = new ArrayList<>();

        for (int sor = 0; sor < meret; sor++) {
            for (int oszlop = 0; oszlop < meret; oszlop++) {
                if (mezok[sor][oszlop] == ' ') {
                    szabadMezok.add(new int[]{sor, oszlop});
                }
            }
        }
        return szabadMezok;
    }

    public boolean vanNyertes(char jel) {
        for (int sor = 0; sor < meret; sor++) {
            int db = 0;

            for (int oszlop = 0; oszlop < meret; oszlop++) {
                if (mezok[sor][oszlop] == jel) {
                    db++;
                    if (db == 5)
                        return true;
                }   else {
                    db = 0;
                }
            }
        }

        for (int oszlop = 0; oszlop < meret; oszlop++) {
            int db = 0;
            for (int sor = 0; sor < meret; sor++) {
                if (mezok[sor][oszlop] == jel) {
                    db++;
                    if (db == 5)
                        return true;
                }   else {
                    db = 0;
                }
            }
        }

        for (int sor = 0; sor <= meret - 5; sor++) {
            for (int oszlop = 0; oszlop <= meret - 5; oszlop++) {
                int db = 0;
                for (int k = 0; k < 5; k++) {
                    if (mezok[sor + k][oszlop + k] == jel) {
                        db++;
                        if (db == 5)
                            return true;
                    }   else break;
                }
            }
        }

        for (int sor = 0; sor <= meret - 5; sor++) {
            for (int oszlop = 4; oszlop < meret; oszlop++) {
                int db = 0;
                for (int k = 0; k < 5; k++) {
                    if (mezok[sor + k][oszlop - k] == jel) {
                        db++;
                        if (db == 5)
                            return true;
                    }   else break;
                }
            }
        }
        return false;
    }

    public int getMeret() {
        return meret;
    }


}
