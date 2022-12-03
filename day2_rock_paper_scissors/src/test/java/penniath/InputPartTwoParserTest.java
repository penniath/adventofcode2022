package penniath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import penniath.types.Paper;
import penniath.types.Rock;
import penniath.types.Scissors;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class InputPartTwoParserTest {
    private InputPartTwoParser parser;

    @BeforeEach
    public void setUp() {
        parser = new InputPartTwoParser();
    }

    @Test
    public void shouldReturnGamesFromGivenInputFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String content = new String(classLoader.getResourceAsStream("test_puzzle_input.txt").readAllBytes());

        List<Game> result = parser.parse(content);

        List<Game> expected = Arrays.asList(
                new Game(new Rock(), new Rock()),
                new Game(new Paper(), new Rock()),
                new Game(new Scissors(), new Rock())
        );

        assertIterableEquals(expected, result);
    }
}