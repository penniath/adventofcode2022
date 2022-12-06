package penniath;

import java.io.IOException;
import java.util.List;

public class PartTwo {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = PartTwo.class.getClassLoader();
        String content = new String(classLoader.getResourceAsStream("puzzle_input.txt").readAllBytes());

        List<Assignment> assignments = new InputParser().parse(content);
        List<Assignment> overlappingAssignments = new OverlappingAssignmentFinder().find(assignments);

        System.out.println(">>> " + overlappingAssignments.size());
    }
}