package LineWithoutCrossings;

//this class allows us to create coordinates on subspace with two parameters: X and Y
class Point {
    private int x;
    private int y;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return (this.getX() + ":" + this.getY());

    }

}
