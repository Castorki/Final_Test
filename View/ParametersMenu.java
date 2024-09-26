package Code.View;

import Code.View.Parameters.*;

import java.util.ArrayList;
import java.util.List;

public class ParametersMenu {
    private final List<Parameter> parametersList;

    public ParametersMenu(ConsoleUI consoleUI){
        parametersList = new ArrayList<>();
        parametersList.add(new UpdateName(consoleUI));
        parametersList.add(new UpdateBirthday(consoleUI));
        parametersList.add(new UpdateAnimalSpecies(consoleUI));
        parametersList.add(new UpdateAnimalClass(consoleUI));
        parametersList.add(new UpdateCommands(consoleUI));
        parametersList.add(new EndUpdating(consoleUI));
    }

    public String parametersMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < parametersList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(parametersList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice, int idAnimal) {
        Parameter parameter = parametersList.get(choice -1);
        parameter.execute(idAnimal);
    }

    public int getSize() {
        return parametersList.size();
    }


}
