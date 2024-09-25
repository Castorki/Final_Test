package Code.View.Parameters;

import Code.View.ConsoleUI;

public class EndUpdating extends Parameter{

    public EndUpdating(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Закончить редактирование";
    }

    @Override
    public void execute(int idAnimal) {
        consoleUI.endUpdating();
    }

}
