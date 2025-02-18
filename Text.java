

public class Text extends Shape
{
   private String text;
   private int rInc;
   private int cInc;

   //define the constructor following the signature in the specification
   public Text(int rowBase,int colBase,String text,int rInc,int cInc){
      super(rowBase,colBase,'*');
      this.rInc = rInc;
      this.cInc = cInc;
      this.text = text;

   }

   public String getText() {
      return text;
   }

   public int getrInc() {
      return rInc;
   }

   public int getcInc() {
      return cInc;
   }

   public void draw(Window window)
   {
      //assuming row position of the base point of this triangle is 'rb'
      int rb = super.getRb();

      //assuming column position of the base point of this triangle is 'cb'
      int cb = super.getCb();

      for(int i = 0; i < text.length(); i++)
      {
         char ch = text.charAt(i);
         int row = rb + i * rInc;
         int col = cb + i * cInc;

         //appropriate call to setCell() method of the Window class...
         window.setCell(row,col,ch);
      }
   }

   @Override
   public void incrementSize() {
      this.text = this.text+" ";
   }

   @Override
   public void decrementSize() {
      this.text = this.text.substring(0,this.text.length()-1);
   }

   @Override
   public String toString(){
      return "text\n"+super.getRb()+" "+super.getCb()+" "+"\n"+this.text+"\n"+this.rInc+" "+this.cInc+"\n.\n";
   }
}
