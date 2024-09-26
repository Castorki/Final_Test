package Code.Presenter;

import java.time.LocalDate;
import java.util.List;

import Code.Model.Animals.AnimalSpecies;
import Code.Model.Service.Service;
import Code.View.View;



public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

   private void updateView() {
       String info = service.getAnimalList();
       view.printAnswer(info);
   }


    public void addPetAnimal(String status, AnimalSpecies animalSpecies, String name, LocalDate birthDay, List<String> commands){
        service.addPetAnimal(status, animalSpecies, name, birthDay, commands);
        updateView();
    }

    public void addPackAnimal(String status, AnimalSpecies animalSpecies, String name, LocalDate birthDay, List<String> commands){
        service.addPackAnimal(status, animalSpecies, name, birthDay, commands);
        updateView();
    }

   public void removeAnimal(int idAnimal){
        service.removeAnimal(idAnimal);
        updateView();
   }

   public void getAnimalList(){
    updateView();
   }

   public void sortByName(){
       service.sortByName();
       updateView();
   }

    public void sortByAge(){
        service.sortByAge();
        updateView();
    }

    public void sortByClass(String className){
        String info = service.sortByClass(className);
        view.printAnswer(info);
    }

    public void updateName(String name, int idAnimal){
        service.updateName(name, idAnimal);
        updateView();
    }

    public void updateBirthday(LocalDate birthday , int idAnimal){
        service.updateBirthday(birthday, idAnimal);
        updateView();
    }

    public void updateAnimalSpecies(AnimalSpecies animalSpecies  , int idAnimal){
        service.updateAnimalSpecies(animalSpecies, idAnimal);
        updateView();
    }

    public void getAnimalInfo(int idAnimal){
        service.getAnimalInfo(idAnimal);
    }

    public void updateAnimalClass(String newClass, int idAnimal) {
        service.updateAnimalClass(newClass, idAnimal);
        updateView();
    }

    public void addCommand(String newCommand, int idAnimal) {
        service.addAnimalCommand(idAnimal, newCommand);
        updateView();
    }

    public void removeCommand(String command, int idAnimal) {
        service.removeAnimalCommand(idAnimal, command);
        updateView();
    }

    public void showCommands(int idAnimal) {
        service.showCommands(idAnimal);
    }

    public void addCounter(){
        try {
            service.addCount();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public int getCount() {
        return service.getCount();
    }

    public int getAnimalisticSize() {
        return service.getAnimalisticSize();
    }

    public String getAnimalCommands(int idAnimal) {
        return service.getAnimalCommands(idAnimal);
    }

    public void minusCounter() {
        service.minusCount();
    }
}
