package penniath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FullyContainedAssignmentFinderTest {
    private FullyContainedAssignmentFinder finder;

    @BeforeEach
    public void setUp() {
        finder = new FullyContainedAssignmentFinder();
    }

    @Test
    public void shouldReturnAssignmentsThatOverlap() {
        List<Assignment> assignments = Arrays.asList(
                new Assignment(new ElfAssignment(2, 4), new ElfAssignment(6, 8)),
                new Assignment(new ElfAssignment(2, 3), new ElfAssignment(4, 5)),
                new Assignment(new ElfAssignment(5, 7), new ElfAssignment(7, 9)),
                new Assignment(new ElfAssignment(2, 8), new ElfAssignment(3, 7)),
                new Assignment(new ElfAssignment(6, 6), new ElfAssignment(4, 6)),
                new Assignment(new ElfAssignment(2, 6), new ElfAssignment(4, 8))
        );

        List<Assignment> result = finder.find(assignments);

        List<Assignment> expected = Arrays.asList(
                new Assignment(new ElfAssignment(2, 8), new ElfAssignment(3, 7)),
                new Assignment(new ElfAssignment(6, 6), new ElfAssignment(4, 6))
        );

        assertIterableEquals(expected, result);
    }
}