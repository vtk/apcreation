package nl.apcreation.homework.task;

import nl.apcreation.homework.hopper.Grid;
import nl.apcreation.homework.hopper.Hopper;
import nl.apcreation.homework.hopper.Move;
import nl.apcreation.homework.hopper.Obstacle;
import nl.apcreation.homework.hopper.Point;
import nl.apcreation.homework.hopper.Solver;
import nl.apcreation.homework.hopper.Velocity;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaskParser {
    private static final String COMMA_SEPARATOR = ",";

    public List<Task> parse(String input) {
        var arrayOfStrings = input.replace(" ", COMMA_SEPARATOR)
                .replace(System.lineSeparator(), COMMA_SEPARATOR)
                .split(COMMA_SEPARATOR);

        var listOfNumbers = Arrays.asList(arrayOfStrings)
                .stream()
                .filter(Predicate.not(String::isBlank))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        var dequeOfNumbers = new ArrayDeque<Integer>();
        dequeOfNumbers.addAll(listOfNumbers);

        return parseToTasks(dequeOfNumbers);
    }

    private List<Task> parseToTasks(Deque<Integer> deque) {
        var tasks = new ArrayList<Task>();
        var numberOfTasks = deque.pop();

        for (int i = 0; i < numberOfTasks; i++) {
            var gridDimensionX = deque.pop();
            var gridDimensionY = deque.pop();
            var hopperStartDimensionX = deque.pop();
            var hopperStartDimensionY = deque.pop();
            var hopperFinishDimensionX = deque.pop();
            var hopperFinishDimensionY = deque.pop();
            var obstaclesCount = deque.pop();
            var obstacles = new HashSet<Obstacle>();
            for (int j = 0; j < obstaclesCount; j++) {
                var obstacleX1 = deque.pop();
                var obstacleX2 = deque.pop();
                var obstacleY1 = deque.pop();
                var obstacleY2 = deque.pop();
                obstacles.add(new Obstacle(obstacleX1, obstacleX2, obstacleY1, obstacleY2));
            }

            var hopperStartPoint = new Point(hopperStartDimensionX, hopperStartDimensionY);
            var hopperStartVelocity = new Velocity(0, 0);
            var hopper = new Hopper(new Move(hopperStartPoint, hopperStartVelocity));

            var grid = new Grid(gridDimensionX, gridDimensionY, obstacles);
            var finishPoint = new Point(hopperFinishDimensionX, hopperFinishDimensionY);
            var solver = new Solver(grid, finishPoint);

            var task = new Task(hopper, solver);
            tasks.add(task);
        }

        return tasks;
    }
}
