package penniath;

import java.util.ArrayList;
import java.util.List;

public class RucksackCommonItemFinder {

    public String findCommonItem(Rucksack rucksack) {
        return rucksack.getCommonElement();
    }

    public String findCommonItemBetweenRucksacks(List<Rucksack> rucksacks) {
        List<String> items = new ArrayList<>(rucksacks.get(0).getAll());
        for (int i = 1; i < rucksacks.size(); i++) {
            items.retainAll(rucksacks.get(i).getAll());
        }

        return items.get(0);
    }
}
