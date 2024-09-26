package Code.Model.AnimalList;

import Code.Model.Animals.Comparators.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnimalList<Animal extends AnimalItem> implements Iterable<Animal>, Serializable {
    private final List<Animal> animalList = new ArrayList<>();


    public void addAnimal(Animal animal) {
        animalList.add(animal);
        animal.setId(animalList.size());
    }


    public void removeAnimal(Animal animal) {
        animalList.remove(animal);
    }


    @Override
    public Iterator<Animal> iterator() {
        return new AnimalIterator<>(animalList);
    }

    public void  sortByName(){
        animalList.sort(new ComparingByName<>());
    }

    public void sortByAge(){
        animalList.sort(new ComparingByAge<>());
    }

    public int getSize() {
        return animalList.size();
    }
}
