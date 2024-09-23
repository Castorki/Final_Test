package Code.View.Commands;

import Code.View.ConsoleUI;

public class RemoveAnimal extends Command{

    public RemoveAnimal(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Удалить животное";
    }

    @Override
    public void execute() {
        consoleUI.removeAnimal();
    }
    
}
