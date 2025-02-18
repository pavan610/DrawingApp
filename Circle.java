

public class Circle extends Shape
{
   private int rad;    // radius

   public int getRad() {
      return rad;
   }

   //define the constructor following the signature in the specification
   public Circle(int rowBase,int colBase,int rad,char drawChar){
      super(rowBase,colBase,drawChar);
      this.rad = rad;
   }

   public void draw(Window window)
   {
      //assuming row position of the center of this circle is 'rb'
      int rb = super.getRb();

      //assuming column position of the center of this circle is 'cb'
      int cb = super.getCb();

      //Attempt to draw 20 points and a possible way is shown below
      //you can come up with other possible logic for drawing a circle as well

      for(int i = 0; i < 20; i++)
      {
         double angle = i * Math.PI/10; //radian angle
         int rdif = (int) Math.round(this.rad * Math.cos(angle));
         int row = rb + rdif;
         int cdif = (int) Math.round(this.rad * Math.sin(angle));
         int col = cb + cdif;

         //now row and col forms a point on the perimeter of the circle
         //appropriate call to setCell() method of the Window class...
         window.setCell(row,col,super.getCharacter());
      }
   }

   @Override
   public void incrementSize() {
      this.rad++;
   }

   @Override
   public void decrementSize() {
      this.rad--;
   }

   @Override
   public String toString(){
      return "circle\n"+super.getRb()+" "+super.getCb()+" "+this.rad+"\n"+super.getCharacter()+"\n.\n";
   }
}
