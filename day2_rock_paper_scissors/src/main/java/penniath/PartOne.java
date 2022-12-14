package penniath;

import java.io.IOException;
import java.util.List;

public class PartOne {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = PartOne.class.getClassLoader();
        String content = new String(classLoader.getResourceAsStream("puzzle_input.txt").readAllBytes());

        List<Game> games = new InputParser().parse(content);
        Integer score = new ScoreCalculator().calculate(games);

        System.out.println(">>" + score);
    }
}