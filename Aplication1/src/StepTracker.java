import java.util.Scanner;

public class StepTracker {

    Converter converter = new Converter();
    MonthData[] monthToData = new MonthData[12];//инициализацию необходимо перенести в конструктор, чтобы не создавались объекты без вызова конструктора
    Scanner scan;
    int goalByStepsPerDay;
    int steps;//Зачем эта переменная, она ни чем не заполняется по ходу программы и передается в методы

    StepTracker(Scanner scan) {

        this.scan = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        goalByStepsPerDay = 10000;

    }

    void changeStepGoal() {
        System.out.println("Введите новую цель шагов :");
        int newGoal = scan.nextInt();//лучше сделать do-while, чтобы добиться правильного введения цели
        if (newGoal <= 0) {
            System.out.println("Не удалось поставить новую цель, цель = " + goalByStepsPerDay);
        } else {
            goalByStepsPerDay = newGoal;
            System.out.println("Теперь ваша новая цель по шагам в день = " + newGoal);
        }

    }

    void addNewNumbersStepsPerDay() {

        System.out.println("Введите месяц");//считывание месяца и дня лучше вынести в отдельные методы, 
        int month = scan.nextInt();         //так повысится читаемость и не нарушится область отвественности метода
        if (month >= 1 && month <= 12) {//по заданию, номер вводимого месяца должен быть от 0 до 11 включительно (см. шаг 7)
        } else {                        //В этом задании показывается, что нумерация в массивах начинается с 0
            System.out.println("Месяц введен неверно");
            return;
        }
        System.out.println("Введите день");
        int days = scan.nextInt();//необходимо добиться введения правильного дня, можно использовать do-while
        if (days >= 1 && days <= 30) {//почему блок if пустой, поправить
        } else {
            System.out.println("День введен неверно");
            return;
        }
        System.out.println("Введите количесвто шагов");//то же, что и выше
        int steps = scan.nextInt();//переменная названа также, как глобальная
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

            monthToData[numberMonth-1].maxSteps();//не выводится

            System.out.println("Общее количество шагов за месяц : " +  monthToData[numberMonth-1].sumStepsFromMonth());

            System.out.println("Количество сожженых каллорий : ");

            converter.convertStepsToKilokalories(steps);//не выводится

            System.out.println("Вы прошли " + converter.convertStepsToKM(steps) + " киллометров ");//передается steps, который ничего не содержит

            System.out.println("Лучшая серия : " + monthToData[numberMonth-1].bestSeries(goalByStepsPerDay));
//нет вывода среднего количества шагов


        } else {
            System.out.println("Месяц введен неверно");
        }
    }

}
