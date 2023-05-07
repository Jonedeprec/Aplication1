
public  class Converter{
//убрать лишние строки

    int convertStepsToKM(int steps){


        return  (steps * 75)/100000;//скобки не нужны
//нам интересно округление, а не целое от деления, как вариант можно добавить множители как константы.

    }

    int convertStepsToKilokalories(int steps){


        return  steps * 5 / 100;

    }

}
