package Code.Model.Animals.Comparators;

import Code.Model.AnimalList.AnimalItem;
import Code.Model.Animals.Animal;

import java.util.Comparator;

public class ComparingByClass <Animals extends AnimalItem> implements Comparator<Animal> {


    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getStatus().compareTo(o2.getStatus());
    }
}
