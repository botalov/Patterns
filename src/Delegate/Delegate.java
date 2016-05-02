package Delegate;

/**
 * https://ru.wikipedia.org/wiki/%D0%A8%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%B4%D0%B5%D0%BB%D0%B5%D0%B3%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F
 */
public class Delegate {

    public static void main(String[] args) {

        Painter painter = new Painter();
        painter.setGraphics(new Circle());
        painter.draw();

        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Triangle());
        painter.draw();

    }
}


interface Graphics{
    void draw();
}

class Triangle implements Graphics{

    @Override
    public void draw() {
        System.out.println("рисуем треугольник");
    }
}

class Circle implements Graphics{

    @Override
    public void draw() {
        System.out.println("рисуем круг");
    }
}

class Square implements Graphics{

    @Override
    public void draw() {
        System.out.println("рисуем квадрат");
    }
}

class Painter
{
    Graphics graphics;
    void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    void draw(){
        if(graphics!=null)
            this.graphics.draw();
    }
}