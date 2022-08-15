package nl.apcreation.homework.hopper;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Hopper {
    private final Move currentMove;
    private final List<Move> moves;

    public Hopper(Move start) {
        this.currentMove = start;
        this.moves = List.of();
    }

    public Hopper(Hopper hopper, Move currentMove) {
        this.currentMove = currentMove;
        this.moves = new LinkedList<>(hopper.getMoves());
        this.moves.add(currentMove);
    }

    public boolean isMoveAlreadyMade(Move move) {
        return moves.stream()
                    .map(Move::getPoint)
                    .collect(Collectors.toSet())
                    .contains(move.getPoint());
    }

    public Set<Move> getPossibleMoves() {
        return Set.of(
                currentMove.top(),
                currentMove.rightTop(),
                currentMove.right(),
                currentMove.rightBottom(),
                currentMove.bottom(),
                currentMove.leftBottom(),
                currentMove.left(),
                currentMove.leftTop()
        );
    }
}
