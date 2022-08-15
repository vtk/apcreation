package nl.apcreation.homework.task;

import nl.apcreation.homework.hopper.Grid;
import nl.apcreation.homework.hopper.Hopper;
import nl.apcreation.homework.hopper.Move;
import nl.apcreation.homework.hopper.Obstacle;
import nl.apcreation.homework.hopper.Point;
import nl.apcreation.homework.hopper.Solver;
import nl.apcreation.homework.hopper.Velocity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class TaskParserTest {
    @Test
    public void shouldParseDemoInputDataAsExpected() {
        var taskParser = new TaskParser();
        var input = "2\n" +
                "5 5\n" +
                "4 0 4 4\n" +
                "1\n" +
                "1 4 2 3\n" +
                "3 3\n" +
                "0 0 2 2\n" +
                "\n" +
                "2\n" +
                "1 1 0 2\n" +
                "0 2 1 1";

        var tasks = taskParser.parse(input);

        Assertions.assertEquals(2, tasks.size());

        var task1 = tasks.get(0);

        var startPoint1 = new Point(4, 0);
        var startVelocity1 = new Velocity(0, 0);
        var startMove1 = new Move(startPoint1, startVelocity1);
        var hopper1 = new Hopper(startMove1);
        var obstacle1 = new Obstacle(1,4,2,3);
        var grid1 = new Grid(5, 5, Set.of(obstacle1));
        var finishPoint1 = new Point(4, 4);
        var solutionResolver1 = new Solver(grid1, finishPoint1);

        Assertions.assertEquals(hopper1, task1.getHopper());
        Assertions.assertEquals(solutionResolver1, task1.getSolver());
    }
}
