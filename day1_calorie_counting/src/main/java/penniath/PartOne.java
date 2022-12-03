package penniath;

import java.io.IOException;
import java.util.List;

public class PartOne {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = PartOne.class.getClassLoader();
        String content = new String(classLoader.getResourceAsStream("puzzle_input.txt").readAllBytes());

        List<ElfCalories> elfsCalories = new ResultParser().parse(content);
        Integer maxCalories = new MaxCalorieFinder().find(elfsCalories);

        System.out.println(">>" + maxCalories);
    }
}