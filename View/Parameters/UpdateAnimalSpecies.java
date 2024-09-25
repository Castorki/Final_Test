package Code.View.Parameters;

import Code.View.ConsoleUI;

public class UpdateAnimalSpecies extends Parameter{
    public UpdateAnimalSpecies(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Изменить вид животного";
    }
    @Override
    public void execute(int idAnimal) {
        consoleUI.updateAnimalSpecies(idAnimal);
    }
}
