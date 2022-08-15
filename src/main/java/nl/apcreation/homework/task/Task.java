package nl.apcreation.homework.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.apcreation.homework.hopper.Hopper;
import nl.apcreation.homework.hopper.Solver;

@Data
@AllArgsConstructor
public class Task {
    private final Hopper hopper;
    private final Solver solver;
}
