
public class Rectangle extends Shape
{
	private int height;
   	private int width;

    //define the constructor following the signature in the specification
	public Rectangle(int rowBase,int colBase,int height,int width,char drawChar){
		super(rowBase,colBase,drawChar);
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void draw(Window window)
   	{
   		//treat the rectangle as four lines
		int row = super.getRb() , column = super.getCb();

   		//Line line1 = new Line(/*appropriate parameters goes here*/);
		Line line1 = new Line(row, column, this.width, 0, 1, super.getCharacter());

		//similarly line2, line3, line4
		Line line2 = new Line(row, column, this.height, 1, 0, super.getCharacter());
		Line line3 = new Line(row+this.height, column, this.width, 0, 1, super.getCharacter());
		Line line4 = new Line(row, column+this.width, this.height, 1, 0, super.getCharacter());

		//now use the draw method in the Line class to draw the rectangle
		line1.draw(window);
		line2.draw(window);
		line3.draw(window);
		line4.draw(window);
	}

	@Override
	public void incrementSize() {
		this.width++;
		this.height++;
	}

	@Override
	public void decrementSize() {
		this.width--;
		this.height--;
	}

	@Override
	public String toString(){
		return "rectangle\n"+super.getRb()+" "+super.getCb()+" "+this.height+" "+this.width+"\n"+super.getCharacter()+"\n.\n";
	}


}
