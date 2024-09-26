package Code.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

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
    private boolean validDate;



    public ConsoleUI(){
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
        presenter = new Presenter(this);
        parameters = new ParametersMenu(this);
        update = true;
        validDate = false;
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

    public void hello(){
        System.out.println("Здравствуйте!\n");
    }

    public void addAnimal() {

        System.out.println("Введите название вида животного: ");
        AnimalSpecies species = checkTextForAnimalSpeciesParse(validDate);
        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения животного (yyyy-MM-dd): ");
        LocalDate birthDay = checkTextForLocalDateParse(validDate);
        System.out.println("Введите команды, которые знает животное: ");
        String[] commands = scanner.nextLine().split("\\s*,\\s*");
        System.out.println("К какому классу отнести данное животное: домашнее (pet) или вьючное (pack): ");
        while (!validDate) {
            String className = scanner.nextLine();
            if (className.equals("домашнее") || className.equals("pet")) {
                presenter.addPetAnimal(className, species, name, birthDay, List.of(commands));
                validDate = true;
            } else if (className.equals("вьючное") || className.equals("pack")) {
                presenter.addPackAnimal(className, species, name, birthDay, List.of(commands));
                validDate = true;
            } else {
                inputError();
            }
        }
        presenter.addCounter();
    }

    public void removeAnimal(){
        System.out.println("Введите id животного для удаления: ");
        int idAnimal = Integer.parseInt(scanner.nextLine());
        if(checkId(idAnimal)){
            presenter.removeAnimal(idAnimal);
        }
    }

    public void updateAnimal(){
        update = true;
        int idAnimal = getAnimalInfo();
        while (update){
            System.out.println("Какой параметр хотите обновить: ");
            printParametersMenu();
            String choice = scanner.nextLine();
            if (checkTextForIntParse(choice)) {
                int number = Integer.parseInt(choice);
                if (checkValuableParameter(number)) {
                    parameters.execute(number, idAnimal);
                }
            }
        }
    }

    public void updateCommands(int idAnimal){
        System.out.println("Вы хотите удалить (delete) или добавить (add) команду: ");
        String choice = scanner.nextLine();
        while (!validDate) {
            if (choice.equals("добавить") || choice.equals("add")) {
                addCommand(idAnimal);
                validDate = true;
            } else if (choice.equals("удалить") || choice.equals("delete")) {
                removeCommand(idAnimal);
                validDate = true;
            } else {
                inputError();
            }
        }
    }


    public int getAnimalInfo(){
        System.out.println("Введите id животного для получения информации: ");
        int idAnimal = Integer.parseInt(scanner.nextLine());
        if(checkId(idAnimal)){
            presenter.getAnimalInfo(idAnimal);
            return idAnimal;
        }
        return -1;
    }

    public void updateAnimalName(int idAnimal){
        System.out.println("Введите новое имя животного: ");
        String newName = scanner.nextLine();
        presenter.updateName(newName, idAnimal);
    }

    public void updateAnimalBirthday(int idAnimal){
        System.out.println("Введите новую дату рождения животного: ");
        LocalDate newBirthday = checkTextForLocalDateParse(validDate);
        presenter.updateBirthday(newBirthday, idAnimal);
    }

    public void updateAnimalSpecies(int idAnimal){
        System.out.println("Введите новый вид животного: ");
        AnimalSpecies animalSpecies = checkTextForAnimalSpeciesParse(validDate);
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
        if(checkCommands(idAnimal, command)){
            presenter.removeCommand(command, idAnimal);
            presenter.minusCounter();
        }
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

    public void endUpdating(){
        System.out.println("Обновление завершено!");
        update = false;
    }

    public void finish() {
        System.out.println("До свидания!");
        work = false;
    }

    public void printMenu(){
        System.out.println("Количесво животных в питомнике: " + presenter.getCount() + "\n");
        System.out.println(menu.menu());
    }

    public void printParametersMenu(){
        System.out.println(parameters.parametersMenu());
    }

    public void execute(){
        String choice = scanner.nextLine();
        if(checkTextForIntParse(choice)){
            int number = Integer.parseInt(choice);
            if (checkValuableCommand(number)){
                menu.execute(number);
            }
        }
    }

    public boolean checkTextForIntParse(String text){
        if(text.matches("[0-9]+")){
            return true;
        }
        else{
            inputError();
            return false;
        }
    }

    public LocalDate checkTextForLocalDateParse(boolean validDate){
        while (!validDate) {
            String input = scanner.nextLine();

            try {
                LocalDate birthDate = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                validDate = true;
                return birthDate;
            } catch (DateTimeParseException e) {
                System.err.println("Неверное значение. Введите дату в формате yyyy-MM-dd.");
            }
        }
        return null;
    }

    public AnimalSpecies checkTextForAnimalSpeciesParse(boolean validDate){
        List<String> s = List.of("Cat", "Dog", "Hamster", "Horse", "Camel", "Donkey");
        while (!validDate) {
                String input = scanner.nextLine();
                try {
                    AnimalSpecies spicy = AnimalSpecies.valueOf(input.formatted(s));
                    validDate = true;
                    return spicy;
                }
                catch (IllegalArgumentException e){
                    System.err.println("""
                            Неверное значение. Введите данные из списка ниже: Cat,
                                Dog,
                                Hamster,
                                Horse,
                                Camel,
                                Donkey""");
                }
        }
        return null;
    }

    public boolean checkCommands(int idAnimal, String command){
        String commands = presenter.getAnimalCommands(idAnimal);
            if(commands.contains(command)){
                return true;
            }
            else {
                inputError();
                return false;
            }
    }

    public boolean checkValuableCommand(int number){
        if(number <= menu.getSize()){
            return true;
        }
        else{
            inputError();
            return false;
        }
    }
    public boolean checkValuableParameter(int number){
        if(number <= parameters.getSize()){
            return true;
        }
        else{
            inputError();
            return false;
        }
    }

    public boolean checkId(int number){
        if(number <= presenter.getAnimalisticSize()){
            return true;
        }
        else{
            inputError();
            return false;
        }
    }



    public void inputError(){
        System.out.println(INPUT_ERROR + "\n");
    }


}
