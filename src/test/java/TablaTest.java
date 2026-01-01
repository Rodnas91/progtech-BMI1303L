package amoba;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TablaTest {

    @Test
    public void testUresMezoErvenyes() {
        Tabla tabla = new Tabla(5);
        assertTrue(tabla.lepes(0, 0, 'X'));
    }

    @Test
    public void testFoglaltMezoErvenytelen() {
        Tabla tabla = new Tabla(5);
        tabla.lepes(0, 0, 'X');
        assertFalse(tabla.lepes(0, 0, 'O'));
    }

    @Test
    public void testVanNyertesSorban() {
        Tabla tabla = new Tabla(5);
        for (int i = 0; i < 5; i++) {
            tabla.lepes(0, i, 'X');
        }
        assertTrue(tabla.vanNyertes('X'));
    }
}