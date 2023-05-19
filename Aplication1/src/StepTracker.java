import java.util.Scanner;

public class StepTracker {

    MonthData[] monthToData;
    Converter converter;
    Scanner scan;
    int goalByStepsPerDay;



    StepTracker(Scanner scan) {
        monthToData = new MonthData[12];
        converter = new Converter();
        this.scan = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        goalByStepsPerDay = 10000;
    }

    void changeStepGoal() {
        int newGoal = 0;
        do {
            System.out.println("Введите новую цель шагов :");
            newGoal = scan.nextInt();
        } while (newGoal <= 0);
        goalByStepsPerDay = newGoal;
        System.out.println("Теперь ваша новая цель по шагам в день = " + newGoal);
    }

    void addNewNumbersStepsPerDay() {
        int month = getMonth(scan);
        int days = getDay(scan);
        int steps = getSteps(scan);
        monthToData[month - 1].days[days - 1] = steps;
        System.out.println("Введенное количество шагов : " + monthToData[month - 1].days[days - 1]);
    }

    void printStatistic() {

        System.out.println("Введите номер месяца для получения статистики");
        int numberMonth = getMonth(scan);
        int rezultOfSumSteps = monthToData[numberMonth - 1].sumStepsFromMonth();
        System.out.println("Количество пройденных шагов по дням : ");
        monthToData[numberMonth - 1].printDaysAndStepsFromMonth();

        System.out.print("Максимальное количество шагов за месяц : ");
        System.out.println(monthToData[numberMonth - 1].maxSteps());

        System.out.println("Общее количество шагов за месяц : " + rezultOfSumSteps);

        System.out.print("Количество сожженных калорий : ");
        System.out.println(converter.convertStepsToKilokalories(rezultOfSumSteps));

        System.out.println("Вы прошли : " + converter.convertStepsToKM(rezultOfSumSteps) + " километров ");
        System.out.println("Лучшая серия : " + monthToData[numberMonth - 1].bestSeries(goalByStepsPerDay));

        System.out.print("Среднее количество шагов : ");
        System.out.println(rezultOfSumSteps / 30);
    }

    public static int getMonth(Scanner scan) {
        int month = 0;
        do {
            System.out.println("Введите месяц от 1 до 12 ");
            month = scan.nextInt();
        } while (!(month >= 1 && month <= 12));
        return month;
    }

    public static int getDay(Scanner scan) {
        int days = 0;
        do {
            System.out.println("Выберете день от 1 до 30");
            days = scan.nextInt();
        } while (!(days >= 1 && days <= 30));
        return days;
    }

    public static int getSteps(Scanner scan) {
        int steps = 0;
        do {
            System.out.println("Введите количество шагов");//некрасиво писать на одной строке V
            steps = scan.nextInt();
        } while (steps <= 0);
        return steps;
    }
}
