package penniath.model;

import java.util.List;
import java.util.Objects;

public class StatusAndInstructions {
    private DockStorage storage;
    private List<MovingInstruction> instructions;

    public StatusAndInstructions(DockStorage storage, List<MovingInstruction> instructions) {
        this.storage = storage;
        this.instructions = instructions;
    }

    public DockStorage getStorage() {
        return storage;
    }

    public List<MovingInstruction> getInstructions() {
        return instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusAndInstructions that = (StatusAndInstructions) o;
        return Objects.equals(storage, that.storage) && Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storage, instructions);
    }
}
