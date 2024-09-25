package Code.View.Parameters;

import Code.View.ConsoleUI;

public class UpdateName extends Parameter{

    public UpdateName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Обновить имя";
    }
    @Override
    public void execute(int idAnimal) {
        consoleUI.updateAnimalName(idAnimal);
    }
}
