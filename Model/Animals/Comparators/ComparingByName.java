package Code.Model.Animals.Comparators;
import java.util.Comparator;

import Code.Model.AnimalList.AnimalItem;

public class ComparingByName<Animal extends AnimalItem> implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
