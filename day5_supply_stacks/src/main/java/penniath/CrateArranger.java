package penniath;

import penniath.model.DockStorage;
import penniath.model.MovingInstruction;

import java.util.List;

public class CrateArranger {

    public void arrange(DockStorage storage, List<MovingInstruction> instructions) {
        for (MovingInstruction instruction: instructions) {
            for (int i = 0; i < instruction.getCount(); i++) {
                int from = instruction.getFrom() - 1;
                int to = instruction.getTo() - 1;

                String crate = storage.removeCrate(from);
                storage.addCrate(crate, to);
            }
        }
    }
}
