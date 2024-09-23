package Code.Model.AnimalList;

import Code.Model.Animals.Animal;
import Code.Model.Animals.PackAnimal;
import Code.Model.Animals.PetAnimal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnimalList<Animal extends AnimalItem> implements Iterable<Animal> {
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
}
