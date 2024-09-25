package Code.Model.Service;

import Code.Model.AnimalList.AnimalList;
import Code.Model.Animals.*;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private final AnimalList<Animal> service;
    private final AnimalList<PetAnimal> petAnimals;
    private final AnimalList<PackAnimal> packAnimals;
    private int idAnimal;

    public Service() {
        service = new AnimalList<>();
        petAnimals = new AnimalList<>();
        packAnimals = new AnimalList<>();
    }


    public void addPetAnimal(String status, AnimalSpecies species, String name, LocalDate birthDay, List<String> commands) {
        PetAnimal animal = new PetAnimal(status, species, name, birthDay, commands);
        petAnimals.addAnimal(animal);
        service.addAnimal(animal);
    }

    public void addPackAnimal(String status, AnimalSpecies species, String name, LocalDate birthDay, List<String> commands) {
        PackAnimal animal = new PackAnimal(status, species, name, birthDay, commands);
        packAnimals.addAnimal(animal);
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

    public void addAnimalCommand(int idAnimal, String command) {
        Animal animal = getAnimalById(idAnimal);
        animal.getCommands().add(command);
    }

    public void removeAnimalCommand(int idAnimal, String command) {
        Animal animal = getAnimalById(idAnimal);
        animal.getCommands().remove(command);
    }

    public void updateName(String name, int idAnimal){
        Animal animal = getAnimalById(idAnimal);
        animal.setName(name);
    }

    public void updateBirthday(LocalDate birthday, int idAnimal){
        Animal animal = getAnimalById(idAnimal);
        animal.setBirthDay(birthday);
    }

    public void updateAnimalSpecies(AnimalSpecies animalSpecies , int idAnimal){
        Animal animal = getAnimalById(idAnimal);
        animal.setAnimalSpecies(animalSpecies);
    }

    public void updateAnimalClass(String newClass, int idAnimal) {
        Animal animal = getAnimalById(idAnimal);
        animal.setStatus(newClass);
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByAge(){
        service.sortByAge();
    }
    public String sortByClass(String className){
        StringBuilder stringBuilder = new StringBuilder();
        for (Animal animal : service){
            String status = animal.getStatus();
            if(status.equals(className)){
                stringBuilder.append(animal);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    };

    public void getAnimalInfo(int idAnimal){
        Animal animal = getAnimalById(idAnimal);
        System.out.println(animal + "\n");
    }


    public void showCommands(int idAnimal) {
        Animal animal = getAnimalById(idAnimal);
        System.out.println("Команды животного: " + animal.getAnimalCommands());
    }
}
