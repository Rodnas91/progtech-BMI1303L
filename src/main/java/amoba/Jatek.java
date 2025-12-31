package amoba;

import java.util.*;

public class Jatek {
    private Tabla palya;
    private String jatekosNev;
    private Scanner sc = new Scanner(System.in);

    public void indit() {
        System.out.print("Szeretned visszatolteni az elozo jatekot? (i/n): ");
        String valasz = sc.nextLine().trim().toLowerCase();

        JatekAllapot allapot = null;
        if (valasz.equals("i")) {
            allapot = JatekMentes.betoltAllapot();
        }

        if (allapot != null) {
            palya = new Tabla(allapot.meret);
            palya.setMezok(allapot.mezok);
            System.out.println("Elozo jatekallas betoltve.");
            palya.kirajzol();
        } else {
            palya = new Tabla(5);
        }

        System.out.print("Add meg a nevedet: ");
        jatekosNev = sc.nextLine();
        System.out.println("Udvozollek, " + jatekosNev + "! Kezdodik a jatek.");

        while (true) {
            palya.kirajzol();

            System.out.println(jatekosNev + " add meg sor es oszlop szamat (1-tol kezdve):");
            int sor = bekerSzam("Add meg a sort (1–" + palya.getMeret() + "): ", 1, palya.getMeret()) - 1;
            int oszlop = bekerSzam("Add meg az oszlopot (1–" + palya.getMeret() + "): ", 1, palya.getMeret()) - 1;

            if (!palya.lepes(sor, oszlop, 'X')) {
                System.out.println("Ervenytelen lepes! Probald ujra.");
                continue;
            }

            if (palya.vanNyertes('X')) {
                palya.kirajzol();
                System.out.println("Gratulalok, " + jatekosNev + "! Nyertel!");
                JatekAllapot ujAllapot = new JatekAllapot(jatekosNev, palya.getMeret(), palya.getMezok());
                JatekMentes.mentesAllapot(ujAllapot);
                break;
            }

            List<int[]> szabad = palya.getSzabadmezok();
            if (szabad.isEmpty()) {
                System.out.println("Nincs tobb szabad mezo! Dontetlen.");
                break;
            }

            Random r = new Random();
            int[] gep = szabad.get(r.nextInt(szabad.size()));
            palya.lepes(gep[0], gep[1], 'O');

            if (palya.vanNyertes('O')) {
                palya.kirajzol();
                System.out.println("A gep nyert!");
                break;
            }

            JatekAllapot ujAllapot = new JatekAllapot(jatekosNev, palya.getMeret(), palya.getMezok());
            JatekMentes.mentesAllapot(ujAllapot);
        }
    }

    private int bekerSzam(String uzenet, int min, int max) {
        while (true) {
            System.out.print(uzenet);

            if (!sc.hasNextInt()) {
                System.out.println("Hibat kaptal: szamot varok.");
                sc.next();
                continue;
            }

            int szam = sc.nextInt();
            if (szam < min || szam > max) {
                System.out.println("Ervenytelen: csak " + min + " es " + max + " kozott adhatsz meg szamot.");
                continue;
            }

            return szam;
        }
    }
}