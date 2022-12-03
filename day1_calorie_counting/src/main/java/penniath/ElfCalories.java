package penniath;

import java.util.List;
import java.util.Objects;

public class ElfCalories {
    private List<Integer> calories;

    public ElfCalories(List<Integer> calories) {
        this.calories = calories;
    }

    public Integer getTotalCalories() {
        return calories
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElfCalories that = (ElfCalories) o;
        return Objects.equals(calories, that.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calories);
    }

    @Override
    public String toString() {
        return "ElfCalories{" +
                "calories=" + calories +
                '}';
    }
}
