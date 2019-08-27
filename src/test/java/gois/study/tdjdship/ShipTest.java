package gois.study.tdjdship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShipTest {

    private Ship ship;
    private Location location;
    private Planet planet;

    @Before
    public void beforeTest() {
        Point max = new Point(50, 50);
        location = new Location(new Point(21, 13), Direction.NORTH);
        planet = new Planet(max);
        // ship = new Ship(location);
        ship = new Ship(location, planet);
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

    @Test
    public void whenTurnLeftThenLeft() {
        Location expected = location.copy();
        expected.turnLeft();
        ship.turnLeft();
        assertEquals(ship.getLocation(), expected);
    }

    @Test
    public void whenTurnRightThenRight() {
        Location expected = location.copy();
        expected.turnRight();
        ship.turnRight();
        assertEquals(ship.getLocation(), expected);
    }

    @Test
    public void whenReceiveCommandsFThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.receiveCommands("f");
        assertEquals(ship.getLocation(), expected);
    }

    @Test
    public void whenReceiveCommandsBThenBackward() {
        Location expected = location.copy();
        expected.backward();
        ship.receiveCommands("b");
        assertEquals(ship.getLocation(), expected);
    }

    @Test
    public void whenReceiveCommandsLThenTurnLeft() {
        Location expected = location.copy();
        expected.turnLeft();
        ship.receiveCommands("l");
        assertEquals(ship.getLocation(), expected);
    }

    @Test
    public void whenReceiveCommandsRThenTurnRight() {
        Location expected = location.copy();
        expected.turnRight();
        ship.receiveCommands("r");
        assertEquals(ship.getLocation(), expected);
    }

    @Test
    public void whenReceiveCommandsThenAllAreExecuted() {
        Location expected = location.copy();
        expected.turnRight();
        expected.forward();
        expected.turnLeft();
        expected.backward();
        ship.receiveCommands("rflb");
        assertEquals(ship.getLocation(), expected);
    }

    @Test
    public void whenInstantiatedThenPlanetIsStored() {
        /*Point max = new Point(50, 50);
        Planet planet = new Planet(max);
        ship = new Ship(location, planet);*/
        assertEquals(ship.getPlanet(), planet);
    }

    @Test
    public void whenOverpassingEastBoundaryThenPositionIsReset() {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(planet.getMax().getX());
        ship.receiveCommands("f");
        assertEquals(location.getX(), 1);
    }

    @Test
    public void whenOverpassingWestBoundaryThenPositionIsReset() {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(1);
        ship.receiveCommands("b");
        assertEquals(location.getX(), planet.getMax().getX());
    }
}
