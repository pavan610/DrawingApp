import java.util.*;

public class DrawingBoard
{
	private static Scanner kb = new Scanner(System.in);
	private static Window w = null;
	private static ArrayList<Shape> shapes = null;
	private static Shape selectedShape = null;
	private static int selectedIndex = -1;

	public static void main(String [] args) throws Exception
   	{
		// Create or load a window
		// Display the window with grid added
		System.out.println("Enter the window file name (or NEW): ");
		String name = kb.nextLine().trim();
		if(name.equalsIgnoreCase("NEW"))
		{
			System.out.println(
				"Enter number of rows, number of columns and character (separated by space): " );
			int rbase = kb.nextInt();
			int cbase = kb.nextInt();
			char ch = kb.nextLine().trim().charAt(0);
			w = new Window(rbase, cbase, ch);
		}
		else
		{
			//call the appropriate method in the Window class to read the drawing specifications from file
			//and initialize the Window object w
            w = Window.readSpecFromFile(name);
            if (w == null){
                System.out.println("File Not Found!");
                System.exit(-1);
            }
		}

		//add the grids using the method you developed in Task 5
		w.addGrid();
		//initialize the shapes ArrayList by calling a get method of the Window class 
		shapes = w.getShapes();
		// Perform options
		
		boolean repeat = true;
		while(repeat)
		{
			System.out.println("\n");
			
			//you may add a call to the refreshImage() method you developed in Task 5
            w.addGrid();
			w.refreshImage();
			w.display();

			System.out.println("Add Erase Select Write Quit");
			System.out.println("Up Down Left Right + -");
            try {
                String cmd = kb.next();
                char op = cmd.toUpperCase().charAt(0);
                if(selectedShape == null && (op == 'U' || op == 'L' || op == 'D' || op == 'R' || op == '+' || op == '-' )){
                    System.out.println("Select a Shape first");
                    continue;
                }
                switch (op) {
                    case 'U':
                        selectedShape.setRb(selectedShape.getRb() - 1);
                        shapes.set(selectedIndex, selectedShape);
                        break;
                    case 'D':
                        selectedShape.setRb(selectedShape.getRb() + 1);
                        shapes.set(selectedIndex, selectedShape);
                        break;
                    case 'L':
                        selectedShape.setCb(selectedShape.getCb() - 1);
                        shapes.set(selectedIndex, selectedShape);
                        break;
                    case 'R':
                        selectedShape.setCb(selectedShape.getCb() + 1);
                        shapes.set(selectedIndex, selectedShape);
                        break;
                    case '+':
                        selectedShape.incrementSize();
                        shapes.set(selectedIndex, selectedShape);
                        break;
                    case '-':
                        selectedShape.decrementSize();
                        shapes.set(selectedIndex, selectedShape);
                        break;

                    case 'S':
                        selectShape();
                        break;
                    case 'A':
                        addShape();
                        break;
                    case 'E':
                        deleteShape();
                        break;
                    case 'W':
                        writeSpecToFile();
                        break;
                    case 'Q':
                        repeat = false;
                        break;    // quit

                    default:
                        System.out.println("Wrong option chosen!");
                }
            }catch(Exception e){
                System.out.println("Error in Operation");
            }
		} // while

		System.out.println("Thank You!");
	}

	public static void selectShape()
	{
		listShapes();
		selectedIndex = kb.nextInt();
		try {
            selectedShape = shapes.get(selectedIndex);
        }catch (Exception e){
		    System.out.println("Shape Not Present!");
        }
	}

