package nl.apcreation.homework.hopper;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolverTest {
    @Test
    public void shouldFindOptimalSolution() {
        var obstacle = new Obstacle(1, 4, 2, 3);
        var grid = new Grid(5, 5, Set.of(obstacle));
        var finishPoint = new Point(4, 4);
        var solutionResolver = new Solver(grid, finishPoint);

        var startPoint = new Point(4, 0);
        var startVelocity = new Velocity(0, 0);
        var startMove = new Move(startPoint, startVelocity);
        var hopper = new Hopper(startMove);

        assertEquals(7, solutionResolver.solveFor(hopper));
    }

    @Test
    public void shouldNotFindSolution() {
        var obstacle1 = new Obstacle(1, 1, 0, 2);
        var obstacle2 = new Obstacle(0, 2, 1, 1);
        var grid = new Grid(3, 3, Set.of(obstacle1, obstacle2));
        var finishPoint = new Point(2, 2);
        var solutionResolver = new Solver(grid, finishPoint);

        var startPoint = new Point(0, 0);
        var startVelocity = new Velocity(0, 0);
        var startMove = new Move(startPoint, startVelocity);
        var hopper = new Hopper(startMove);

        assertEquals(Integer.MAX_VALUE, solutionResolver.solveFor(hopper));
    }
}
