package penniath;

import java.io.IOException;
import java.util.List;

public class PartTwo {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = PartTwo.class.getClassLoader();
        String content = new String(classLoader.getResourceAsStream("puzzle_input.txt").readAllBytes());

        List<ElfCalories> elfsCalories = new ResultParser().parse(content);
        Integer maxCalories = new MaxCalorieFinder().find(elfsCalories, 3);

        System.out.println(">>" + maxCalories);
    }
}