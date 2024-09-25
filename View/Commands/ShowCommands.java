package Code.View.Commands;

import Code.View.ConsoleUI;

public class ShowCommands extends Command{

    public ShowCommands(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать все команды животного";
}

    @Override
    public void execute() {
        consoleUI.showCommands();
    }
}
