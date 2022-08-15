package nl.apcreation.homework.hopper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Obstacle {
    private final int x1;
    private final int x2;
    private final int y1;
    private final int y2;

    public boolean contains(Point point) {
        return x1 <= point.getX() && x2 >= point.getX() && y1 <= point.getY() && y2 >= point.getY();
    }
}
