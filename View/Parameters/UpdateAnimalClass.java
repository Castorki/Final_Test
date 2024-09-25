package Code.View.Parameters;

import Code.View.ConsoleUI;

public class UpdateAnimalClass extends Parameter{

    public UpdateAnimalClass(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Обновить класс животного";
    }


    @Override
    public void execute(int idAnimal) {
        consoleUI.updateAnimalClass(idAnimal);
    }
}
