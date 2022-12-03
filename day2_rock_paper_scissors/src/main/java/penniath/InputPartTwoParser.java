package penniath;

import penniath.types.Bet;
import penniath.types.Paper;
import penniath.types.Rock;
import penniath.types.Scissors;

import java.util.Arrays;
import java.util.List;

public class InputPartTwoParser {

    public List<Game> parse(String content) {
        return Arrays.stream(content.split("\\n"))
                .map(InputPartTwoParser::parseGame)
                .toList();
    }

    private static Game parseGame(String line) {
        String[] bets = line.split(" ");

        Bet right = parseBet(bets[0].charAt(0));
        
        return new Game(
                right,
                parseBetByResult(bets[1].charAt(0), 'X', 'Z', right)
        );
    }

    private static Bet parseBet(Character value) {
        if (value.equals('A')) {
            return new Rock();
        }
        if (value.equals('B')) {
            return new Paper();
        }

        return new Scissors();
    }

    private static Bet parseBetByResult(Character value, Character lose, Character win, Bet right) {
        if (value.equals(lose)) {
            if (right instanceof Rock) {
                return new Scissors();
            }
            if (right instanceof Paper) {
                return new Rock();
            }

            return new Paper();
        } else if (value.equals(win)) {
            if (right instanceof Rock) {
                return new Paper();
            }
            if (right instanceof Paper) {
                return new Scissors();
            }

            return new Rock();
        }

        return right;
    }
}
