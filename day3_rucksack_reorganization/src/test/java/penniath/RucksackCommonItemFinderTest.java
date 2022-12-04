package penniath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RucksackCommonItemFinderTest {
    private RucksackCommonItemFinder finder;

    @BeforeEach
    public void setUp() {
        finder = new RucksackCommonItemFinder();
    }

    @Test
    public void findCommonItemShouldReturnTheExistingElementPresentInBothCompartments() {
        assertEquals("p", finder.findCommonItem(new Rucksack(Arrays.asList("v", "J", "r", "w", "p", "W", "t", "w", "J", "g", "W", "r"), Arrays.asList("h", "c", "s", "F", "M", "M", "f", "F", "F", "h", "F", "p"))));
        assertEquals("L", finder.findCommonItem(new Rucksack(Arrays.asList("j", "q", "H", "R", "N", "q", "R", "j", "q", "z", "j", "G", "D", "L", "G", "L"), Arrays.asList("r", "s", "F", "M", "f", "F", "Z", "S", "r", "L", "r", "F", "Z", "s", "S", "L"))));
        assertEquals("P", finder.findCommonItem(new Rucksack(Arrays.asList("P", "m", "m", "d", "z", "q", "P", "r", "V"), Arrays.asList("v", "P", "w", "w", "T", "W", "B", "w", "g"))));
        assertEquals("v", finder.findCommonItem(new Rucksack(Arrays.asList("w", "M", "q", "v", "L", "M", "Z", "H", "h", "H", "M", "v", "w", "L", "H"), Arrays.asList("j", "b", "v", "c", "j", "n", "n", "S", "B", "n", "v", "T", "Q", "F", "n"))));
        assertEquals("t", finder.findCommonItem(new Rucksack(Arrays.asList("t", "t", "g", "J", "t", "R", "G", "J"), Arrays.asList("Q", "c", "t", "T", "Z", "t", "Z", "T"))));
        assertEquals("s", finder.findCommonItem(new Rucksack(Arrays.asList("C", "r", "Z", "s", "J", "s", "P", "P", "Z", "s", "G", "z"), Arrays.asList("w", "w", "s", "L", "w", "L", "m", "p", "w", "M", "D", "w"))));
    }

    @Test
    public void findCommonItemBetweenRucksacksShouldReturnTheExistingElementPresentInAllRucksack() {
        assertEquals(
                "r",
                finder.findCommonItemBetweenRucksacks(Arrays.asList(
                        new Rucksack(Arrays.asList("v", "J", "r", "w", "p", "W", "t", "w", "J", "g", "W", "r"), Arrays.asList("h", "c", "s", "F", "M", "M", "f", "F", "F", "h", "F", "p")),
                        new Rucksack(Arrays.asList("j", "q", "H", "R", "N", "q", "R", "j", "q", "z", "j", "G", "D", "L", "G", "L"), Arrays.asList("r", "s", "F", "M", "f", "F", "Z", "S", "r", "L", "r", "F", "Z", "s", "S", "L")),
                        new Rucksack(Arrays.asList("P", "m", "m", "d", "z", "q", "P", "r", "V"), Arrays.asList("v", "P", "w", "w", "T", "W", "B", "w", "g"))
                ))
        );
        assertEquals(
                "Z",
                finder.findCommonItemBetweenRucksacks(Arrays.asList(
                        new Rucksack(Arrays.asList("w", "M", "q", "v", "L", "M", "Z", "H", "h", "H", "M", "v", "w", "L", "H"), Arrays.asList("j", "b", "v", "c", "j", "n", "n", "S", "B", "n", "v", "T", "Q", "F", "n")),
                        new Rucksack(Arrays.asList("t", "t", "g", "J", "t", "R", "G", "J"), Arrays.asList("Q", "c", "t", "T", "Z", "t", "Z", "T")),
                        new Rucksack(Arrays.asList("C", "r", "Z", "s", "J", "s", "P", "P", "Z", "s", "G", "z"), Arrays.asList("w", "w", "s", "L", "w", "L", "m", "p", "w", "M", "D", "w"))
                ))
        );
    }
}
