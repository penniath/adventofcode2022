package penniath;

import penniath.types.Bet;
import penniath.types.Paper;
import penniath.types.Rock;
import penniath.types.Scissors;

import java.util.Objects;

public class Game {
    private Bet right;
    private Bet left;

    public Game(Bet right, Bet left) {
        this.right = right;
        this.left = left;
    }

    public Bet getRight() {
        return right;
    }

    public Bet getLeft() {
        return left;
    }

    public boolean isLeftWinner() {
        return (left instanceof Rock && right instanceof Scissors)
            ||  (left instanceof Paper && right instanceof Rock)
            ||  (left instanceof Scissors && right instanceof Paper);
    }

    public boolean isDraw() {
        return Objects.equals(right.getClass(), left.getClass());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(right, game.right) && Objects.equals(left, game.left);
    }

    @Override
    public int hashCode() {
        return Objects.hash(right, left);
    }
}
