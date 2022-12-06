package penniath;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputParser {

    public List<Assignment> parse(String content) {
        if (content == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(content.split("\\n"))
                .map(InputParser::parseAssignment)
                .toList();
    }

    private static Assignment parseAssignment(String value) {
        String[] split = value.split(",");

        return new Assignment(
                parseElfAssignment(split[0]),
                parseElfAssignment(split[1])
        );
    }

    private static ElfAssignment parseElfAssignment(String value) {
        String[] split = value.split("-");

        return new ElfAssignment(
                Integer.parseInt(split[0]),
                Integer.parseInt(split[1])
        );
    }
}
