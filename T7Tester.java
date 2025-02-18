public class T7Tester  {
    public static void main(String[] args) {
        Window window = new Window(25,30,'*');

       //oval demo
        Oval oval =  new Oval(12,15,11,7,'=');//rowBase ColBase HeightRadius WidthRadius DrawCharacter
        window.addShape(oval);

        Oval oval1 =  new Oval(10,12,3,1,'o');
        window.addShape(oval1);

        Oval oval2 =  new Oval(10,18,3,1,'o');
        window.addShape(oval2);

        Line line = new Line(19,12,6,0,1,'-');
        window.addShape(line);

        Oval oval3 =  new Oval(16,15,1,3,'^');
        window.addShape(oval3);

        window.display();

    }
}
