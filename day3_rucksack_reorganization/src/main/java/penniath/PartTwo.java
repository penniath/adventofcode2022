package penniath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartTwo {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = PartTwo.class.getClassLoader();
        String content = new String(classLoader.getResourceAsStream("puzzle_input.txt").readAllBytes());

        List<Rucksack> rucksacks = new InputParser().parse(content);
        RucksackCommonItemFinder finder = new RucksackCommonItemFinder();
        List<String> items = new ArrayList<>();
        for (int i = 0; i < rucksacks.size(); i+=3) {
            items.add(finder.findCommonItemBetweenRucksacks(Arrays.asList(rucksacks.get(i), rucksacks.get(i + 1), rucksacks.get(i + 2))));
        }
        int priority = new PriorityCalculator().calculateTotalPriority(items);

        System.out.println(">>> " + priority);
    }
}