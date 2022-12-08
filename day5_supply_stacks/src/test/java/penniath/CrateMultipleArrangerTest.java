package penniath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import penniath.model.CrateStack;
import penniath.model.DockStorage;
import penniath.model.MovingInstruction;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class CrateMultipleArrangerTest {
    private CrateMultipleArranger arranger;

    @BeforeEach
    public void setUp() {
        arranger = new CrateMultipleArranger();
    }

    @Test
    void shouldMoveCratesGivenTheExampleCase() {
        DockStorage dockStorage = new DockStorage(Arrays.asList(
                createStack("Z", "N"),
                createStack("M", "C", "D"),
                createStack("P")
        ));
        List<MovingInstruction> instructions = Arrays.asList(
                new MovingInstruction(2, 1, 1),
                new MovingInstruction(1, 3, 3),
                new MovingInstruction(2, 1, 2),
                new MovingInstruction(1, 2, 1)
        );

        arranger.arrange(dockStorage, instructions);

        DockStorage expected = new DockStorage(Arrays.asList(
                createStack("M"),
                createStack("C"),
                createStack("P", "Z", "N", "D")
        ));

        assertEquals(expected, dockStorage);
    }

    private CrateStack createStack(String... items) {
        Stack<String> stack = new Stack<>();
        for (String item: items) {
            stack.push(item);
        }

        return new CrateStack(stack);
    }
}