	public static void addShape()
	{
	 	System.out.println("Enter Shape : \n0 : Line\n1 : Rectangle\n2 : Circle\n3 : Triangle\n4 : Text\n5 : Oval\nEnter Option : ");
	 	int op = kb.nextInt();
	 	kb.nextLine();
	 	int rowBase,colBase,height,length,width,rInc,cInc,rad;
	 	char drawChar;
	 	String name;
	 	String[] response;
	 	try {
            switch (op) {
                case 0:
                    System.out.println("line rowBase colBase length rowIncrement colIncrement character");
                    response = kb.nextLine().split(" ", 7);
                    name = response[0];
                    rowBase = Integer.parseInt(response[1]);
                    colBase = Integer.parseInt(response[2]);
                    length = Integer.parseInt(response[3]);
                    rInc = Integer.parseInt(response[4]);
                    cInc = Integer.parseInt(response[5]);
                    drawChar = response[6].charAt(0);
                    w.addShape(new Line(rowBase, colBase, length, rInc, cInc, drawChar));
                    break;
                case 1:
                    System.out.println("rectangle rowBase colBase height width character");
                    response = kb.nextLine().split(" ", 6);
                    name = response[0];
                    rowBase = Integer.parseInt(response[1]);
                    colBase = Integer.parseInt(response[2]);
                    height = Integer.parseInt(response[3]);
                    width = Integer.parseInt(response[4]);
                    drawChar = response[5].charAt(0);
                    w.addShape(new Rectangle(rowBase, colBase, height, width, drawChar));
                    break;
                case 2:
                    System.out.println("circle rowBase colBase radius character");
                    response = kb.nextLine().split(" ", 5);
                    name = response[0];
                    rowBase = Integer.parseInt(response[1]);
                    colBase = Integer.parseInt(response[2]);
                    rad = Integer.parseInt(response[3]);
                    drawChar = response[4].charAt(0);
                    w.addShape(new Circle(rowBase, colBase, rad, drawChar));
                    break;
                case 3:
                    System.out.println("triangle rowBase colBase height rowIncrement colIncrement character");
                    response = kb.nextLine().split(" ", 7);
                    name = response[0];
                    rowBase = Integer.parseInt(response[1]);
                    colBase = Integer.parseInt(response[2]);
                    height = Integer.parseInt(response[3]);
                    rInc = Integer.parseInt(response[4]);
                    cInc = Integer.parseInt(response[5]);
                    drawChar = response[6].charAt(0);
                    w.addShape(new Triangle(rowBase, colBase, height, rInc, cInc, drawChar));
                    break;
                case 4:
                    System.out.println("text rowBase colBase rowIncrement colIncrement string");
                    response = kb.nextLine().split(" ", 6);
                    name = response[0];
                    rowBase = Integer.parseInt(response[1]);
                    colBase = Integer.parseInt(response[2]);
                    rInc = Integer.parseInt(response[3]);
                    cInc = Integer.parseInt(response[4]);
                    String text = response[5];
                    w.addShape(new Text(rowBase, colBase, text, rInc, cInc));
                    break;
                case 5:
                    System.out.println("oval rowBase colBase heightRadius widthRadius character");
                    response = kb.nextLine().split(" ", 6);
                    name = response[0];
                    rowBase = Integer.parseInt(response[1]);
                    colBase = Integer.parseInt(response[2]);
                    height = Integer.parseInt(response[3]);
                    width = Integer.parseInt(response[4]);
                    drawChar = response[5].charAt(0);
                    w.addShape(new Oval(rowBase, colBase, height, width, drawChar));
                    break;
                default:
                    System.out.println("Enter Valid Option !");
            }
        }catch(Exception e){
	 	    System.out.println("Error in input Format");
        }
	}

	public static void deleteShape()
	{
		listShapes();
		System.out.println("Select Shape to Delete : ");
		int op = kb.nextInt();
		try {
            shapes.remove(shapes.get(op));
            w.setShapes(shapes);
        }catch (Exception e){
		    System.out.println("Shape Not Present to Delete");
        }
	}

	public static void writeSpecToFile()
	{
		System.out.println("File Name : ");
		kb.nextLine();
		String file = kb.nextLine();
		try{
		    w.writeSpecToFile(file);
		}catch(Exception e){
		    System.out.println("Error While Saving File");
        }
	}

	public static void listShapes()
	{
		shapes = w.getShapes();
		for(Shape shape:shapes){
			String[] data = shape.toString().split("\n",5);
			String name = data[0];
			switch(name.toUpperCase()){
				case "LINE":
					Line line = (Line)shape;
					System.out.println(shapes.indexOf(shape)+": line("+shape.getRb()+","+shape.getCb()+") ("+line.getLength()+") ("
							+ line.getrInc()+","+line.getcInc()+") ("+shape.getCharacter()+")");
					break;
				case "CIRCLE":
					Circle circle = (Circle) shape;
					System.out.println(shapes.indexOf(shape)+": circle("+shape.getRb()+","+shape.getCb()+") ("+circle.getRad()+") ("
							+shape.getCharacter()+")");
					break;
				case "RECTANGLE":
					Rectangle rect = (Rectangle) shape;
					System.out.println(shapes.indexOf(shape)+": rectangle("+shape.getRb()+","+shape.getCb()+") ("
							+ rect.getHeight()+","+rect.getWidth()+") ("+shape.getCharacter()+")");
					break;
				case "TRIANGLE":
					Triangle triangle = (Triangle)shape;
					System.out.println(shapes.indexOf(shape)+": triangle("+shape.getRb()+","+shape.getCb()+") ("+triangle.getHeight()+") ("
							+ triangle.getrInc()+","+triangle.getcInc()+") ("+shape.getCharacter()+")");
					break;
				case "TEXT":
					Text text = (Text)shape;
					System.out.println(shapes.indexOf(shape)+": text("+shape.getRb()+","+shape.getCb()+") ("+text.getText()+") ("
							+ text.getrInc()+","+text.getcInc()+") ("+shape.getCharacter()+")");
					break;
				case "OVAL":
					Oval oval = (Oval) shape;
					System.out.println(shapes.indexOf(shape)+": rectangle("+shape.getRb()+","+shape.getCb()+") ("
							+ oval.getHeight()+","+oval.getWidth()+") ("+shape.getCharacter()+")");
					break;
			}
		}
	}

}

