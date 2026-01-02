package amoba;

import java.util.Objects;
import java.util.Arrays;

public class JatekAllapot {
    public String jatekosNev;
    public int meret;
    public char[][] mezok;

    public JatekAllapot(String jatekosNev, int meret,  char[][] mezok) {
        this.jatekosNev = jatekosNev;
        this.meret = meret;
        this.mezok = mezok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JatekAllapot that = (JatekAllapot) o;

        if (meret != that.meret) return false;
        if (!Objects.equals(jatekosNev, that.jatekosNev)) return false;

        for (int i = 0; i < meret; i++) {
            if (!Arrays.equals(mezok[i], that.mezok[i])) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(jatekosNev, meret);
        for (char[] sor : mezok) {
            result = 31 * result + Arrays.hashCode(sor);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JatekAllapot{jatekosNev='").append(jatekosNev)
                .append("', meret=").append(meret)
                .append(", mezok=\n");
        for (char[] sor : mezok) {
            sb.append(Arrays.toString(sor)).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public JatekAllapot(String jatekosNev) {
    }
}
