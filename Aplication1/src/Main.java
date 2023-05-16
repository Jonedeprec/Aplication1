import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepInput = new StepTracker(scanner);
        while (true) {
            printMenu();
            int numberMenu = scanner.nextInt();
            switch (numberMenu) {
                case 1: //Фигурные скобки в кейсах не нужны, код выполняется до ближайшего брейка V
                    stepInput.addNewNumbersStepsPerDay();
                    break;

                case 2:
                    stepInput.changeStepGoal();
                    break;

                case 3:
                    stepInput.printStatistic();
                    break;

                case 4:
                    scanner.close();
                    return;

                default:
                    System.out.println("Такой команды нет");
                    //в default break не нужен, так как после него не может быть других кейсов V

            }
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
