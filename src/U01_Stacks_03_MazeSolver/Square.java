package U01_Stacks_03_MazeSolver;

public class Square {

    public static final int EMPTY = 0;
    public static final int WALL = 1;
    public static final int START = 2;
    public static final int EXIT = 3;

    public static final char WORKING = 'o';
    public static final char EXPLORED = '.';
    public static final char ON_EXIT_PATH = 'x';
    public static final char UNKNOWN = '_';

    private int row, col;
    private int type;
    private char status;

    private Square previous;

    public Square(int row, int col, int type) {
        this.row = row;
        this.col = col;
        this.type = type;
        status = UNKNOWN;
        previous = null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getType() {
        return type;
    }

    public char getStatus() {
        return status;
    }

    public void reset() {
        if (type == EMPTY && (status == WORKING || status == EXPLORED))
            status = UNKNOWN;
            previous = null;
    }

    @Override
    public String toString() {
        if (type == WALL)
            return "# ";
        if (type == START)
            return "S ";
        if (type == EXIT)
            return "E ";
        return status + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Square square = (Square) o;
        return row == square.row &&
                col == square.col;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Square getPrevious() {
        return previous;
    }

    public void setPrevious(Square now) {
        previous = now;
    }
}
