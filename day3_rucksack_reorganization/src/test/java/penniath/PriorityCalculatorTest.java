package penniath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static penniath.PriorityCalculator.calculatePriority;

public class PriorityCalculatorTest {
    private PriorityCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new PriorityCalculator();
    }

    @Test
    public void calculatePriorityShouldReturnIndividualPriorityOfGivenItem() {
        assertEquals(16, calculatePriority("p"));
        assertEquals(38, calculatePriority("L"));
        assertEquals(42, calculatePriority("P"));
        assertEquals(22, calculatePriority("v"));
        assertEquals(20, calculatePriority("t"));
        assertEquals(19, calculatePriority("s"));
    }

    @Test
    public void calculateTotalPriorityShouldReturnTheSumOfIndividualPrioritiesOfGivenItems() {
        List<String> items = Arrays.asList("p", "L", "P", "v", "t", "s");

        int result = calculator.calculateTotalPriority(items);

        assertEquals(157, result);
    }
}
