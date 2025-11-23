package amoba;

import java.util.*;

public class Jatek {
    private Tabla palya;
    private String jatekosNev;
    private Scanner sc = new Scanner(System.in);

    public void indit() {

        System.out.print("Add meg a nevedet: ");
        jatekosNev = sc.nextLine();

        System.out.println("Udvozollek, " + jatekosNev + "! Kezdodik a jatek.");

        palya = new Tabla(5);

        while (true) {
            palya.kirajzol();

            System.out.println(jatekosNev + "add meg sor es oszlop szamat (1-tol kezdve):");
            int sor = sc.nextInt() - 1;
            int oszlop = sc.nextInt() - 1;

            if (!palya.lepes(sor, oszlop, 'X')) {
                System.out.println("Ervenytelen lepes! Probald ujra.");
                continue;
            }
            if (palya.vanNyertes('X')) {
                palya.kirajzol();
                System.out.println("Gratulalok, " + jatekosNev + "! Nyertel!");
                break;
            }
            List<int[]> szabad = palya.getSzabadmezok();
            if (szabad.isEmpty()) {
                System.out.println("Nincs tobb szabad mezo! Dontetlen.");
                break;
            }

            Random r =  new Random();
            int[] gep = szabad.get(r.nextInt(szabad.size()));
            palya.lepes(gep[0], gep[1], 'O');

            if (palya.vanNyertes('O')) {
                palya.kirajzol();
                System.out.println("A gep nyert!");
                break;
            }
        }
    }
}
