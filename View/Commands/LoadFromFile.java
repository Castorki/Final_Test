package Code.View.Commands;

import Code.View.ConsoleUI;

public class LoadFromFile extends Command{
    public LoadFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить данные из файла";
    }
    @Override
    public void execute() {
        consoleUI.loadFromFile();
    }
}
