package penniath;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<Racksack> parse(String content) {
        if (content == null) {
            return null;
        }

        return Arrays.stream(content.split("\\n"))
                .map(InputParser::parseRacksack)
                .toList();
    }

    private static Racksack parseRacksack(String line) {
        int length = line.length();
        int halfLine = length / 2;
        String firstCompartment = line.substring(0, halfLine);
        String secondCompartment = line.substring(halfLine);
        List<String> first = Arrays.asList(firstCompartment.split(""));
        List<String> second = Arrays.asList(secondCompartment.split(""));

        return new Racksack(first, second);
    }
}
