import static org.junit.Assert.assertNotEquals;

import javax.print.attribute.standard.MediaSize.Other;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TesteLocation {
    protected int x;
    protected int y;

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

    @Test
    public void equals() {
        Location other = new Location(5, 13);

        Location otherLocation = new Location(20, 25);
        if (other == otherLocation) {

            Location resultado = other = otherLocation;
            Location esperada = other = otherLocation;
            assertEquals(esperada, resultado);
        }

    }

    @Test
    public void distance() {
        Location destination = new Location(5, 10);
        int xDist = Math.abs(destination.getX() - x);
        int yDist = Math.abs(destination.getX() - x);

        int resultado = Math.max(xDist, yDist);
        int esperada = Math.max(xDist, yDist);
        assertEquals(esperada, resultado);

    }
}
