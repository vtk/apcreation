package nl.apcreation.homework.hopper;

import lombok.Data;

@Data
public class Velocity {
    private static final int MAX_SPEED = 3;
    private static final int MIN_SPEED = -3;

    private int xSpeed;
    private int ySpeed;

    public Velocity(int xSpeed, int ySpeed) {
        this.xSpeed = (xSpeed <= MAX_SPEED) ? Integer.max(MIN_SPEED, xSpeed) : Integer.min(MAX_SPEED, xSpeed);
        this.ySpeed = (ySpeed <= MAX_SPEED) ? Integer.max(MIN_SPEED, ySpeed) : Integer.min(MAX_SPEED, ySpeed);
    }
}
