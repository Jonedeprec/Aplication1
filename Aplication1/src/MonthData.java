public class MonthData {

    int[] days = new int[30];
    //зачем переменная? V
    void printDaysAndStepsFromMonth() {

        for (int i = 0; i < 30; i++) {
            //зачем сохранять это значение V
            if (i + 1 < 10) {//условие с одинаковыми блоками if и else V
                System.out.println(i + 1 + "  день : " + days[i]);//здесь вместо day i + 1 V
            } else {
                System.out.println(i + 1 + " день : " + days[i]);
            }
        }

    }

    int sumStepsFromMonth() {//метод реализован верно
        int sum = 0;
        for (int i = 0; i < 30; i++) {//лишняя строка
            sum += days[i];
        }
        return sum;
    }

    //между методами пустая строка должна быть
    int maxSteps() {//метод реализован верно
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if (maxSteps < days[i]) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goal) {//метод реализован неверно: лучшая серия - цепочка из подряд идущих дней, с выполненной целью
        int max = 0; //ты же считаешь просто все дни, когда была выполнена цель
        int counter = 0;
        if (days[0] >= goal) {
            counter += 1;
        }
        for (int i = 1; i < 30; i++) {
            if (counter > max)
                max = counter;
            if (days[i] >= goal && (days[i + 1] >= goal || days[i - 1] >= goal)) {
                counter += 1;
            } else {
                counter = 0;
            }
        }
        return max;
    }


}
