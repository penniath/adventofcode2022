package penniath;

import java.util.Objects;

public class Assignment {
    private ElfAssignment first;
    private ElfAssignment second;

    public Assignment(ElfAssignment first, ElfAssignment second) {
        this.first = first;
        this.second = second;
    }

    public ElfAssignment getFirst() {
        return first;
    }

    public ElfAssignment getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return Objects.equals(first, that.first) && Objects.equals(second, that.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public boolean areFullyContained() {
        return first.containsFully(second) || second.containsFully(first);
    }

    public boolean areOverlapping() {
        return first.overlaps(second) || second.overlaps(first);
    }
}
