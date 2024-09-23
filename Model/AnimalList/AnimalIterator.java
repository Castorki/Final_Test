package Code.Model.AnimalList;
import java.util.Iterator;
import java.util.List;


public class AnimalIterator<Animal> implements Iterator<Animal> {

    private int id;
    private final List<Animal> animalList;

    public AnimalIterator(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public boolean hasNext() {
        return id < animalList.size();
    }

    @Override
    public Animal next() {
        return animalList.get(id++);
    }
}