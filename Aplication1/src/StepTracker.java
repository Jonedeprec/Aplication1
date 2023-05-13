import java.util.Scanner;

public class StepTracker {

    MonthData[] monthToData;
    Converter converter;//инициализацию необходимо перенести в конструктор, чтобы не создавались объекты без вызова конструктора V
    Scanner scan;
    int goalByStepsPerDay;

    //Зачем эта переменная, она ни чем не заполняется по ходу программы и передается в методы V
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
            newGoal = scan.nextInt();//лучше сделать do-while, чтобы добиться правильного введения цели V

        } while (newGoal <= 0);
        goalByStepsPerDay = newGoal;
        System.out.println("Теперь ваша новая цель по шагам в день = " + newGoal);
    }

    void addNewNumbersStepsPerDay() {
        //считывание месяца и дня лучше вынести в отдельные методы,V
        int month = getMonth(scan);
        int days = getDay(scan);
        int steps = getSteps(scan);//переменная названа также, как глобальная V
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
            monthToData[numberMonth - 1].printDaysAndStepsFromMonth();

            System.out.print("Максимальное количество шагов за месяц : ");
            System.out.println(monthToData[numberMonth - 1].maxSteps());   //не выводится V

            System.out.println("Общее количество шагов за месяц : " + monthToData[numberMonth - 1].sumStepsFromMonth());

            System.out.print("Количество сожженных калорий : ");
            System.out.println(converter.convertStepsToKilokalories(monthToData[numberMonth - 1].sumStepsFromMonth()));//не выводится V

            System.out.println("Вы прошли : " + converter.convertStepsToKM(monthToData[numberMonth - 1].sumStepsFromMonth()) + " километров ");//передается steps, который ничего не содержит V
            System.out.println("Лучшая серия : " + monthToData[numberMonth - 1].bestSeries(goalByStepsPerDay));

            System.out.print("Среднее количество шагов : ");
            System.out.println(monthToData[numberMonth - 1].sumStepsFromMonth() / 30);   //нет вывода среднего количества шагов V

        } else {
            System.out.println("Месяц введен неверно");
        }
    }

    public static int getMonth(Scanner scan) {
        int month = 0;//так повысится читаемость и не нарушится область ответственности метода
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
            days = scan.nextInt();//необходимо добиться введения правильного дня, можно использовать do-while V
        } while (!(days >= 1 && days <= 30));
        return days;
    }
    public static int getSteps (Scanner scan){
        int steps = 0;
        do { System.out.println("Введите количество шагов");
             steps = scan.nextInt();
        } while (steps <=0);
        return steps;
    }
}
