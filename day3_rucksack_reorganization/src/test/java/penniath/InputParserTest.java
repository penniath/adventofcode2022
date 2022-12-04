package penniath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class InputParserTest {
    private InputParser parser;

    @BeforeEach
    public void setUp() {
        parser = new InputParser();
    }

    @Test
    public void shouldReturnTheListOfRucksacksGivenTheExample() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String content = new String(classLoader.getResourceAsStream("test_puzzle_input.txt").readAllBytes());

        List<Rucksack> result = parser.parse(content);

        List<Rucksack> expected = Arrays.asList(
                new Rucksack(Arrays.asList("v", "J", "r", "w", "p", "W", "t", "w", "J", "g", "W", "r"), Arrays.asList("h", "c", "s", "F", "M", "M", "f", "F", "F", "h", "F", "p")),
                new Rucksack(Arrays.asList("j", "q", "H", "R", "N", "q", "R", "j", "q", "z", "j", "G", "D", "L", "G", "L"), Arrays.asList("r", "s", "F", "M", "f", "F", "Z", "S", "r", "L", "r", "F", "Z", "s", "S", "L")),
                new Rucksack(Arrays.asList("P", "m", "m", "d", "z", "q", "P", "r", "V"), Arrays.asList("v", "P", "w", "w", "T", "W", "B", "w", "g")),
                new Rucksack(Arrays.asList("w", "M", "q", "v", "L", "M", "Z", "H", "h", "H", "M", "v", "w", "L", "H"), Arrays.asList("j", "b", "v", "c", "j", "n", "n", "S", "B", "n", "v", "T", "Q", "F", "n")),
                new Rucksack(Arrays.asList("t", "t", "g", "J", "t", "R", "G", "J"), Arrays.asList("Q", "c", "t", "T", "Z", "t", "Z", "T")),
                new Rucksack(Arrays.asList("C", "r", "Z", "s", "J", "s", "P", "P", "Z", "s", "G", "z"), Arrays.asList("w", "w", "s", "L", "w", "L", "m", "p", "w", "M", "D", "w"))
        );

        assertIterableEquals(expected, result);
    }
}
