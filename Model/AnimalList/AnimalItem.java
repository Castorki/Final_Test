package Code.Model.AnimalList;


import java.io.Serializable;

public interface AnimalItem<Animal> extends Comparable<Animal> {
    int getAge();
    String getName();
    void setId(int size);
    String getStatus();
}
