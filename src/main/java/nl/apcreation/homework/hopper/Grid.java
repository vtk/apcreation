package nl.apcreation.homework.hopper;

import lombok.Data;

import java.util.Optional;
import java.util.Set;

@Data
public class Grid {
    private static final int MAX_GRID_DIMENSION = 30;

    private final int dimensionX;
    private final int dimensionY;
    private final Set<Obstacle> obstacles;

    public Grid(int dimensionX, int dimensionY, Set<Obstacle> obstacles) {
        this.dimensionX = Optional.of(dimensionX)
                                  .filter(x -> x > 0 && x <= MAX_GRID_DIMENSION)
                                  .orElseThrow(() -> new IllegalArgumentException("Illegal grid dimension x = " + dimensionX));
        this.dimensionY = Optional.of(dimensionY)
                                  .filter(y -> y > 0 && y <= MAX_GRID_DIMENSION)
                                  .orElseThrow(() -> new IllegalArgumentException("Illegal grid dimension y = " + dimensionY));
        this.obstacles = obstacles;
    }

    public boolean isMoveAllowed(Move move) {
        var point = move.getPoint();
        var x = point.getX();
        var y = point.getY();
        var xInBoard = x < dimensionX && x >= 0;
        var yInBoard = y < dimensionY && y >= 0;
        var notInObstacles = obstacles.stream()
                                      .noneMatch(obstacle -> obstacle.contains(point));

        return xInBoard && yInBoard && notInObstacles;
    }
}
