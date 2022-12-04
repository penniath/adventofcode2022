package penniath;

import java.util.List;
import java.util.Objects;

public class Racksack {
    private List<String> first;

    private List<String> second;

    public Racksack(List<String> first, List<String> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racksack racksack = (Racksack) o;
        return Objects.equals(first, racksack.first) && Objects.equals(second, racksack.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public String getCommonElement() {
        return first.stream()
                .filter(item -> second.contains(item))
                .findFirst()
                .orElse(null);
    }
}
