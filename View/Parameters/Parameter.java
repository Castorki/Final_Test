package Code.View.Parameters;

import Code.View.ConsoleUI;

public abstract class Parameter {
    String description;
    ConsoleUI consoleUI;

    public Parameter(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute(int idAnimal);
}
