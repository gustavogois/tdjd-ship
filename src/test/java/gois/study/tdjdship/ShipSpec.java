package gois.study.tdjdship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShipSpec {
    @Test
    public void whenInstantiatedThenLocationIsSet() {
        Location location = new Location(new Point(21, 13), Direction.NORTH);
        Ship ship = new Ship(location);
        assertEquals(ship.getLocation(), location);
    }
}
