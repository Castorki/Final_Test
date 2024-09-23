package Code.View;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Code.Model.Animals.AnimalSpecies;
import Code.Presenter.*;

public class ConsoleUI implements View{

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Presenter presenter;
    private boolean work;
    private Scanner scanner;
    private MainMenu menu;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
        presenter = new Presenter(this);
    }


    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }

    }

    public void addAnimal(){
        System.out.println("Введите название вида животного: ");
        AnimalSpecies species = AnimalSpecies.valueOf(scanner.nextLine());
        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения животного (yyyy-MM-dd): ");
        LocalDate birthDay = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите команды, которые знает животное: ");
        String[] commands = scanner.nextLine().split("\\s*,\\s*");
        presenter.addAnimal(species, name, birthDay, List.of(commands));
    }

    public void removeAnimal(){
        System.out.println("Введите id животного для удаления: ");
        int idAnimal = Integer.parseInt(scanner.nextLine());
        presenter.removeAnimal(idAnimal);
    }

    public void getAnimalList(){
        presenter.getAnimalList();
    }

    public void finish() {
        System.out.println("До свидания!");
        work = false;
    }

    public void hello(){
        System.out.println("Здравствуйте!");
    }

    public void printMenu(){
        System.out.println(menu.menu());
    }

    public void execute(){
        String choice = scanner.nextLine();
        if(CheckTextForIntParse(choice)){
            int number = Integer.parseInt(choice);
            if (CheckValuableCommand(number)){
                menu.execute(number);
            }
        }
    }

    public boolean CheckTextForIntParse(String text){
        if(text.matches("[0-9]+")){
            return true;
        }
        else{
            inputError();
            return false;
        }
    }

    public boolean CheckValuableCommand(int number){
        if(number <= menu.getSize()){
            return true;
        }
        else{
            inputError();
            return false;
        }
    }

    public void inputError(){
        System.out.println(INPUT_ERROR);
    }
}
