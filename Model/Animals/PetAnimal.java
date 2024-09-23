package Code.Model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PetAnimal extends Animal{

    public PetAnimal(String status, AnimalSpecies animalSpecies, String name, LocalDate birthDay, List<String> commands) {
        this.status = status;
        this.animalSpecies = animalSpecies;
        this.name = name;
        this.birthDay = birthDay;
        this.commands = new ArrayList<>(commands);
    }

    @Override
    public String toString() {
        return "id: " + id + ", animal class: " + status + ", animal species: " + animalSpecies + ", name: " + name + ", age: " + getAge() + ", commands: " + getAnimalCommands();
    }
}
