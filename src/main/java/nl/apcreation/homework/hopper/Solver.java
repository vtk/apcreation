package nl.apcreation.homework.hopper;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import static java.util.function.Predicate.not;

@EqualsAndHashCode
@RequiredArgsConstructor
public class Solver {
    private final Grid grid;
    private final Point finish;

    public int solveFor(Hopper hopper) {
        if (isAtFinish(hopper)) {
            return countTotalMoves(hopper);
        }

        return hopper.getPossibleMoves()
                     .stream()
                     .filter(not(hopper::isMoveAlreadyMade))
                     .filter(grid::isMoveAllowed)
                     .map(nextMove -> solveFor(new Hopper(hopper, nextMove)))
                     .mapToInt(i -> i) // just move from stream to intStream to get min()
                     .min()
                     .orElse(Integer.MAX_VALUE);
    }

    private boolean isAtFinish(Hopper hopper) {
        return finish.equals(hopper.getCurrentMove().getPoint());
    }

    private int countTotalMoves(Hopper hopper) {
        return hopper.getMoves().size();
    }
}
