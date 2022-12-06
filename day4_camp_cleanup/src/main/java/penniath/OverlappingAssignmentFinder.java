package penniath;

import java.util.Collections;
import java.util.List;

public class OverlappingAssignmentFinder {
    public List<Assignment> find(List<Assignment> assignments) {
        if (assignments == null) {
            return Collections.emptyList();
        }

        return assignments.stream()
                .filter(Assignment::areOverlapping)
                .toList();
    }
}
