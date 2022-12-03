package penniath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import penniath.types.Bet;
import penniath.types.Paper;
import penniath.types.Rock;
import penniath.types.Scissors;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreScoreCalculatorTest {
    private ScoreCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new ScoreCalculator();
    }

    @Test
    public void shouldReturn15WhenExampleCaseIsGiven() {
        List<Game> games = Arrays.asList(
                new Game(new Rock(), new Paper()),
                new Game(new Paper(), new Rock()),
                new Game(new Scissors(), new Scissors())
        );

        int result = calculator.calculate(games);

        assertEquals(15, result);
    }
}
