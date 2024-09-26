package Code.View.Commands;

import Code.View.ConsoleUI;

public class SaveToFile extends Command{
    public SaveToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить данные в файл";
    }

    @Override
    public void execute() {
        consoleUI.saveToFile();
    }
}
