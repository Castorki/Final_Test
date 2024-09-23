package Code.Model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Code.Model.AnimalList.AnimalItem;

public  class Animal implements AnimalItem<Animal> {

    private int id;
    private AnimalSpecies animalSpecies;
    private String name;
    private LocalDate birthDay;
    private List <String> commands;

    public Animal(AnimalSpecies animalSpecies, String name, LocalDate birthDay, List <String> commands) {
        this.animalSpecies = animalSpecies;
        this.name = name;
        this.birthDay = birthDay;
        this.commands = new ArrayList<>(commands);
    }



    public AnimalSpecies getAnimalSpecies() {
        return animalSpecies;
    }

    public void setAnimalSpecies(AnimalSpecies animalSpecies) {
        this.animalSpecies = animalSpecies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        return today.getYear() - birthDay.getYear();
    }


    public String getAnimalCommands() {
        if (commands == null || commands.isEmpty()) {
            return "не знает команд";
        }
        return String.join(", ", commands);
    }

    @Override
    public String toString() {
        return "id: " + id + ", animal species: " + animalSpecies + ", name: " + name + ", age: " + getAge() + ", commands: " + getAnimalCommands();
    }



    @Override
    public int compareTo(Animal o) {
        return name.compareTo(o.name);
    }
}
