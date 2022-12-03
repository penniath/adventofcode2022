package penniath;

import penniath.types.Bet;
import penniath.types.Paper;
import penniath.types.Rock;
import penniath.types.Scissors;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputParser {

    public List<Game> parse(String content) {
        return Arrays.stream(content.split("\\n"))
                .map(InputParser::parseGame)
                .toList();
    }

    private static Game parseGame(String line) {
        String[] bets = line.split(" ");

        return new Game(
                parseBet(bets[0].charAt(0), 'A', 'B'),
                parseBet(bets[1].charAt(0), 'X', 'Y')
        );
    }

    private static Bet parseBet(Character value, Character rock, Character paper) {
        if (value.equals(rock)) {
            return new Rock();
        }
        if (value.equals(paper)) {
            return new Paper();
        }

        return new Scissors();
    }
}
