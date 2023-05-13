
public class Converter { //убрать лишние строки V
    float convertStepsToKM(int steps) {
        return Math.round(steps * 75 / 100000.0);//скобки не нужны ; V  нам интересно округление, а не целое от деления, как вариант можно добавить множители как константы. V
    }

    int convertStepsToKilokalories(int steps) {
        double constKilokalories = 5 / 100.0;
        return (int) Math.round((steps * constKilokalories));
    }

}
