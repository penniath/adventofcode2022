package penniath;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MaxCalorieFinder {
    public Integer find(List<ElfCalories> elfsCalories) {
        return find(elfsCalories, 1);
    }

    public Integer find(List<ElfCalories> elfsCalories, int count) {
        return elfsCalories.stream()
                .map(ElfCalories::getTotalCalories)
                .sorted(Comparator.reverseOrder())
                .limit(count)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
