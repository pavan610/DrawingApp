public class Line extends Shape
{
   private int length;	// line would have (length + 1) characters
   private int rInc;   // -1 (go up), 0 or 1 (go down)
   private int cInc;   // -1, 0 or 1
               // if both = 0, then have a point


   public int getLength() {
      return length;
   }

   public int getrInc() {
      return rInc;
   }

   public int getcInc() {
      return cInc;
   }

   //define the constructor following the signature in the specification
   public Line(int rowBase,int colBase,int length,int rInc,int cInc,char drawChar){
      super(rowBase,colBase,drawChar);
      this.length = length;
      this.rInc = rInc;
      this.cInc = cInc;
   }

   public void draw(Window window)
   {
      for(int i = 0,j = 0; i <= this.length && j <= this.length && i >= -length && j >= -length; i+=this.rInc , j+=this.cInc)
      {
         //determine appropriate row, col values
         int r = super.getRb()+i , c = super.getCb()+j;

         //then make a call to setCell() method of the Window class
         window.setCell(r,c,super.getCharacter());
      }
   }

   @Override
   public void incrementSize() {
      this.length++;
   }

   @Override
   public void decrementSize() {
      this.length--;
   }

   @Override
   public String toString(){
      return "line\n"+super.getRb()+" "+super.getCb()+" "+this.length+" "+this.rInc+" "+this.cInc+"\n"+super.getCharacter()+"\n.\n";
   }


}
