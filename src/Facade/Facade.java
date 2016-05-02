package Facade;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * https://ru.wikipedia.org/wiki/Фасад_(шаблон_проектирования)
 */
//Это шаблон, который позволяет скрыть сложность системы
public class Facade {
    public static void main(String[] args) {

      Computer computer= new Computer();
        computer.copy();

    }
}

// По-сути это и есть фасад
class Computer{

    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();

    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}

class Power{
    void on(){
        System.out.println("Включение питания");
    }
    void oаа(){
        System.out.println("Выключение питания");
    }
}

class DVDRom{
    private boolean data=false;
    public boolean hasData(){
        return data;
    }

    void load(){
        data=true;
    }
    void unload(){
        data=false;
    }
}

class HDD{
    void copyFromDVD(DVDRom dvdRom){
        if(dvdRom.hasData()){
            System.out.println("Происходит копирование данных с диска");
        }
        else
        {
            System.out.println("Вставьте диск с данными");
        }
    }
}
