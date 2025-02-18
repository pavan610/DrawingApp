import java.io.*;
import java.util.*;

public class Window
{
   protected int rows;
   protected int cols;
   protected ArrayList<Shape> shapes;
   protected char [][] cells;
   protected char border;

   public ArrayList<Shape> getShapes() {
      return shapes;
   }

   public void setShapes(ArrayList<Shape> shapes) {
      this.shapes = shapes;
   }
   /*
		rows = number of rows available for drawing, borders excluded
		cols = number of cols available for drawing, borders excluded
		cells = 2D array of char depicting the drawing, its size should be: [rows+2][cols+2]
		shapes = ordered list of shapes (You can use Arrays, or LinkedList as well if you want)
	*/

   public Window(int rows, int cols, char border)
   {
      //Initialize everything
      this.rows = rows;
      this.cols = cols;
      this.border = border;
      this.cells = new char[rows+2][cols+2];
      this.shapes = new ArrayList<Shape>();
      //Make a call to addBorders()
      addBorders(border);
   }

   protected void addBorders(char ch)
   {
      //add the border using ch as the character
      for(int i =0;i<=this.rows+1;i++){
         for(int j = 0;j<=this.cols+1;j++){
            if(i==0 || j == this.cols+1 || i == this.rows+1 || j == 0) this.setCell(i,j,ch);
         }
      }
   }

   public void setCell(int row, int col, char ch) {
      try {
         this.cells[row][col] = ch;
      }catch(Exception e){
      }
   }


   public void display() {
      //display the content of the array to the screen
      for (int i = 0; i <= this.rows + 1; i++) {
         for (int j = 0; j <= this.cols + 1; j++) {
            System.out.print(cells[i][j]+" ");
         }
         System.out.println();
      }
   }

   public void addShape(Shape shape)
   {
      //add a shape to the collection
      this.shapes.add(shape);
      //call the draw() method of the shape to draw itself on this window
      try {
         shape.draw(this);
      }catch(Exception e){
         System.out.println("Error While Drawing");
      }
   }

	// This method is needed by classes of type Shape for method draw()
	// It cannot be private
	// We choose it to be accessible at the package level as the safest
	// choice open to us


   public void addGrid(){
      for(int i = 1;i <= this.cols;i++) {
         char draw = Character.forDigit(i%10,10);
         this.setCell(0,i,draw);
         this.setCell(this.rows+1,i,draw);
      }
      for(int i = 1;i <= this.rows;i++) {
         char draw = Character.forDigit(i%10,10);
         this.setCell(i,0,draw);
         this.setCell(i,this.cols+1,draw);
      }
   }

   public void refreshImage(){
      for(int i = 1;i <= this.rows;i++){
         for(int j = 1;j<=this.cols;j++){
            this.setCell(i,j,'\0');
         }
      }
      for(Shape shape:this.shapes){
         shape.draw(this);
      }
   }


   void writeSpecToFile(String fileName){
      try{
         FileWriter fileWriter = new FileWriter(fileName);
         //window details
         fileWriter.write(this.rows+" "+this.cols+"\n"+this.border+"\n.\n");

         //overrides toString
         for( Shape shape : this.shapes){
            fileWriter.write(shape.toString());
         }
         fileWriter.close();
      }catch(Exception e){
         System.out.println(e);
      }
   }

   public static Window readSpecFromFile(String fileName){
      try{
         File file = new File(fileName);
         Scanner scanner = new Scanner(file);
         int rows = scanner.nextInt();
         int cols = scanner.nextInt();
         scanner.nextLine();
         char border = scanner.nextLine().charAt(0);
         scanner.nextLine();
         Window window = new Window(rows,cols,border);
         while(scanner.hasNext()){
            String type = scanner.nextLine();
            if(type.equals("line")){
               int baseRow = scanner.nextInt();
               int baseCol = scanner.nextInt();
               int length = scanner.nextInt();
               int rInc = scanner.nextInt();
               int cInc = scanner.nextInt();
               scanner.nextLine();
               char drawChar = scanner.nextLine().charAt(0);
               scanner.nextLine();
               window.addShape(new Line(baseRow,baseCol,length,rInc,cInc,drawChar));
            }else if(type.equals("rectangle")){
               int baseRow = scanner.nextInt();
               int baseCol = scanner.nextInt();
               int height = scanner.nextInt();
               int width = scanner.nextInt();
               scanner.nextLine();
               char drawChar = scanner.nextLine().charAt(0);
               scanner.nextLine();
               window.addShape(new Rectangle(baseRow,baseCol,height,width,drawChar));
            }else if(type.equals("circle")){
               int baseRow = scanner.nextInt();
               int baseCol = scanner.nextInt();
               int rad = scanner.nextInt();
               scanner.nextLine();
               char drawChar = scanner.nextLine().charAt(0);
               scanner.nextLine();
               window.addShape(new Circle(baseRow,baseCol,rad,drawChar));
            }else if(type.equals("triangle")){
               int baseRow = scanner.nextInt();
               int baseCol = scanner.nextInt();
               int height = scanner.nextInt();
               int rInc = scanner.nextInt();
               int cInc = scanner.nextInt();
               scanner.nextLine();
               char drawChar = scanner.nextLine().charAt(0);
               scanner.nextLine();
               window.addShape(new Triangle(baseRow,baseCol,height,rInc,cInc,drawChar));
            }else if(type.equals("text")){
               int baseRow = scanner.nextInt();
               int baseCol = scanner.nextInt();
               scanner.nextLine();
               String text = scanner.nextLine();
               int rInc = scanner.nextInt();
               int cInc = scanner.nextInt();
               scanner.nextLine();
               scanner.nextLine();
               window.addShape(new Text(baseRow,baseCol,text,rInc,cInc));
            }else if(type.equals("oval")){
               int baseRow = scanner.nextInt();
               int baseCol = scanner.nextInt();
               int height = scanner.nextInt();
               int width = scanner.nextInt();
               scanner.nextLine();
               char drawChar = scanner.nextLine().charAt(0);
               scanner.nextLine();
               window.addShape(new Oval(baseRow,baseCol,height,width,drawChar));
            }
         }
         return window;
      }catch(Exception e){return null;}
   }

}
