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

    /* The first reaction can be to write specifications similar to the following two:
    public void givenNorthWhenMoveForwardThenYDecreases() {
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getY(), 12);
    }

    public void givenEastWhenMoveForwardThenXIncreases() {
        ship.getLocation().setDirection(Direction.EAST);
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getX(), 22);
    }
    We should create at least two more specifications related to cases where a ship is facing south and west.

However, this is not how unit tests should be written. Most people new to unit testing fall into the trap of specifying the end result that requires the knowledge of the inner workings of methods, classes, and libraries used by the method that is being specified. This approach is problematic on many levels.

When including external code in the unit that is being specified, we should take into account, at least in our case, the fact that the external code is already tested. We know that it is working since we're running all the tests every time any change to the code is made.

- Rerun all the tests every time the implementation code changes.

- This ensures that there is no unexpected side-effect caused by code changes.

- Every time any part of the implementation code changes, all tests should be run. Ideally, tests are fast to execute and can be run by a developer locally. Once code is submitted to the version control, all tests should be run again to ensure that there was no problem due to code merges. This is especially important when more than one developer is working on the code. CI tools, such as Jenkins, Hudson, Travind, Bamboo, and Go-CD should be used to pull the code from the repository, compile it, and run tests.

Another problem with this approach is that if an external code changes, there will be many more specifications to change. Ideally, we should be forced to change only specifications directly related to the unit that will be modified. Searching for all other places where that unit is called from might be very time-consuming and error-prone.

A much easier, faster, and better way to write specifications for this requirement would be the following:
    */
    public void whenMoveForwardThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.moveForward();
        assertEquals(ship.getLocation(), expected);
    }
}
