public class MonthData {

    int[] days = new int[30];
    
    void printDaysAndStepsFromMonth() {

        for (int i = 0; i < 30; i++) {
            if (i + 1 < 10) {
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

    int bestSeries(int goal) {
        int max = 0;
        int counter = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] >= goal) {
                counter += 1;
            } else {
                counter = 0;
            }
            if (counter > max)
                max = counter;
        }
        return max;
    }
}
