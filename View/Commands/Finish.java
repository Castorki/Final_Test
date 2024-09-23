package Code.View.Commands;

import Code.View.ConsoleUI;

public class Finish extends Command{

    public Finish(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Закончить работу";
    }
    @Override
    public void execute() {
        consoleUI.finish();
    }
}
