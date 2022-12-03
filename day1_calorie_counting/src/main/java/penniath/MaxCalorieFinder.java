package penniath;

import java.util.List;

public class MaxCalorieFinder {
    public Integer find(List<ElfCalories> elfsCalories) {
        return elfsCalories.stream()
                .mapToInt(ElfCalories::getTotalCalories)
                .max()
                .orElse(0);
    }
}
