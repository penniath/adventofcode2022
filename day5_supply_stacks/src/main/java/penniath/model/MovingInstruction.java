package penniath.model;

import java.util.Objects;

public class MovingInstruction {
    private int from;
    private int to;
    private int count;

    public MovingInstruction(int from, int to, int count) {
        this.from = from;
        this.to = to;
        this.count = count;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovingInstruction that = (MovingInstruction) o;
        return from == that.from && to == that.to && count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, count);
    }
}
