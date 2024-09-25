package Code.View.Commands;

import Code.View.ConsoleUI;

public class GetAnimalInfo extends Command{
    public GetAnimalInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить информацию о животном";
    }

    @Override
    public void execute() {
        consoleUI.getAnimalInfo();
    }
}
