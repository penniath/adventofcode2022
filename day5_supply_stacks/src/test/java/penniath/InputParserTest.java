package penniath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import penniath.model.CrateStack;
import penniath.model.DockStorage;
import penniath.model.MovingInstruction;
import penniath.model.StatusAndInstructions;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    private InputParser parser;

    @BeforeEach
    public void setUp() {
        parser = new InputParser();
    }

    @Test
    public void shouldReturnStatusAndInstructionsFromExamplePuzzleFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String content = new String(classLoader.getResourceAsStream("test_puzzle_input.txt").readAllBytes());

        StatusAndInstructions result = parser.parse(content);

        StatusAndInstructions expected = new StatusAndInstructions(
                new DockStorage(Arrays.asList(
                        createStack("Z", "N"),
                        createStack("M", "C", "D"),
                        createStack("P")
                )),
                Arrays.asList(
                        new MovingInstruction(2, 1, 1),
                        new MovingInstruction(1, 3, 3),
                        new MovingInstruction(2, 1, 2),
                        new MovingInstruction(1, 2, 1)
                )
        );

        assertEquals(expected, result);
    }

    private CrateStack createStack(String... items) {
        Stack<String> stack = new Stack<>();
        for (String item: items) {
            stack.push(item);
        }
        
        return new CrateStack(stack);
    }
}