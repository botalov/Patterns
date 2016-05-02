package FactoryMethod;

import java.util.Date;

/**
 * https://ru.wikipedia.org/wiki/%D0%A4%D0%B0%D0%B1%D1%80%D0%B8%D1%87%D0%BD%D1%8B%D0%B9_%D0%BC%D0%B5%D1%82%D0%BE%D0%B4_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
 */
public class FactoryMethod {
    public static void main(String[] args) {
        WatchMaker watchMaker;
        watchMaker = new DigitalWatchMaker();
        //watchMaker = new RomeWatchMaker();

        Watch watch = watchMaker.createWatch();
        watch.showTime();
    }
}

// Часы
interface Watch{
    void showTime();
}
// Электронные часы
class DigitalWatch implements Watch{
    @Override
    public void showTime(){
        System.out.println(new Date());
    }
}
// Римские часы
class RomeWatch implements Watch{
    @Override
    public void showTime(){
        System.out.println("VII-XX");
    }
}

// Это абстракция завода по производстыу часов
interface WatchMaker{
    Watch createWatch();
}
// Конвейер, на котором производят электронные часы
class DigitalWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
// Конвейер, на котором производят римские часы
class RomeWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}

