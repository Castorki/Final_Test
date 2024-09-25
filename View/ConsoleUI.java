package Code.View;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Code.Model.Animals.AnimalSpecies;
import Code.Presenter.*;

public class ConsoleUI implements View{

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private final Presenter presenter;
    private boolean work;
    private final Scanner scanner;
    private final MainMenu menu;
    private final ParametersMenu parameters;
    private boolean update;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
        presenter = new Presenter(this);
        parameters = new ParametersMenu(this);
        update = true;
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

    public void addAnimal() {
        System.out.println("Введите название вида животного: ");
        AnimalSpecies species = AnimalSpecies.valueOf(scanner.nextLine());
        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения животного (yyyy-MM-dd): ");
        LocalDate birthDay = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите команды, которые знает животное: ");
        String[] commands = scanner.nextLine().split("\\s*,\\s*");
        System.out.println("К какому классу отнести данное животное: домашнее (pet) или вьючное (pack): ");
        String className = scanner.nextLine();
        if (className.equals("домашнее") || className.equals("pet")) {
            presenter.addPetAnimal(className, species, name, birthDay, List.of(commands));
        } else if (className.equals("вьючное") || className.equals("pack")) {
            presenter.addPackAnimal(className, species, name, birthDay, List.of(commands));
        }
    }

    public void removeAnimal(){
        System.out.println("Введите id животного для удаления: ");
        int idAnimal = Integer.parseInt(scanner.nextLine());
        presenter.removeAnimal(idAnimal);
    }

    public void updateAnimal(){
        update = true;
        int idAnimal = getAnimalInfo();
        while (update){
            System.out.println("Какой параметр хотите обновить: ");
            printParametersMenu();
            String choice = scanner.nextLine();
            if (CheckTextForIntParse(choice)) {
                int number = Integer.parseInt(choice);
                if (CheckValuableParameter(number)) {
                    parameters.execute(number, idAnimal);
                }
            }
        }
    }

    public void updateCommands(int idAnimal){
        System.out.println("Вы хотите удалить (delete) или добавить (add) команду: ");
        String choice = scanner.nextLine();
        if(choice.equals("добавить") || choice.equals("add")){
            addCommand(idAnimal);
        }
        if(choice.equals("удалить") || choice.equals("delete")) {
            removeCommand(idAnimal);
        }
    }


    public int getAnimalInfo(){
        System.out.println("Введите id животного для получения информации: ");
        int idAnimal = Integer.parseInt(scanner.nextLine());
        presenter.getAnimalInfo(idAnimal);
        return idAnimal;
    }

    public void updateAnimalName(int idAnimal){
        System.out.println("Введите новое имя животного: ");
        String newName = scanner.nextLine();
        presenter.updateName(newName, idAnimal);
    }

    public void updateAnimalBirthday(int idAnimal){
        System.out.println("Введите новую дату рождения животного: ");
        LocalDate newBirthday = LocalDate.parse(scanner.nextLine());
        presenter.updateBirthday(newBirthday, idAnimal);
    }

    public void updateAnimalSpecies(int idAnimal){
        System.out.println("Введите новый вид животного: ");
        AnimalSpecies animalSpecies = AnimalSpecies.valueOf(scanner.nextLine());
        presenter.updateAnimalSpecies(animalSpecies, idAnimal);
    }

    public void updateAnimalClass(int idAnimal){
        System.out.println("Введите новый класс животного: ");
        String newClass = scanner.nextLine();
        presenter.updateAnimalClass(newClass, idAnimal);
    }

    public void addCommand(int idAnimal){
        System.out.println("Введите новую команду для животного: ");
        String newCommand = scanner.nextLine();
        presenter.addCommand(newCommand, idAnimal);
    }

    public void removeCommand(int idAnimal) {
        System.out.println("Введите команду, которую хотите удалить: ");
        String command = scanner.nextLine();
        presenter.removeCommand(command, idAnimal);
    }

    public void showCommands(){
        int idAnimal = getAnimalInfo();
        presenter.showCommands(idAnimal);
    }

    public void getAnimalList(){
        presenter.getAnimalList();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void sortByClass(){
        System.out.println("Животных какого класса вы хотите увидеть: ");
        String className = scanner.nextLine();
        presenter.sortByClass(className);
    }
    public void finish() {
        System.out.println("До свидания!");
        work = false;
    }

    public void endUpdating(){
        System.out.println("Обновление завершено!");
        update = false;
    }

    public void hello(){
        System.out.println("Здравствуйте!");
    }

    public void printMenu(){
        System.out.println(menu.menu());
    }

    public void printParametersMenu(){
        System.out.println(parameters.parametersMenu());
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
    public boolean CheckValuableParameter(int number){
        if(number <= parameters.getSize()){
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
