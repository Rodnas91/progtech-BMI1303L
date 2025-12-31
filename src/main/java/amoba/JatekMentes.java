package amoba;

import java.io.*;
import java.util.*;

public class JatekMentes {
    private static final String FAJL = "mentes.json";

    public static void mentesAllapot(JatekAllapot allapot) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FAJL))) {
            writer.println("{");
            writer.println("  \"jatekosNev\": \"" + allapot.jatekosNev + "\",");
            writer.println("  \"meret\": " + allapot.meret + ",");
            writer.println("  \"mezok\": [");

            for (int i = 0; i < allapot.mezok.length; i++) {
                writer.print("    [");
                for (int j = 0; j < allapot.mezok[i].length; j++) {
                    writer.print("\"" + allapot.mezok[i][j] + "\"");
                    if (j < allapot.mezok[i].length - 1) writer.print(", ");
                }
                writer.print("]");
                if (i < allapot.mezok.length - 1) writer.println(",");
                else writer.println();
            }

            writer.println("  ]");
            writer.println("}");
        } catch (IOException e) {
            System.out.println("Nem sikerult elmenteni a jatekallast!");
        }
    }

    public static JatekAllapot betoltAllapot() {
        File jsonFajl = new File(FAJL);
        if (!jsonFajl.exists()) return null;

        try (Scanner sc = new Scanner(jsonFajl)) {
            String jatekosNev = "";
            int meret = 0;
            List<char[]> mezokList = new ArrayList<>();

            while (sc.hasNextLine()) {
                String sor = sc.nextLine().trim();

                if (sor.contains("\"jatekosNev\"")) {
                    jatekosNev = sor.split(":")[1].trim().replace("\"", "").replace(",", "");
                } else if (sor.contains("\"meret\"")) {
                    meret = Integer.parseInt(sor.replaceAll("[^0-9]", ""));
                } else if (sor.startsWith("[") && sor.contains("\"")) {

                    sor = sor.replace("[", "").replace("]", "").replace("\"", "");
                    String[] jelek = sor.split(",");
                    char[] sorTomb = new char[jelek.length];
                    for (int i = 0; i < jelek.length; i++) {
                        sorTomb[i] = jelek[i].trim().isEmpty() ? ' ' : jelek[i].trim().charAt(0);
                    }
                    mezokList.add(sorTomb);
                }
            }

            if (mezokList.size() != meret) {
                System.out.println("A mezok szama nem egyezik a megadott merettel!");
                return null;
            }

            char[][] mezok = new char[meret][meret];
            for (int i = 0; i < meret; i++) {
                mezok[i] = mezokList.get(i);
            }

            return new JatekAllapot(jatekosNev, meret, mezok);

        } catch (Exception e) {
            System.out.println("Nem sikerult betolteni a jatekallast!");
            e.printStackTrace();
            return null;
        }
    }
}