package nl.apcreation.homework.hopper;

import lombok.Data;

@Data
public class Move {
    private final Point point;
    private final Velocity velocity;

    public Move(Point point, Velocity velocity) {
        this.point = point;
        this.velocity = velocity;
    }

    public Move(Move parent, Velocity velocity) {
        this.point = new Point(parent.getPoint().getX() + velocity.getXSpeed(), parent.getPoint().getY() + velocity.getYSpeed());
        this.velocity = velocity;
    }

    public Move top() {
        return new Move(this, new Velocity(velocity.getXSpeed(), velocity.getYSpeed() + 1));
    }

    public Move rightTop() {
        return new Move(this, new Velocity(velocity.getXSpeed() + 1, velocity.getYSpeed() + 1));
    }

    public Move right() {
        return new Move(this, new Velocity(velocity.getXSpeed() + 1, velocity.getYSpeed()));
    }

    public Move rightBottom() {
        return new Move(this, new Velocity(velocity.getXSpeed() + 1, velocity.getYSpeed() - 1));
    }

    public Move bottom() {
        return new Move(this, new Velocity(velocity.getXSpeed(), velocity.getYSpeed() - 1));
    }

    public Move leftBottom() {
        return new Move(this, new Velocity(velocity.getXSpeed() - 1, velocity.getYSpeed() - 1));
    }

    public Move left() {
        return new Move(this, new Velocity(velocity.getXSpeed() - 1, velocity.getYSpeed()));
    }

    public Move leftTop() {
        return new Move(this, new Velocity(velocity.getXSpeed() - 1, velocity.getYSpeed() + 1));
    }
}
