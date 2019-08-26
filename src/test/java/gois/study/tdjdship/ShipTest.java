package gois.study.tdjdship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShipTest {

    private Ship ship;
    private Location location;

    @Before
    public void beforeTest() {
        location = new Location(new Point(21, 13), Direction.NORTH);
        ship = new Ship(location);
    }

    @Test
    public void whenInstantiatedThenLocationIsSet() {
        assertEquals(ship.getLocation(), location);
    }

    @Test
    public void whenMoveForwardThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.moveForward();
        assertEquals(ship.getLocation(), expected);
    }

    @Test
    public void whenMoveBackwardThenBackward() {
        Location expected = location.copy();
        expected.backward();
        ship.moveBackward();
        assertEquals(ship.getLocation(), expected);
    }
}
