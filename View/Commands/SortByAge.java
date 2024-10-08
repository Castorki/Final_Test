package Code.View.Commands;

import Code.View.ConsoleUI;

public class SortByAge extends Command{

    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать по возрасту";
    }

    @Override
    public void execute() {
        consoleUI.sortByAge();
    }
}
