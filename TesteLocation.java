import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TesteLocation {
    @Test
    public void nextLocation() {
        Location location = new Location(122020, 1000);
        Location destino = new Location(122020, 1000);
        Location locationEsperada = new Location(122020, 1000);

        Location resultado = location.nextLocation(destino);

        assertEquals(locationEsperada, resultado);
    }

    @Test
    public void getLocation() {
        Location location = new Location(5, 10);

        Location esperada = new Location(5, 10);

        Location resultado = location.getLocation();

        assertEquals(esperada, resultado);

    }

    @Test
    public void getY() {
        Location y = new Location(0, 5);
        Location esperada = new Location(0, 5);

        int resultado = y.getY();

        assertNotEquals(esperada, resultado);
    }

    @Test
    public void getX() {
        Location x = new Location(4, 0);
        Location esperada = new Location(4, 0);

        int resultado = x.getX();

        assertNotEquals(esperada, resultado);
    }

    @Test
    public void ToString() {
        String resultado = "location";
        String esperada = "location";

        assertEquals(esperada, resultado);

    }

}
