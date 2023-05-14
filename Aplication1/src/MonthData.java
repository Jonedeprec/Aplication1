public class MonthData {

    int[] days = new int[30];
    
    void printDaysAndStepsFromMonth() {

        for (int i = 0; i < 30; i++) {
            if (i + 1 < 10) {//условие с одинаковыми блоками if и else УСЛОВИЕ ВСЕ ЕЩЕ С ОДИНАКОВЫМИ БЛОКАМИ if else ИСПРАВИТЬ!
                System.out.println(i + 1 + "  день : " + days[i]);
            } else {
                System.out.println(i + 1 + " день : " + days[i]);
            }
        }

    }

    int sumStepsFromMonth() {
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum += days[i];
        }
        return sum;
    }

    int maxSteps() {
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
        }//не понял зачем 
        это условие
        for (int i = 1; i < 30; i++) {
            if (counter > max)
                max = counter;
            if (days[i] >= goal && (days[i + 1] >= goal || days[i - 1] >= goal)) {//условие реализовано неверно, например если лучшая серия 1, то у тебя ее не выведет
                //А еще будет выход за границы на последнем элементе. Подсказка: можно проверять просто, что превышена цель и внутри блока сохранять серию эсли она больше
                counter += 1;
            } else {
                counter = 0;
            }
        }
        return max;
    }


}
