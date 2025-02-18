
public abstract class Shape
{

	private int rb;				// row position of base point
	private int cb;				// col position of base point
	private char character;		// drawing character

	public Shape(){};

	public Shape(int rb, int cb, char character)
	{
		this.rb = rb;
		this.cb = cb;
		this.character = character;
	}


	//getters
	public int getRb() {
		return rb;
	}

	public int getCb() {
		return cb;
	}

	public char getCharacter() {
		return character;
	}

	public void setRb(int rb) {
		this.rb = rb;
	}

	public void setCb(int cb) {
		this.cb = cb;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public abstract void draw(Window window);

	public abstract void incrementSize();

	public abstract void decrementSize();

}