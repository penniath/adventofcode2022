package penniath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxCalorieFinderTest {
    private MaxCalorieFinder finder;

    @BeforeEach
    public void setUp() {
        finder = new MaxCalorieFinder();
    }

    @Test
    public void shouldReturnTheMaxCaloriesAnElfHasRetrievedWhenCase1IsGiven() {
        List<ElfCalories> calories = List.of(
                new ElfCalories(List.of(1000, 2000, 3000)),
                new ElfCalories(List.of(4000)),
                new ElfCalories(List.of(5000, 6000)),
                new ElfCalories(List.of(7000, 8000, 9000)),
                new ElfCalories(List.of(10000))
        );

        Integer maxCalories = finder.find(calories);

        assertEquals(24000, maxCalories);
    }

    @Test
    public void shouldReturnTheMaxCaloriesAnElfHasRetrievedWhenCase2IsGiven() {
        List<ElfCalories> calories = List.of(
                new ElfCalories(List.of(1000, 2000, 3000)),
                new ElfCalories(List.of(4000)),
                new ElfCalories(List.of(5000, 6000))
        );

        Integer maxCalories = finder.find(calories);

        assertEquals(11000, maxCalories);
    }
}