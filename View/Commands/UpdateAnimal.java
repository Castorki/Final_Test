package Code.View.Commands;

import Code.View.ConsoleUI;

public class UpdateAnimal extends Command{

    public UpdateAnimal(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Обновить данные животного";
    }
    @Override
    public void execute() {
        consoleUI.updateAnimal();
    }
}
