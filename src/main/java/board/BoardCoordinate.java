package board;

/**
 * This class contains the x and y coordinate of a given cell
 */
@SuppressWarnings("unused")
public class BoardCoordinate {
    private int x;
    private int y;

    public BoardCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return this.x + ", " + this.y;
    }
}
