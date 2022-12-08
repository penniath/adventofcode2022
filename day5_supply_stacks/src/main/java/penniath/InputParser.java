package penniath;

import penniath.model.DockStorage;
import penniath.model.MovingInstruction;
import penniath.model.StatusAndInstructions;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    public StatusAndInstructions parse(String content) {
        String[] split = content.split("\\n\\n");

        return new StatusAndInstructions(
                parseStatus(split[0]),
                parseInstructions(split[1])
        );
    }

    private DockStorage parseStatus(String value) {
        String[] split = value.split("\\n");
        Matcher countMatcher = Pattern.compile("(\\d+) *$").matcher(split[split.length - 1]);
        countMatcher.find();

        int count = Integer.parseInt(countMatcher.group(1));
        DockStorage dockStorage = DockStorage.init(count);

        for (int i = (split.length - 2); i >= 0; i--) {
            String original = split[i];
            int crateNumber = 0;
            for (int j = 0; (j + 2) < original.length(); j+=4) {
                String crate = String.valueOf(original.charAt(j + 1));
                if (!crate.equals(" ")) {
                    dockStorage.addCrate(crate, crateNumber);
                }

                crateNumber++;
            }
        }

        return dockStorage;
    }

    private List<MovingInstruction> parseInstructions(String value) {
        return Arrays.stream(value.split("\\n")).map(InputParser::parseInstruction).toList();
    }

    private static MovingInstruction parseInstruction(String line) {
        Pattern pattern = Pattern.compile("^move (?<count>\\d+) from (?<from>\\d+) to (?<to>\\d+)$");
        Matcher matcher = pattern.matcher(line);
        matcher.find();

        return new MovingInstruction(
                Integer.parseInt(matcher.group("from")),
                Integer.parseInt(matcher.group("to")),
                Integer.parseInt(matcher.group("count"))
        );
    }
}
