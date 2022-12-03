package penniath;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResultParser {
    public List<ElfCalories> parse(String content) {
        if (content == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(content.split("\\n\\n"))
                .map(group -> Arrays.stream(group.split("\\n")).map(Integer::parseInt).toList())
                .map(ElfCalories::new)
                .toList();
    }
}
