package penniath.types;

public class Scissors implements Bet {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        return o != null && getClass() == o.getClass();
    }
}
