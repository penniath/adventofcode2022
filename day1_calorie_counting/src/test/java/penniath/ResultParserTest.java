package penniath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ResultParserTest {
    private ResultParser resultParser;

    @BeforeEach
    public void setUp() {
        resultParser = new ResultParser();
    }

    @Test
    public void shouldReturnEmptyListWhenGivenPuzzleIsNull() {
        List<ElfCalories> result = resultParser.parse(null);

        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnElfGroupedCalorieListWhenPuzzleIsGiven() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String content = new String(classLoader.getResourceAsStream("test_puzzle_input.txt").readAllBytes());

        List<ElfCalories> result = resultParser.parse(content);

        List<ElfCalories> expected = List.of(
                new ElfCalories(List.of(1000, 2000, 3000)),
                new ElfCalories(List.of(4000)),
                new ElfCalories(List.of(5000, 6000)),
                new ElfCalories(List.of(7000, 8000, 9000)),
                new ElfCalories(List.of(10000))
        );
        assertIterableEquals(expected, result);
    }
}
