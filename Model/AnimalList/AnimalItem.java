package Code.Model.AnimalList;


public interface AnimalItem<Animal> extends Comparable<Animal> {
    int getAge();
    String getName();
    void setId(int size);
}
