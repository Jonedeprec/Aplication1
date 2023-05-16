
public class Converter { 
    
    int convertStepsToKM(int steps) {//метод должен возвращать int
        return (int)(steps * 0.00075);//ты неправильно понял: округление должно быть автоматическим при помощи явного преобразования типов, а также лучше сделать
    }//число 0.00075 вместо деления V

    int convertStepsToKilokalories(int steps) {
        return (int) (steps * 0.05);//то же, что и выше V
    }

}
