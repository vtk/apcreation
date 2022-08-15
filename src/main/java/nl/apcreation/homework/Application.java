package nl.apcreation.homework;

import nl.apcreation.homework.task.TaskParser;

public class Application {
    public static void main(String[] args) {
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

        var taskParser = new TaskParser();
        taskParser.parse(input)
                  .stream()
                  .map(task -> {
                      var hopper = task.getHopper();
                      var solver = task.getSolver();
                      return solver.solveFor(hopper);
                  })
                  .forEach(result -> {
                      if (result == Integer.MAX_VALUE) {
                          System.out.println("No solution.");
                      } else {
                          System.out.println("Optimal solution takes " + result + " hops.");
                      }
                  });
    }
}
