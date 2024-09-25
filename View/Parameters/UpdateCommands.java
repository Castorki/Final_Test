package Code.View.Parameters;

import Code.View.ConsoleUI;

import java.util.Scanner;

public class UpdateCommands extends Parameter{
    private Scanner scanner;

    public UpdateCommands(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Обновить список команд животного";
    }

    @Override
    public void execute(int idAnimal) {
        consoleUI.updateCommands(idAnimal);
    }
}
