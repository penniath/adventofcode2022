package penniath;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        String content = new String(classLoader.getResourceAsStream("puzzle_input.txt").readAllBytes());

        List<Assignment> assignments = new InputParser().parse(content);
        List<Assignment> fullyContainedAssignments = new FullyContainedAssignmentFinder().find(assignments);

        System.out.println(">>> " + fullyContainedAssignments.size());
    }
}