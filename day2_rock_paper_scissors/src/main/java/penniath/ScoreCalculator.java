package penniath;

import penniath.types.Bet;
import penniath.types.Paper;
import penniath.types.Rock;

import java.util.List;

public class ScoreCalculator {
    public int calculate(List<Game> games) {
        if (games == null) {
            return 0;
        }

        return games.stream()
                .mapToInt(ScoreCalculator::calculateGameScore)
                .sum();
    }

    private static int calculateGameScore(Game game) {
        return calculateGameResultPoint(game) + calculateGameLeftBetPoints(game.getLeft());
    }

    private static int calculateGameResultPoint(Game game) {
        if (game.isLeftWinner()) {
            return 6;
        }
        if (game.isDraw()) {
            return 3;
        }

        return 0;
    }

    private static int calculateGameLeftBetPoints(Bet left) {
        if (left instanceof Rock) {
            return 1;
        }
        if (left instanceof Paper) {
            return 2;
        }

        return 3;
    }
}
