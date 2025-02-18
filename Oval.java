public class Oval extends Shape {

    private int width;
    private int height;


    public Oval(int rowBase, int colBase, int width, int height, char character) {
        super(rowBase, colBase, character);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Window window) {
        //assuming row position of the center of this circle is 'rb'
        int rb = super.getRb();

        //assuming column position of the center of this circle is 'cb'
        int cb = super.getCb();

        //Attempt to draw 20 points and a possible way is shown below
        //you can come up with other possible logic for drawing a circle as well

        for(int i = 0; i < 20; i++)
        {
            double angle = i * Math.PI/10; //radian angle
            int rdif = (int) Math.round(this.width * Math.cos(angle));
            int row = rb + rdif;
            int cdif = (int) Math.round(this.height * Math.sin(angle));
            int col = cb + cdif;

            //now row and col forms a point on the perimeter of the circle
            //appropriate call to setCell() method of the Window class...
            window.setCell(row,col,super.getCharacter());
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void incrementSize() {
        this.height++;
        this.width++;
    }

    @Override
    public void decrementSize() {
        this.height--;
        this.width--;
    }

    @Override
    public String toString(){
        return "oval\n"+super.getRb()+" "+super.getCb()+" "+this.height+" "+this.width+"\n"+super.getCharacter()+"\n.\n";
    }
}
