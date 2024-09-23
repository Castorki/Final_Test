package Code.View.Commands;

import Code.View.ConsoleUI;

public class GetAnimalList extends Command {

    public GetAnimalList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список животных";
    }


    @Override
    public void execute() {
        consoleUI.getAnimalList();
    }

}
