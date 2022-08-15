package nl.apcreation.homework.hopper;

import nl.apcreation.homework.hopper.Grid;
import nl.apcreation.homework.hopper.Move;
import nl.apcreation.homework.hopper.Point;
import nl.apcreation.homework.hopper.Velocity;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GridTest {
    @Test
    public void shouldFailToCreateGridOnInvalidGridXDimension() {
        var thrown = assertThrows(IllegalArgumentException.class, () -> new Grid(31, 30, Set.of()));
        assertEquals("Illegal grid dimension x = 31", thrown.getMessage());
    }

    @Test
    public void shouldFailToCreateGridOnInvalidGridYDimension() {
        var thrown = assertThrows(IllegalArgumentException.class, () -> new Grid(30, 31, Set.of()));
        assertEquals("Illegal grid dimension y = 31", thrown.getMessage());
    }

    @Test
    public void shouldNotAllowMovesOutsideGrid() {
        var grid = new Grid(30, 30, Set.of());

        assertFalse(grid.isMoveAllowed(new Move(new Point(-1, 0), new Velocity(0, 0))));
        assertFalse(grid.isMoveAllowed(new Move(new Point(0, -1), new Velocity(0, 0))));
        assertFalse(grid.isMoveAllowed(new Move(new Point(30, 29), new Velocity(0, 0))));
        assertFalse(grid.isMoveAllowed(new Move(new Point(29, 30), new Velocity(0, 0))));
    }

    @Test
    public void shouldAllowMovesInsideGrid() {
        var grid = new Grid(30, 30, Set.of());

        assertTrue(grid.isMoveAllowed(new Move(new Point(5, 0), new Velocity(0, 0))));
        assertTrue(grid.isMoveAllowed(new Move(new Point(0, 6), new Velocity(0, 0))));
        assertTrue(grid.isMoveAllowed(new Move(new Point(25, 29), new Velocity(0, 0))));
        assertTrue(grid.isMoveAllowed(new Move(new Point(29, 12), new Velocity(0, 0))));
    }
}
