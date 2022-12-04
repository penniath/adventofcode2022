package penniath;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        String content = new String(classLoader.getResourceAsStream("puzzle_input.txt").readAllBytes());

        List<Racksack> racksacks = new InputParser().parse(content);
        List<String> items = racksacks.stream().map(Racksack::getCommonElement).toList();
        int priority = new PriorityCalculator().calculateTotalPriority(items);

        System.out.println(">>> " + priority);
    }
}