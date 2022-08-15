package nl.apcreation.homework.hopper;

import nl.apcreation.homework.hopper.Obstacle;
import nl.apcreation.homework.hopper.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObstacleTest {
    @Test
    public void shouldContainPoints() {
        var obstacle = new Obstacle(1, 4, 2, 3);
        assertTrue(obstacle.contains(new Point(1, 2)));
        assertTrue(obstacle.contains(new Point(2, 2)));
        assertTrue(obstacle.contains(new Point(3, 2)));
        assertTrue(obstacle.contains(new Point(4, 2)));
        assertTrue(obstacle.contains(new Point(1, 3)));
        assertTrue(obstacle.contains(new Point(2, 3)));
        assertTrue(obstacle.contains(new Point(3, 3)));
        assertTrue(obstacle.contains(new Point(4, 3)));
    }

    @Test
    public void shouldNotContainPoints() {
        var obstacle = new Obstacle(1, 4, 2, 3);
        assertFalse(obstacle.contains(new Point(1, 4)));
        assertFalse(obstacle.contains(new Point(0, 1)));
        assertFalse(obstacle.contains(new Point(0, 2)));
        assertFalse(obstacle.contains(new Point(0, 3)));
        assertFalse(obstacle.contains(new Point(5, 1)));
        assertFalse(obstacle.contains(new Point(5, 2)));
        assertFalse(obstacle.contains(new Point(5, 3)));
        assertFalse(obstacle.contains(new Point(5, 4)));
    }
}
