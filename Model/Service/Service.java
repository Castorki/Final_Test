package Code.Model.Service;

import Code.Model.AnimalList.AnimalList;
import Code.Model.Animals.Animal;
import Code.Model.Animals.AnimalSpecies;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private final AnimalList<Animal> service;
    private int idAnimal;

    public Service() {
        service = new AnimalList<>();
    }


        public void addAnimal(AnimalSpecies species, String name, LocalDate birthDay, List<String> commands) {
        Animal animal = new Animal(species, name, birthDay, commands);
        service.addAnimal(animal);
    }

    public void removeAnimal(int idAnimal) {
        service.removeAnimal(getAnimalById(idAnimal));
    }

    public Animal getAnimalById(int idAnimal) {
        for (Animal animal : service) {
            if(animal.getId() == idAnimal) {
                return animal;
            }
        }
        return null;
    }

    public String getAnimalList(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список животных в зоопарке:\n");
        for (Animal animal : service){
            stringBuilder.append(animal);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
