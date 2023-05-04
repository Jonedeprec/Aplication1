public class MonthData {

    int[] days = new int[30];
    int day = 0;//зачем переменная?


    void printDaysAndStepsFromMonth() {

        for (int i = 0; i < 30; i++) {

            day = i + 1;//зачем сохранять это значение

            if (day < 10) {//условие с обинаковыми блоками if и else
                System.out.println(day + " день : " + days[i]);//здесь вместо day i + 1
            } else {
                System.out.println(day + " день : " + days[i]);
            }
        }

    }
    int sumStepsFromMonth(){//метод реализован верно
        int sum = 0;
        for (int i = 0; i < 30; i++) {
//лишняя строка
            sum += days[i];
        }
        return sum;
    }//между методами пустая строка должна быть
    int maxSteps (){//метод реализован верно
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if( maxSteps < days[i]){
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goal){//метод реализован неверно: лучшая серия - цепочка из подряд идущих дней, с выполненной целью
                             //ты же считаешь просто все дни, когда была выполнена цель
        int counter = 0;
        for (int i = 0; i < 30; i++) {
            if(days[i] >= goal ){
                counter += 1;
            }
        }

        return counter;
    }



}
