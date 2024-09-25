package Code.View.Commands;

import Code.View.ConsoleUI;

public class SortByClass extends Command{

    public SortByClass(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать животных по конкретному классу";
    }

    @Override
    public void execute() {
        consoleUI.sortByClass();
    }
}
