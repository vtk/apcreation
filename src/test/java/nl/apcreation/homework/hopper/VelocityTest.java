package nl.apcreation.homework.hopper;

import nl.apcreation.homework.hopper.Velocity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VelocityTest {
    @Test
    public void shouldNotExceedMaxVelocityOver3() {
        var v1 = new Velocity(3, 3);
        assertEquals(3, v1.getXSpeed());
        assertEquals(3, v1.getYSpeed());

        var v2 = new Velocity(4, 3);
        assertEquals(3, v2.getXSpeed());
        assertEquals(3, v2.getYSpeed());

        var v3 = new Velocity(3, 4);
        assertEquals(3, v3.getXSpeed());
        assertEquals(3, v3.getYSpeed());
    }

    @Test
    public void shouldNotExceedMinVelocityOverMinus3() {
        var v1 = new Velocity(-3, -3);
        assertEquals(-3, v1.getXSpeed());
        assertEquals(-3, v1.getYSpeed());

        var v2 = new Velocity(-4, -3);
        assertEquals(-3, v2.getXSpeed());
        assertEquals(-3, v2.getYSpeed());

        var v3 = new Velocity(-3, -4);
        assertEquals(-3, v3.getXSpeed());
        assertEquals(-3, v3.getYSpeed());
    }

    @Test
    public void shouldSetAnyVelocityBetween3AndMinus3() {
        var v1 = new Velocity(0, 2);
        assertEquals(0, v1.getXSpeed());
        assertEquals(2, v1.getYSpeed());

        var v2 = new Velocity(1, 1);
        assertEquals(1, v2.getXSpeed());
        assertEquals(1, v2.getYSpeed());

        var v3 = new Velocity(-2, 2);
        assertEquals(-2, v3.getXSpeed());
        assertEquals(2, v3.getYSpeed());
    }
}
