package gois.study.tdjdship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    private Point point;
    private final int x = 12;
    private final int y = 21;

    @Before
    public void beforeTest() {
        point = new Point(x, y);
    }

    @Test
    public void whenInstantiatedThenXIsSet() {
        assertEquals(point.getX(), x);
    }

    @Test
    public void whenInstantiatedThenYIsSet() {
        assertEquals(point.getY(), y);
    }

}
