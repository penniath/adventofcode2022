package penniath;

import java.io.IOException;
import java.util.List;

public class PartOne {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = PartOne.class.getClassLoader();
        String content = new String(classLoader.getResourceAsStream("puzzle_input.txt").readAllBytes());

        List<Assignment> assignments = new InputParser().parse(content);
        List<Assignment> fullyContainedAssignments = new FullyContainedAssignmentFinder().find(assignments);

        System.out.println(">>> " + fullyContainedAssignments.size());
    }
}