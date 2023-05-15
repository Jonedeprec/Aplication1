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
        if (steps >= 0) {//конструкция if else всегда будет true, так как в методе по получению шагов идет ввод до тех пор, пока не будет >0,
            monthToData[month - 1].days[days - 1] = steps;
            System.out.println(monthToData[month - 1].days[days - 1]);
        } else {//значит вывод сообщения нужно перенести туда
            System.out.println("Количество шагов неверно");
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца для получения статистики");
        int numberMonth = scan.nextInt();//вместо этого у тебя есть готовый метод для ввода месяца
        if (numberMonth >= 1 && numberMonth <= 12) {

            System.out.println("Количество пройденных шагов по дням : ");
            monthToData[numberMonth - 1].printDaysAndStepsFromMonth();

            System.out.print("Максимальное количество шагов за месяц : ");
            System.out.println(monthToData[numberMonth - 1].maxSteps());

            System.out.println("Общее количество шагов за месяц : " + monthToData[numberMonth - 1].sumStepsFromMonth());//результат работы этого метода лучше сохранить в 
//отдельную переменную и добавить ее везде, где есть вызов этого метода, чтобы оптимизировать код, так как метод вызывается несколько раз
            System.out.print("Количество сожженных калорий : ");
            System.out.println(converter.convertStepsToKilokalories(monthToData[numberMonth - 1].sumStepsFromMonth()));//тоже, что и выше

            System.out.println("Вы прошли : " + converter.convertStepsToKM(monthToData[numberMonth - 1].sumStepsFromMonth()) + " километров ");//тоже, что и выше
            System.out.println("Лучшая серия : " + monthToData[numberMonth - 1].bestSeries(goalByStepsPerDay));

            System.out.print("Среднее количество шагов : ");
            System.out.println(monthToData[numberMonth - 1].sumStepsFromMonth() / 30);//тоже, что и выше

        } else {
            System.out.println("Месяц введен неверно");
        }
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
    public static int getSteps (Scanner scan){
        int steps = 0;
        do { System.out.println("Введите количество шагов");//некрасиво писать на одной строке
             steps = scan.nextInt();
        } while (steps <=0);
        return steps;
    }
}
