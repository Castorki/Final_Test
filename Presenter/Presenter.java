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

}
