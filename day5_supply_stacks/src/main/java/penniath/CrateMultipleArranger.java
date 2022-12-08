package penniath;

import penniath.model.DockStorage;
import penniath.model.MovingInstruction;

import java.util.List;
import java.util.Stack;

public class CrateMultipleArranger {

    public void arrange(DockStorage storage, List<MovingInstruction> instructions) {
        for (MovingInstruction instruction: instructions) {
            Stack<String> removedCrates = new Stack<>();
            int from = instruction.getFrom() - 1;
            int to = instruction.getTo() - 1;

            for (int i = 0; i < instruction.getCount(); i++) {
                String crate = storage.removeCrate(from);
                removedCrates.push(crate);
            }

            while (!removedCrates.isEmpty()) {
                storage.addCrate(removedCrates.pop(), to);
            }
        }
    }
}
