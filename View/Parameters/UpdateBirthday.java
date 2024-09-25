package Code.View.Parameters;

import Code.View.ConsoleUI;

public class UpdateBirthday extends Parameter{

    public UpdateBirthday(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Изменить дату рождения";
    }

    @Override
    public void execute(int idAnimal) {
        consoleUI.updateAnimalBirthday(idAnimal);
    }
}
