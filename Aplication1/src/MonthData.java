public class MonthData {

    int[] days = new int[30];
    int day = 0;


    void printDaysAndStepsFromMonth() {

        for (int i = 0; i < 30; i++) {

            day = i + 1;

            if (day < 10) {
                System.out.println(day + " день : " + days[i]);
            } else {
                System.out.println(day + " день : " + days[i]);
            }
        }

    }
    int sumStepsFromMonth(){
        int sum = 0;
        for (int i = 0; i < 30; i++) {

            sum += days[i];
        }
        return sum;
    }
    int maxSteps (){
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if( maxSteps < days[i]){
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goal){

        int counter = 0;
        for (int i = 0; i < 30; i++) {
            if(days[i] >= goal ){
                counter += 1;
            }
        }

        return counter;
    }



}