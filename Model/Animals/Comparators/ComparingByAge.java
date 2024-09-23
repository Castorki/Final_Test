package Code.Model.Animals.Comparators;

import Code.Model.AnimalList.AnimalItem;

import java.util.Comparator;

public class ComparingByAge<Animal extends AnimalItem> implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
