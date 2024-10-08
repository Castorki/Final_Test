package Code.Model.Animals;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import Code.Model.AnimalList.AnimalItem;

public abstract class Animal implements AnimalItem<Animal> , Serializable {

    protected int id;
    protected AnimalSpecies animalSpecies;
    protected String name;
    protected LocalDate birthDay;
    protected List <String> commands;
    protected String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
