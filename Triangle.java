

public class Triangle extends Shape
{
   	private int height;	// height of isosceles triangle
   	private int rInc;   // only (1, 0), (-1,0), (0,1) and (0,-1)
   	private int cInc;   // are allowed


    //define the constructor following the signature in the specification
	public Triangle(int rowBase,int colBase,int height,int rInc,int cInc,char drawChar){
		super(rowBase,colBase,drawChar);
		this.height = height;
		this.rInc = rInc;
		this.cInc = cInc;
	}

	public int getHeight() {
		return height;
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

		//assuming the drawing character is 'character'
		char character = super.getCharacter();

		//assuming the constructor in the Line class has been defined according to the specification
      	if(rInc == 0)//when the height vector goes right or left from the base point
      	{
			Line line1 = new Line(rb, cb, height, -1, cInc, character);
			Line line2 = new Line(rb, cb, height, 1, cInc, character); 
			Line line3 = new Line(rb - height, cb + cInc * height, 2 *height,
				1, 0, character);

			//now use the draw method in the Line class to draw the triangle
			line1.draw(window);
			line2.draw(window);
			line3.draw(window);

		}
		else if(cInc == 0)//when the height vector goes up or down from the base point
		{
			Line line1 = new Line(rb, cb, height, rInc, -1, character);
			Line line2 = new Line(rb, cb,  height, rInc, 1, character);
			Line line3 = new Line(rb + rInc * height, cb - height,
				 2*height, 0, 1, character);

			//now use the draw method in the Line class to draw the triangle
			line1.draw(window);
			line2.draw(window);
			line3.draw(window);

		}
	}

	@Override
	public void incrementSize() {
		this.height++;
	}

	@Override
	public void decrementSize() {
		this.height--;
	}

	@Override
	public String toString(){
		return "triangle\n"+super.getRb()+" "+super.getCb()+" "+this.height+" "+this.rInc+" "+this.cInc+"\n"+super.getCharacter()+"\n.\n";
	}
}
