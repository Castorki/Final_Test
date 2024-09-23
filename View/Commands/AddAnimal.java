package Code.View.Commands;

import Code.View.ConsoleUI;

public class AddAnimal extends Command{

    public AddAnimal(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить животное";
    }

    @Override
    public void execute() {
        consoleUI.addAnimal();;
    }
    
}
