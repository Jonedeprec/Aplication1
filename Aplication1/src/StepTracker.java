import java.util.Scanner;

public class StepTracker {

    Converter converter = new Converter();
    MonthData[] monthToData = new MonthData[12];
    Scanner scan;
    int goalByStepsPerDay;
    int steps;

    StepTracker(Scanner scan) {

        this.scan = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        goalByStepsPerDay = 10000;

    }

    void changeStepGoal() {
        System.out.println("Введите новую цель шагов :");
        int newGoal = scan.nextInt();
        if (newGoal <= 0) {
            System.out.println("Не удалось поставить новую цель, цель = " + goalByStepsPerDay);
        } else {
            goalByStepsPerDay = newGoal;
            System.out.println("Теперь ваша новая цель по шагам в день = " + newGoal);
        }

    }

    void addNewNumbersStepsPerDay() {

        System.out.println("Введите месяц");
        int month = scan.nextInt();
        if (month >= 1 && month <= 12) {
        } else {
            System.out.println("Месяц введен неверно");
            return;
        }
        System.out.println("Введите день");
        int days = scan.nextInt();
        if (days >= 1 && days <= 30) {
        } else {
            System.out.println("День введен неверно");
            return;
        }
        System.out.println("Введите количесвто шагов");
        int steps = scan.nextInt();
        if (steps >= 0) {
            monthToData[month - 1].days[days - 1] = steps;
            System.out.println(monthToData[month - 1].days[days - 1]);
        } else {
            System.out.println("Количество шагов неверно");

        }


    }

    void printStatistic() {
        System.out.println("Введите номер месяца для получения статистики");

        int numberMonth = scan.nextInt();

        if (numberMonth >= 1 && numberMonth <= 12) {

            System.out.println("Количество пройденных шагов по дням : ");

            monthToData[numberMonth-1].printDaysAndStepsFromMonth();

            System.out.println("Максимальное количество шагов за месяц : ");

            monthToData[numberMonth-1].maxSteps();

            System.out.println("Общее количество шагов за месяц : " +  monthToData[numberMonth-1].sumStepsFromMonth());

            System.out.println("Количество сожженых каллорий : ");

            converter.convertStepsToKilokalories(steps);

            System.out.println("Вы прошли " + converter.convertStepsToKM(steps) + " киллометров ");

            System.out.println("Лучшая серия : " + monthToData[numberMonth-1].bestSeries(goalByStepsPerDay));



        } else {
            System.out.println("Месяц введен неверно");
        }
    }

}