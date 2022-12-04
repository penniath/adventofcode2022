package penniath;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PriorityCalculator {

    public int calculateTotalPriority(List<String> items) {
        return items.stream()
                .mapToInt(PriorityCalculator::calculatePriority)
                .sum();
    }

    public static int calculatePriority(String item) {
        List<String> priorityList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        String lowerItem = item.toLowerCase();
        int priority = 0;
        if (Pattern.matches("[A-Z]", item)) {
            priority += priorityList.size();
        }

        priority += priorityList.indexOf(lowerItem) + 1;

        return priority;
    }
}
