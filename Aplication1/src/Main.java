import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        StepTracker stepInput = new StepTracker(scanner);

        while (true) {

            printMenu();
            int numberMenu = scanner.nextInt();

                if (numberMenu == 1) {

                    stepInput.addNewNumbersStepsPerDay();

                }else if (numberMenu == 2) {

                    stepInput.changeStepGoal();

                }else if (numberMenu == 3) {

                    stepInput.printStatistic();

                }else if (numberMenu == 4) {
                    scanner.close();

                    break;
                }

                System.out.println("Такой команды нет");



        }

    }

    static public void printMenu() {

        System.out.println("Выберите пункт меню, который хотите активировать");
        System.out.println("1. Введите количество шагов за любой день");
        System.out.println("2. Измените цель по количеству шагов в день");
        System.out.println("3. Напечатайте статистику за определенный месяц");
        System.out.println("4. Выйти из приложения");

    }
}