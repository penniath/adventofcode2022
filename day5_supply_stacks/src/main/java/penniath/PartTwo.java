package penniath;

import penniath.model.CrateStack;
import penniath.model.DockStorage;
import penniath.model.StatusAndInstructions;

import java.io.IOException;
import java.util.stream.Collectors;

public class PartTwo {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = PartTwo.class.getClassLoader();
        String content = new String(classLoader.getResourceAsStream("puzzle_input.txt").readAllBytes());

        InputParser parser = new InputParser();
        CrateMultipleArranger arranger = new CrateMultipleArranger();

        StatusAndInstructions statusAndInstructions = parser.parse(content);
        DockStorage dockStorage = statusAndInstructions.getStorage();
        arranger.arrange(dockStorage, statusAndInstructions.getInstructions());

        System.out.println(dockStorage.getCrates().stream().map(CrateStack::removeCrate).collect(Collectors.joining("")));
    }
}