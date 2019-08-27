package gois.study.tdjdship;

public class Ship {
    private final Location location;

    public Ship(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public boolean moveForward() {
        return location.forward();
    }

    public boolean moveBackward() {
        return location.backward();
    }

    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    /*
    We already spoke about the importance of writing the simplest possible code that passes the specification.

    Write the simplest code to pass the test. This ensures a cleaner and clearer design and avoids unnecessary features

    The idea is that the simpler the implementation, the better and easier it is to maintain the product. The idea adheres to the KISS principle. It states that most systems work best if they are kept simple rather than made complex; therefore, simplicity should be a key goal in design and unnecessary complexity should be avoided.
    This is a good opportunity to apply this rule. You might be inclined to write a piece of code similar to the following:

    public void receiveCommands(String commands) {
      if (commands.charAt(0) == 'f') {
        moveForward();
      }
    }
    In this example code, we are verifying whether the first character is f and, if it is, invoking the moveForward method. There are many other variations that we can do. However, if we stick to the simplicity principle, a better solution would be the following
    This is the simplest and shortest possible code that will make the specification pass. Later on, we might end up with something closer to the first version of the code; we might use some kind of a loop or come up with some other solution when things become more complicated. As for now, we are concentrating on one specification at a time and trying to make things simple. We are attempting to clear our mind by focusing only on the task at hand.
    */

    public void receiveCommands(String command) {
        switch(command) {
            case "f":
                moveForward();
                break;
            case "b":
                moveBackward();
                break;
            case "l":
                turnLeft();
                break;
            case "r":
                turnRight();
                break;
        }
    }
}
