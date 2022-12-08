package penniath.model;

import java.util.Objects;
import java.util.Stack;

public class CrateStack {
    private Stack<String> crates;

    public CrateStack() {
        crates = new Stack<>();
    }

    public CrateStack(Stack<String> crates) {
        this.crates = crates;
    }

    public void add(String crate) {
        crates.push(crate);
    }

    public String removeCrate() {
        return crates.pop();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrateStack that = (CrateStack) o;
        return Objects.equals(crates, that.crates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crates);
    }
}
