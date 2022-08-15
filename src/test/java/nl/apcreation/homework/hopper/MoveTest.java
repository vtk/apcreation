package nl.apcreation.homework.hopper;

import nl.apcreation.homework.hopper.Move;
import nl.apcreation.homework.hopper.Point;
import nl.apcreation.homework.hopper.Velocity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveTest {
    private final Move parent = new Move(new Point(0, 0), new Velocity(0, 0));

    @Test
    public void shouldCalculateTopDirection() {
        assertEquals(new Move(new Point(0, 1), new Velocity(0, 1)), parent.top());
    }

    @Test
    public void shouldCalculateRightTopDirection() {
        assertEquals(new Move(new Point(1, 1), new Velocity(1, 1)), parent.rightTop());
    }

    @Test
    public void shouldCalculateRightDirection() {
        assertEquals(new Move(new Point(1, 0), new Velocity(1, 0)), parent.right());
    }

    @Test
    public void shouldCalculateRightBottomDirection() {
        assertEquals(new Move(new Point(1, -1), new Velocity(1, -1)), parent.rightBottom());
    }

    @Test
    public void shouldCalculateBottomDirection() {
        assertEquals(new Move(new Point(0, -1), new Velocity(0, -1)), parent.bottom());
    }

    @Test
    public void shouldCalculateLeftBottomDirection() {
        assertEquals(new Move(new Point(-1, -1), new Velocity(-1, -1)), parent.leftBottom());
    }

    @Test
    public void shouldCalculateLeftDirection() {
        assertEquals(new Move(new Point(-1, 0), new Velocity(-1, 0)), parent.left());
    }

    @Test
    public void shouldCalculateLeftTopDirection() {
        assertEquals(new Move(new Point(-1, 1), new Velocity(-1, 1)), parent.leftTop());
    }
}
