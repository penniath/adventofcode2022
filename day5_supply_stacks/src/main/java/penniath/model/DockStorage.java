package penniath.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class DockStorage {
    private List<CrateStack> crates;

    public DockStorage(List<CrateStack> crates) {
        this.crates = crates;
    }

    public static DockStorage init(int stackCount) {
        List<CrateStack> crates = IntStream.range(0, stackCount).mapToObj((i) -> new CrateStack()).toList();

        return new DockStorage(crates);
    }

    public void addCrate(String crate, int stack) {
        crates.get(stack).add(crate);
    }

    public String removeCrate(int stack) {
        return crates.get(stack).removeCrate();
    }

    public List<CrateStack> getCrates() {
        return crates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DockStorage that = (DockStorage) o;
        return Objects.equals(crates, that.crates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crates);
    }
}
