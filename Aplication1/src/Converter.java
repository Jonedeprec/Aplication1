
public class Converter { 
    
    float convertStepsToKM(int steps) {//метод должен возвращать int
        return Math.round(steps * 75 / 100000.0);//ты неправильно понял: округление должно быть автоматическим при помощи явного преобразования типов, а также лучше сделать
    }//число 0.00075 вместо деления

    int convertStepsToKilokalories(int steps) {
        double constKilokalories = 5 / 100.0;
        return (int) Math.round((steps * constKilokalories));//тоже, что и выше
    }

}
