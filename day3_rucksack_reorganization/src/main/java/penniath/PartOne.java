package penniath;

import java.io.IOException;
import java.util.List;

public class PartOne {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = PartOne.class.getClassLoader();
        String content = new String(classLoader.getResourceAsStream("puzzle_input.txt").readAllBytes());

        List<Rucksack> rucksacks = new InputParser().parse(content);
        List<String> items = rucksacks.stream().map(Rucksack::getCommonElement).toList();
        int priority = new PriorityCalculator().calculateTotalPriority(items);

        System.out.println(">>> " + priority);
    }
}