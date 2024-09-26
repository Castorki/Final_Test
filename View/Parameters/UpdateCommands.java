package Code.View.Parameters;

import Code.View.ConsoleUI;

public class UpdateCommands extends Parameter{

    public UpdateCommands(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Обновить список команд животного";
    }

    @Override
    public void execute(int idAnimal) {
        consoleUI.updateCommands(idAnimal);
    }
}
