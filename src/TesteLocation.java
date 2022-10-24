import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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
    public void nextLocationError() {
        Location location = new Location(25, 40);
        Location destino = new Location(15, 22);
        Location locationEsperada = new Location(12, 40);

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
    public void getLocationError() {
        Location location = new Location(5, 10);

        Location esperada = new Location(22, 30);

        Location resultado = location.getLocation();

        assertEquals(esperada, resultado);

    }

    @Test
    public void getY() {
        Location y = new Location(0, 5);
        int esperada = y.getX();
        int resultado = y.getX();
        assertEquals(esperada, resultado);
    }

    @Test
    public void getYError() {
        Location y = new Location(0, 5);
        int esperada = y.getX();
        int resultado = y.getX();
        assertNotEquals(esperada, resultado);
    }

    @Test
    public void getX() {
        Location x = new Location(4, 0);
        int esperada = x.getX();
        int resultado = x.getX();

        assertEquals(esperada, resultado);
    }

    @Test
    public void getXError() {
        Location x = new Location(4, 0);
        int esperada = x.getX();
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
    public void ToStringError() {
        String resultado = "location";
        String esperada = "location";

        assertNotEquals(esperada, resultado);

    }

    @Test
    public void equals() {
        Object other = new Object();

        if (other instanceof Location) {
            Location otherLocation = (Location) other;
            int resultado = otherLocation.getX() & otherLocation.getY();
            int esperada = otherLocation.getX() & otherLocation.getY();
            assertNotEquals(esperada, resultado);

        }

    }

    @Test
    public void equalsError() {
        Location other = new Location(5, 10);

        if (other instanceof Location) {
            Location otherLocation = (Location) other;
            int resultado = otherLocation.getX() & otherLocation.getY();
            int esperada = otherLocation.getX() & otherLocation.getY();
            assertNotEquals(esperada, resultado);

        }

    }

    @Test
    public void distance() {
        Location destination = new Location(5, 10);
        int xDist = Math.abs(destination.getX() - x);
        int yDist = Math.abs(destination.getY() - y);

        int resultado = Math.max(xDist, yDist);
        int esperada = Math.max(xDist, yDist);
        assertEquals(esperada, resultado);

    }

    @Test
    public void distanceError() {
        Location destination = new Location(5, 10);
        int xDist = Math.abs(destination.getX() - x);
        int yDist = Math.abs(destination.getY() - y);

        int resultado = Math.max(xDist, yDist);
        int esperada = Math.max(xDist, yDist);
        assertNotEquals(esperada, resultado);

    }
}
