package penniath;

import java.util.Collections;
import java.util.List;

public class FullyContainedAssignmentFinder {
    public List<Assignment> find(List<Assignment> assignments) {
        if (assignments == null) {
            return Collections.emptyList();
        }

        return assignments.stream()
                .filter(Assignment::areFullyContained)
                .toList();
    }
}
