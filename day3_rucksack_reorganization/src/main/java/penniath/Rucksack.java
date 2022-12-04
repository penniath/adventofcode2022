package penniath;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rucksack {
    private List<String> first;

    private List<String> second;

    public Rucksack(List<String> first, List<String> second) {
        this.first = first;
        this.second = second;
    }

    public String getCommonElement() {
        return first.stream()
                .filter(item -> second.contains(item))
                .findFirst()
                .orElse(null);
    }

    public List<String> getAll() {
        List<String> items = new ArrayList<>();
        items.addAll(first);
        items.addAll(second);

        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rucksack rucksack = (Rucksack) o;
        return Objects.equals(first, rucksack.first) && Objects.equals(second, rucksack.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
