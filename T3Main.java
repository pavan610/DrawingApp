public class T3Main {
    public static void main(String[] args) {

        Window window = new Window(25,35,'*');

        Rectangle rectangle = new Rectangle(7,14,10,7,'=');
        window.addShape(rectangle);

        Line line = new Line(9,9,4,0,1,'*');
        window.addShape(line);

        Line line1 = new Line(9,22,4,0,1,'*');
        window.addShape(line1);

        Line line2 = new Line(18,15,4,1,0,'*');
        window.addShape(line2);

        Line line3 = new Line(18,20,4,1,0,'*');
        window.addShape(line3);

        Circle circle = new Circle(4,17,3,'o');
        window.addShape(circle);

        Triangle triangle = new Triangle(22,15,1,1,0,'^');
        window.addShape(triangle);

        Triangle triangle2 = new Triangle(22,20,1,1,0,'^');
        window.addShape(triangle2);

        Text text = new Text(24,14,"ROBOT !!",0,1);
        window.addShape(text);

        window.display();
        window.writeSpecToFile("T3Drawing.txt");
        System.out.println("Writing to T3Drawing.txt Successfully Completed!");
    }
}
