package penniath;

import java.util.Objects;

public class ElfAssignment {
    private int startingSection;
    private int endingSection;

    public ElfAssignment(int startingSection, int endingSection) {
        this.startingSection = startingSection;
        this.endingSection = endingSection;
    }

    public int getStartingSection() {
        return startingSection;
    }

    public int getEndingSection() {
        return endingSection;
    }

    public boolean containsFully(ElfAssignment elfAssignment) {
        return startingSection <= elfAssignment.getStartingSection() && endingSection >= elfAssignment.getEndingSection();
    }

    public boolean overlaps(ElfAssignment elfAssignment) {
        return startingSection <= elfAssignment.getEndingSection() && endingSection >= elfAssignment.getStartingSection();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElfAssignment that = (ElfAssignment) o;
        return startingSection == that.startingSection && endingSection == that.endingSection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startingSection, endingSection);
    }
}