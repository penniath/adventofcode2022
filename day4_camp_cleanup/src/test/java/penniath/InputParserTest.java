package penniath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {
    private InputParser parser;

    @BeforeEach
    public void setUp() {
        parser = new InputParser();
    }

    @Test
    public void shouldReturnAssignmentsFromGivenExampleFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String content = new String(classLoader.getResourceAsStream("test_puzzle_input.txt").readAllBytes());

        List<Assignment> result = parser.parse(content);

        List<Assignment> expected = Arrays.asList(
                new Assignment(new ElfAssignment(2, 4), new ElfAssignment(6, 8)),
                new Assignment(new ElfAssignment(2, 3), new ElfAssignment(4, 5)),
                new Assignment(new ElfAssignment(5, 7), new ElfAssignment(7, 9)),
                new Assignment(new ElfAssignment(2, 8), new ElfAssignment(3, 7)),
                new Assignment(new ElfAssignment(6, 6), new ElfAssignment(4, 6)),
                new Assignment(new ElfAssignment(2, 6), new ElfAssignment(4, 8))
        );

        assertIterableEquals(expected, result);
    }
}